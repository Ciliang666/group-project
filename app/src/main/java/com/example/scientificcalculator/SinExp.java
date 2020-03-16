package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: SinExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of sin
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class SinExp extends Exp {

    private Exp exp;

    public SinExp(Exp exp) {
        this.exp = exp;
    }

    public String show() {
        return "sin" + "(" + exp.show() + ")";
    }

    /**
     * This function will calculate the sin function of exp
     * The value of exp is degree format
     *
     * @return BigDecimal format of sin of exp
     */
    public BigDecimal evaluate() throws Exception {
        return (new BigDecimal(Math.sin(exp.evaluate().doubleValue() )));
    }
}