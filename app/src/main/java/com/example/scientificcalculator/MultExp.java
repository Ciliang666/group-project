package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: MultExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of multiplication
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class MultExp extends Exp {
    private Exp term;
    private Exp factor;


    public MultExp(Exp factor, Exp term) {
        this.factor = factor;
        this.term = term;
    }

    @Override
    public String show() {
        return "(" + factor.show() + "×" + term.show() + ")";
    }

    /**
     * This function will calculate term times factor
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception{
        return (factor.evaluate().multiply(term.evaluate()));
    }

}
