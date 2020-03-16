package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: TanExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of tan
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class TanExp extends Exp {
    private Exp exp;

    public TanExp (Exp exp){
        this.exp = exp;
    }

    public String show(){
        return "tan" + "(" + exp.show() + ")";
    }


    /**
     * This function will calculate the tan function of exp
     * The value of exp is degree format
     *
     * @return BigDecimal format of tan of exp
     */
    public BigDecimal evaluate() throws Exception {
        return (new BigDecimal(Math.tan(exp.evaluate().doubleValue())));
    }
}
