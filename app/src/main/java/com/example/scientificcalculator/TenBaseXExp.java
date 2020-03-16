package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: TenBaseXExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of 'x power of 10'
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class TenBaseXExp extends Exp {
    private Exp x;

    public TenBaseXExp(Exp x) {
        this.x = x;
    }

    @Override
    public String show() {
        return "10" +"^(" +x.show() + ")";
    }


    /**
     * This function will calculate x power of 10
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
        return(BigDecimal.TEN.pow(x.evaluate().intValue()));
    }
}
