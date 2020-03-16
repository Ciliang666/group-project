package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: LnExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of ln(x)
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class LnExp extends Exp {
    private Exp exp;

    public LnExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "ln" +"(" + exp.show() + ")";
    }

    /**
     * This function will calculate ln(x)
     * x should be positive integers; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        if(exp.evaluate().compareTo(BigDecimal.ZERO)>0) {
            return new BigDecimal(Math.log(exp.evaluate().doubleValue()));
        }
        else if(exp.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Unsupported Logarithm function of Complex");
        }
        else{
            throw new Exception("Range Error: Parameters out of range");
        }
    }
}
