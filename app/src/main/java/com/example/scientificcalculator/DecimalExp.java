package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: DecimalExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of decimal
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class DecimalExp extends Exp {
    private BigDecimal value;

    public DecimalExp(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String show() {
        return value.toPlainString();
    }

    /**
     * This function just returns the bigDecimal format x
     * @return BigDecimal format of x
     */
    @Override
    public BigDecimal evaluate() {
        return (value);
    }

}
