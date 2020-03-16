package com.example.scientificcalculator;

/**
 * RightTokenizer - this uses the StreamTokenizer class to make a simpler tokenizer
 * which provides a stream of tokens which include:
 * sin, cos, tan, arcsin, arccos, arctan, ln, log, logxY, abs, sqrt, cubroot, nCr,
 * nPr, gcd, lcm, abs, sgn, ran#, add, sub, muti, div, decimal, int
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class RightTokenizer extends Tokenizer {

    private String _buffer;		//save text
    private Token currentToken;	//save token extracted from next()
    private Token lastToken;
    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToke
     */
    public RightTokenizer(String text) throws Exception{
        _buffer = text;		// save input text (string)
        next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code _buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() throws Exception{
        boolean hasDecimal = false;
        boolean isDecimal = false;
        _buffer = _buffer.trim(); // remove whitespace

        if(_buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
        }
        char lastChar = _buffer.charAt(_buffer.length()-1);
        if(lastChar=='+') {
            currentToken = new Token("+", Token.Type.ADD);
        }
        if(lastChar=='-') {
            currentToken = new Token("-", Token.Type.SUB);
        }
        if(lastChar=='(') {
            currentToken = new Token("(", Token.Type.LBRA);
        }
        if(lastChar==')') {
            currentToken = new Token(")", Token.Type.RBRA);
        }
        if(lastChar=='×') {
            currentToken = new Token("×", Token.Type.MUL);
        }
        if(lastChar=='÷') {
            currentToken = new Token("÷", Token.Type.DIV);
        }
        if(lastChar=='π') {
            currentToken = new Token("π", Token.Type.pi);
        }
        if(lastChar=='e') {
            currentToken = new Token("e", Token.Type.e);
        }
        if(lastChar=='.'){
            throw new Exception("Hint: Invalid decimal");
        }
        if(lastChar==','){
            currentToken = new Token(",", Token.Type.comma);
        }
        if(Character.isDigit(lastChar)) {
            int iter = 0;
            while(iter<_buffer.length()){
                if(Character.isDigit(_buffer.charAt(_buffer.length()-1-iter))) {
                    iter++;
                    if(hasDecimal){
                        isDecimal = true;
                    }
                }
                else if(_buffer.charAt(_buffer.length()-1-iter) == '.'){
                    if(hasDecimal){
                        throw new Exception("Error: Invalid decimal");
                    }
                    iter++;
                    hasDecimal = true;
                }
                else break;
            }
            iter--;
            if(hasDecimal && isDecimal){
                currentToken = new Token(_buffer.substring(_buffer.length()-1-iter), Token.Type.DECIMAL);
            }
            else if(hasDecimal){
                throw new Exception("Error: Invalid decimal");
            }
            else {
                currentToken = new Token(_buffer.substring(_buffer.length()-1-iter), Token.Type.INT);
            }
        }
        if (lastChar=='X'){
            currentToken = new Token("X", Token.Type.varX);
        }

        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("sin")){
            currentToken = new Token("sin", Token.Type.sin);
        }

        if(_buffer.length()>4 && _buffer.substring(_buffer.length()-5).equals("sin\u207B\u00B9")){
            currentToken = new Token("sin\u207B\u00B9", Token.Type.arcsin);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("cos")){
            currentToken = new Token("cos", Token.Type.cos);
        }
        if(_buffer.length()>4 && _buffer.substring(_buffer.length()-5).equals("cos\u207B\u00B9")){
            currentToken = new Token("cos\u207B\u00B9", Token.Type.arccos);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("tan")){
            currentToken = new Token("tan", Token.Type.tan);
        }
        if(_buffer.length()>4 && _buffer.substring(_buffer.length()-5).equals("tan\u207B\u00B9")){
            currentToken = new Token("tan\u207B\u00B9", Token.Type.arctan);
        }
        if(_buffer.length()>1 && _buffer.substring(_buffer.length()-2).equals("ln")){
            currentToken = new Token("ln", Token.Type.ln);
        }
        if(_buffer.length()>4 && _buffer.substring(_buffer.length()-5).equals("log\u2093y")){
            currentToken = new Token("log\u2093y", Token.Type.logxy);
        }
        if(_buffer.length()>1 && _buffer.substring(_buffer.length()-2).equals("X\u02B8")){
            currentToken = new Token("X\u02B8", Token.Type.ypower);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("x\u207B\u00B9")){
            currentToken = new Token("x\u207B\u00B9", Token.Type.minusonepower);
        }
        if(_buffer.length()>3 && _buffer.substring(_buffer.length()-4).equals("\u02E3\u221Ay\u0305")){
            currentToken = new Token("\u02E3\u221Ay\u0305", Token.Type.xroot);
        }
        if(_buffer.length()>1 && _buffer.substring(_buffer.length()-2).equals("x\u00B2")){
            currentToken = new Token("x\u00B2", Token.Type.square);
        }
        if(_buffer.length()>1 && _buffer.substring(_buffer.length()-2).equals("x\u00B3")){
            currentToken = new Token("x\u00B3", Token.Type.cube);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("log")){
            currentToken = new Token("log", Token.Type.log);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("10^")){
            currentToken = new Token("10^", Token.Type.tenbasex);
        }
        if(_buffer.length()>1 && _buffer.substring(_buffer.length()-2).equals("e^")){
            currentToken = new Token("e^", Token.Type.ebasex);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("MOD")){
            currentToken = new Token("MOD", Token.Type.mod);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("nCr")){
            currentToken = new Token("nCr", Token.Type.combination);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("nPr")){
            currentToken = new Token("nPr", Token.Type.permutation);
        }
        if(_buffer.length()>0 && _buffer.substring(_buffer.length()-1).equals("\u221A")){
            currentToken = new Token("\u221A", Token.Type.sqrt);
        }
        if(_buffer.length()>0 && _buffer.substring(_buffer.length()-1).equals("\u221B")){
            currentToken = new Token("\u221B", Token.Type.cbrt);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("gcd")){
            currentToken = new Token("gcd", Token.Type.gcd);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("lcm")){
            currentToken = new Token("lcm", Token.Type.lcm);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("abs")){
            currentToken = new Token("abs", Token.Type.abs);
        }
        if(_buffer.length()>2 && _buffer.substring(_buffer.length()-3).equals("sgn")){
            currentToken = new Token("sgn", Token.Type.sgn);
        }
        if(_buffer.length()>3 && _buffer.substring(_buffer.length()-4).equals("ran#")){
            currentToken = new Token("ran#", Token.Type.random);
        }
        //////////////////////

        // Remove the extracted token from buffer
        lastToken = currentToken;
        int tokenLen = currentToken.token().length();
        _buffer = _buffer.substring(0, _buffer.length() - tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     * @return type: Token
     */
    public Token current() {
        return currentToken;
    }

    public Token getLastToken(){
        return lastToken;
    }
    /**
     *  check whether there still exists another tokens in the buffer or not
     * @return type: boolean
     */
    public boolean hasNext() {
        return currentToken != null;
    }

}
