package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: LogExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of log(x)
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class LogExp extends Exp {
    private Exp exp;

    public LogExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "log" +"(" +exp.show() + ")";
    }

    /**
     * This function will calculate log(x)
     * x should be positive integers; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        if(exp.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Range Error: Parameters out of range");
        }
        else if(exp.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Unsupported Logarithm function of Complex");
        }

        return new BigDecimal(Math.log10(exp.evaluate().doubleValue()));
    }
}
