package com.example.scientificcalculator;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Name: MinusOnePowerExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of (x)^(-1)
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class MinusOnePowerExp extends Exp {
    private Exp x;
    public MinusOnePowerExp(Exp x) {
        this.x = x;
    }

    @Override
    public String show() {
        return "x\u207B\u00B9(" + x.show() +")";
    }

    /**
     * This function will calculate (x)^(-1)
     * x should be an non-zero number; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        DivExp result = new DivExp(new IntExp(new BigInteger("1")),x);
        return (result.evaluate());
    }
}
