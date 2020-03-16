package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: SquareRootExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of square root
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class SquareRootExp extends Exp {
    private Exp exp;

    public SquareRootExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "\u221A" +"(" +exp.show() + ")";
    }

    /**
     * This function will calculate the square root of exp
     * exp must be equal or greater than 0; otherwise, an exception should be thrown
     * @return BigDecimal format of square of exp
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        if(exp.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Unsupported Root function of Complex");
        }
        return new BigDecimal(Math.sqrt(exp.evaluate().doubleValue()));
    }
}
