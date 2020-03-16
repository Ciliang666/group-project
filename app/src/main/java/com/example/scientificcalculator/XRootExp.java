package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: XRootExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of x root of y
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class XRootExp extends Exp {
    private Exp x;
    private Exp y;

    public XRootExp(Exp x, Exp y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String show() {
        return "\u02E3\u221Ay\u0305" +"(" +x.show() + ","+y.show()+")";
    }

    /**
     * This function will calculate the x root of y
     * x must be an integer that is greater than 0; otherwise, an exception should be thrown
     * y must be equal or greater than 0; otherwise, an exception should be thrown
     * @return BigDecimal format of square of exp
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        if(x.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(x.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(new BigDecimal(x.evaluate().intValue()).compareTo(x.evaluate())!=0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(y.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Unsupported Root function of Complex");
        }
        return new BigDecimal(Math.pow(y.evaluate().doubleValue(),BigDecimal.ONE.divide(x.evaluate(), 110,  BigDecimal.ROUND_HALF_UP).doubleValue()));
    }
}
