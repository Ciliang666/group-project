package com.example.scientificcalculator;
import android.util.Log;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp>(=<exp>+<term>) | <exp> - <term>
 *  <term>   ::= <factor> | <factor> × <term>(=<term>×<factor>) | <term> ÷ <factor>
 *  <factor> ::= <unsigned integer> | (<exp>) | <unsigned>.<unsigned> | sin(<exp>) | cos(<exp>) | tan(<exp>) |
 *             = sin-1(<exp>) | cos-1(<exp>) | tan-1(<exp>) | ln(<exp>) | log(<exp>) | logxY(<exp>,<exp>) | abs(<exp>)
 *             = sqrt(<exp>) | cubroot(<exp>) | nCr(<exp>) | nPr(<exp>) | gcd(<exp>,<exp>)
 *             = lcm(<exp>,<exp>) | abs(<exp>) | sgn(<exp>) | ran#
 *
 * Note: the order of parsing is from the right to the left of strings
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class RightParser {

    RightTokenizer _tokenizer;
    BigDecimal x;

    public RightParser(RightTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public RightParser(RightTokenizer tokenizer, BigDecimal x){
        _tokenizer = tokenizer;
        this.x = x;
    }

    public Exp parseExp() throws Exception{

        Exp term = parseTerm();

        // if current token is "+", then perform AddExp by adding the last exp and the next exp
        if(_tokenizer.hasNext() && _tokenizer.current().token().equals("+")) {
            _tokenizer.next();
            Exp exp = parseExp();
            return new AddExp(exp,term);
        }

        // if current token is "-", then perform SubExp by subtracting the last exp by the next exp
        else if(_tokenizer.hasNext() && _tokenizer.current().token().equals("-")) {
            _tokenizer.next();
            Exp exp = parseExp();
            return new SubExp(exp,term);
        }

        // if current token is ")" which means the "(" of the last exp are next to ")" of the next exp.
        // In other words, there no any operation sign between exps, which is not supported in the current version of system
        else if(_tokenizer.hasNext() && _tokenizer.current().token().equals(")")){

            throw new Exception("Unsupported format, please specify operation sign");
        }

        // otherwise it is a term
        else {
            return term;
        }
    }

    public Exp parseTerm() throws Exception{
        Exp factor = parseFactor();

        // if current token is "×", then perform MultExp by multiplying the last exp and the next exp
        if(_tokenizer.hasNext() && _tokenizer.current().token().equals("×")) {
            _tokenizer.next();
            Exp term = parseTerm();
            return new MultExp(term, factor);
        }

        // if current token is "÷", then perform DivExp by dividing the last exp by the next exp
        else if(_tokenizer.hasNext() && _tokenizer.current().token().equals("÷")) {
            _tokenizer.next();
            Exp term = parseTerm();
            return new DivExp(term, factor);
        }

        // otherwise it is a factor
        else {
            return factor;
        }
    }

    public Exp parseFactor() throws Exception{
        Exp ele = null;

        // if a string starts with "×"/"÷"/"+"/"-", then it is an invalid string for parsing
        if(_tokenizer.current()==null){
            if(_tokenizer.getLastToken().token().equals("×")||_tokenizer.getLastToken().token().equals("÷")||
                    _tokenizer.getLastToken().token().equals("+")||_tokenizer.getLastToken().token().equals("-")) {
                throw new Exception("(Please perfect format)");
            }
        }

        // perform parsing in an exp
        if(!(_tokenizer.current().token().equals(")"))) {

            // if the second last token is not a number ( ")" is the last token of an exp), then it is an incomplete
            // string for parsing
            if(_tokenizer.current().type()!=Token.Type.INT && _tokenizer.current().type()!=Token.Type.DECIMAL &&
                    _tokenizer.current().type()!=Token.Type.pi && _tokenizer.current().type()!=Token.Type.e &&
                    _tokenizer.current().type()!=Token.Type.random && _tokenizer.current().type()!= Token.Type.varX){
                throw new Exception("(Please perfect format)");
            }

            // if a token in an exp is an integer
            if(_tokenizer.current().type()==Token.Type.INT) {
                ele = new IntExp(new BigInteger(_tokenizer.current().token()));
            }

            // if a token in an exp is a decimal
            else if (_tokenizer.current().type()==Token.Type.varX){
                ele = new XExp(x);
            }
            else if(_tokenizer.current().type()==Token.Type.DECIMAL){
                ele =  new DecimalExp(new BigDecimal(_tokenizer.current().token()));
            }
            else if (_tokenizer.current().type()==Token.Type.varX){
                ele = new XExp(x);
            }

            // if a token in an exp is pi
            else if(_tokenizer.current().type()==Token.Type.pi){
                ele =  new DecimalExp(new BigDecimal(Math.PI));
            }

            // if a token in an exp is e
            else if(_tokenizer.current().type()==Token.Type.e){
                ele =  new DecimalExp(new BigDecimal(Math.E));
            }

            // if a token in an exp is a random number
            else if(_tokenizer.current().type()==Token.Type.random){
                ele =  new RandomExp();
            }

            // get off "(" of an exp
            _tokenizer.next();
            return ele;
        }

        // if an exp is about to be parsed  (the current token is ")")
        else {
            _tokenizer.next();
            Exp exp = parseExp();

            // if parsing is performed within a token with two parameters
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.comma){
                _tokenizer.next();
                Exp anotherExp= parseExp();
                _tokenizer.next();

                // if the token is logxY, then perform LogXYExp by applying the two exp before the 'logxy' token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.logxy){
                    ele= new LogXYExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is nCr, then perform CombinationExp by applying the two exp before the 'nCr' token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.combination){
                    ele= new CombinationExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is nPr, then perform PermutationExp by applying the two exp before the 'nPr' token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.permutation){
                    ele= new PermutationExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is gcd, then perform GCDExp by applying the two exp before the 'gcd' token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.gcd){
                    ele= new GCDExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is lcm, then perform LCMExp by applying the two exp before the 'lcm' token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.lcm){
                    ele= new LCMExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is YPowerofX, then perform YPowerOfXExp by applying the two exp before the YPowerOfX token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.ypower){
                    ele= new YPowerOfXExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

                // if the token is XRoot, then perform XRootExp by applying the two exp before the XRootExp token
                if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.xroot){
                    ele= new XRootExp(anotherExp, exp);
                    _tokenizer.next();
                    return ele;
                }

            }

            // if parsing is performed within a token with one parameters
            _tokenizer.next();

            // if the token is sin, then perform SinExp by applying the exp before the sin token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.sin){
                Exp factor = new SinExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is arcsin, then perform ArcSinExp by applying the exp before the arcsin token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.arcsin){
                Exp factor = new ArcSinExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is cos, then perform CosExp by applying the exp before the cos token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.cos){
                Exp factor = new CosExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is arccos, then perform ArcCosExp by applying the exp before the arccos token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.arccos){
                Exp factor = new ArcCosExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is tan, then perform TanExp by applying the exp before the tan token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.tan){
                Exp factor = new TanExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is arctan, then perform ArcTanExp by applying the exp before the arctan token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.arctan){
                Exp factor = new ArcTanExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is ln, then perform InExp by applying the exp before the ln token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.ln){
                Exp factor = new LnExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is log, then perform InExp by applying the exp before the log token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.log){
                Exp factor = new LogExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is sqrt, then perform SquareRootExp by applying the exp before the sqrt token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.sqrt){
                Exp factor = new SquareRootExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is cbrt, then perform CubicRootExp by applying the exp before the cbrt token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.cbrt){
                Exp factor = new CubicRootExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is abs, then perform AbsExp by applying the exp before the abs token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.abs){
                Exp factor = new AbsExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is sgn, then perform SgnExp by applying the exp before the sgn token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.sgn){
                Exp factor = new SgnExp(exp);
                _tokenizer.next();
                return factor;
            }

            // if the token is minusonepower, then perform MinusOnePowerExp by applying the exp before the minusonepower token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.minusonepower){
                ele= new MinusOnePowerExp(exp);
                _tokenizer.next();
                return ele;
            }

            // if the token is square, then perform SquareExp by applying the exp before the square token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.square){
                ele= new SquareExp(exp);
                _tokenizer.next();
                return ele;
            }

            // if the token is cube, then perform CubeExp by applying the exp before the cube token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.cube){
                ele= new CubeExp(exp);
                _tokenizer.next();
                return ele;
            }

            // if the token is TenBaseX, then perform TenBaseXExp by applying the exp before the TenBaseX token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.tenbasex){
                ele= new TenBaseXExp(exp);
                _tokenizer.next();
                return ele;
            }

            // if the token is eBaseX, then perform EBaseXExp by applying the exp before the eBaseX token
            if(_tokenizer.current() != null && _tokenizer.current().type() == Token.Type.ebasex){
                ele= new EBaseXExp(exp);
                _tokenizer.next();
                return ele;
            }
            return exp;
        }
    }
}
