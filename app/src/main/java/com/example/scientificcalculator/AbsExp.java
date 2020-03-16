package com.example.scientificcalculator;

import java.math.BigDecimal;
/**
 * Name: AbsExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of absolute value
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class AbsExp extends Exp {
    private Exp exp;

    public AbsExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "abs" +"(" + exp.show() + ")";
    }

    /**
     * This function will calculate absolute value
     * @return BigDecimal format of absolute value
     */
    @Override
    public BigDecimal evaluate() throws Exception {
       return exp.evaluate().abs();
    }
}
