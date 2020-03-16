package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: CubeExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of cube
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class CubeExp extends Exp {
    private Exp x;
    public CubeExp(Exp x) {
        this.x = x;
    }

    @Override
    public String show() {
        return "x\u00B3(" + x.show() +")";
    }

    /**
     * This function will calculate the cube function of x
     * @return BigDecimal format of cube of x
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        return (x.evaluate().pow(3));
    }
}
