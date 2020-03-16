package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: SquareExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of square
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class SquareExp extends Exp {
    private Exp x;
    public SquareExp(Exp x) {
        this.x = x;
    }

    @Override
    public String show() {
        return "x\u00B2(" + x.show() +")";
    }

    /**
     * This function will calculate the square of x
     * @return BigDecimal format of square of exp
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        return (x.evaluate().pow(2));
    }
}
