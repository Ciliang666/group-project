package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: ModExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of mod function
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class ModExp extends Exp {
    private Exp factor;
    private Exp term;

    public ModExp(Exp factor, Exp term) {
        this.factor = factor;
        this.term = term;
    }

    @Override
    public String show() {
        return "((" + factor.show() + ")MOD(" + term.show() + "))";
    }

    /**
     * This function will calculate (factor mod term)
     * term cannot be 0; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception{
        if(term.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Error: Division by zero");
        }
        return (factor.evaluate().remainder(term.evaluate()));
    }
}
