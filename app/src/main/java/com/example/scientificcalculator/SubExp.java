package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: SubExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of subtraction
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class SubExp extends Exp {
    private Exp exp;
    private Exp term;


    public SubExp(Exp term, Exp exp) {
        this.term = term;
        this.exp = exp;

    }

    @Override
    public String show() {
        return "(" + term.show() + "-" + exp.show() + ")";
    }

    /**
     * This function will calculate 'term is subtracted by exp'
     * @return BigDecimal format of difference
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        return (term.evaluate().subtract(exp.evaluate()));
    }

}
