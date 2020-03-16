package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: FactorialExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of factorial of x
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class FactorialExp extends Exp {
    private Exp exp;

    public FactorialExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(" + exp.show() + ")!";
    }

    /**
     * This function will calculate factorial of x
     * x is larger than 0, and x is an integer; otherwise, an exception will be thrown
     * @return BigDecimal format of result (precision: 110)
     */
    @Override
    public BigDecimal evaluate() throws Exception {
        BigDecimal result = BigDecimal.ONE;

        if(exp.evaluate().compareTo(BigDecimal.ZERO)<0){
            throw new Exception("Range Error: Parameters out of range");
        }
        if((exp.evaluate().remainder(BigDecimal.ONE)).compareTo(BigDecimal.ZERO)!=0){
            throw new Exception("Range Error: Unsupported decimal factorial");
        }

        BigDecimal factor = exp.evaluate();
        if(factor.compareTo(BigDecimal.ZERO)==0){
            return  BigDecimal.ONE;
        }
        for(;;){
            result = result.multiply(factor);
            factor=factor.subtract(BigDecimal.ONE);
            if(factor.compareTo(BigDecimal.ZERO)<=0){
                break;
            }
        }
        return result;
    }

}
