package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: AddExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of addition
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class AddExp extends Exp {
    private Exp exp;
    private Exp term;

    public AddExp(Exp term, Exp exp) {
        this.term = term;
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(" + term.show() + "+" + exp.show() + ")";
    }

    /**
     * This function will calculate the summation of exp and term
     * @return BigDecimal format of summation
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        return (term.evaluate().add(exp.evaluate()));
    }

}
