package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: CubeRootExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of cube root
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class CubicRootExp extends Exp {
    private Exp exp;

    public CubicRootExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "\u221B" +"(" +exp.show() + ")";
    }

    /**
     * This function will calculate the cube ro function of x
     * @return BigDecimal format of cube root of x
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        return new BigDecimal(Math.cbrt(exp.evaluate().doubleValue()));
    }
}
