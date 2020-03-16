package com.example.scientificcalculator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Name: IntExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of integer
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class IntExp extends Exp {
    private BigInteger value;

    public IntExp(BigInteger value) {
        this.value = value;
    }

    @Override
    public String show() {
        return value.toString();
    }

    /**
     * This function just returns the bigDecimal format x
     * @return BigDecimal format of x
     */
    @Override
    public BigDecimal evaluate() {
        return (new BigDecimal(value));
    }

}
