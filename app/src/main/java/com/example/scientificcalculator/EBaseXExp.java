package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: EBaseXExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of 'x power of e'
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class EBaseXExp extends Exp {
    private Exp x;

    public EBaseXExp(Exp x) {
        this.x = x;
    }

    @Override
    public String show() {
        return "e" +"^(" +x.show() + ")";
    }

    /**
     * This function will calculate x power of e
     * Range of x is [0,999), and x is an integer; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        if(x.evaluate().compareTo(new BigDecimal("999"))>0) {
            throw new Exception("Range Error: Parameters out of range");
        }
        if(x.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(new BigDecimal(x.evaluate().intValue()).compareTo(x.evaluate())!=0){
            throw new Exception("Range Error: Parameters out of range");
        }
        return new BigDecimal(Math.pow(Math.E, x.evaluate().doubleValue()));
    }
}
