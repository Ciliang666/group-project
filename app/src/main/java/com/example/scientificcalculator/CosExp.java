package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: CosExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of cos
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class CosExp extends Exp {
    private Exp exp;

    public CosExp (Exp exp){
        this.exp = exp;
    }

    public String show(){
        return "cos" + "(" + exp.show() + ")";
    }

    /**
     * This function will calculate the cos function of exp
     * The value of exp is degree format
     * @return BigDecimal format of cos of exp
     */
    public BigDecimal evaluate() throws Exception{
        return (new BigDecimal(Math.cos(exp.evaluate().doubleValue())));
    }

}
