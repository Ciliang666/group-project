package com.example.scientificcalculator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Name: ArcCosExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of arccos
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class ArcCosExp extends Exp {
    private Exp exp;
    public ArcCosExp (Exp exp){
        this.exp = exp;
    }

    public String show(){
        return "cos\u207B\u00B9" + "(" + exp.show() + ")";
    }

    /**
     * This function will calculate the Arccos function of exp
     * The range of exp value is [-1,1], and an exception will be thrown if it is out of range
     * @return BigDecimal degree format of Arccos
     */
    public BigDecimal evaluate() throws Exception{
        if(exp.evaluate().compareTo(new BigDecimal(new BigInteger("1")))<=0 &&
                exp.evaluate().compareTo(new BigDecimal(new BigInteger("-1")))>=0){
            return(BigDecimal.valueOf(Math.acos(exp.evaluate().doubleValue())));
        }
        else{
            throw new Exception("Range Error: Unsupported Trigonometric function of Complex");
        }
    }
}