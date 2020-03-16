package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: MinusOnePowerExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of (x)^(y)
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class YPowerOfXExp extends Exp {
    private Exp x;
    private Exp y;

    public YPowerOfXExp(Exp x, Exp y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String show() {
        return "X\u02B8(" + x.show() + "," + y.show() + ")";
    }

    /**
     * This function will calculate (x)^(y)
     * When x = 0, y should be greater or equal than 0; otherwise, an exception will be thrown
     * x and y should not be 0 at the same time; otherwise, an exception will be thrown
     * y should be greater than 0 and less than 999999999; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        if(y.evaluate().compareTo(BigDecimal.ZERO)<0 && x.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Error: Division by zero");
        }
        if(y.evaluate().compareTo(BigDecimal.ZERO)==0 && x.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(y.evaluate().compareTo(new BigDecimal("999999999"))>0 || y.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(new BigDecimal(y.evaluate().intValue()).compareTo(y.evaluate())!=0){
            throw new Exception("Range Error: Parameters out of range");
        }

        return (x.evaluate().pow(y.evaluate().intValue()));
    }
}
