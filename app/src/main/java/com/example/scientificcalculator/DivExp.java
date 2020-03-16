package com.example.scientificcalculator;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Name: DivExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of division
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class DivExp extends Exp {
    private Exp factor;
    private Exp term;

    public DivExp(Exp factor, Exp term) {
        this.factor = factor;
        this.term = term;
    }

    @Override
    public String show() {
        return "(" + factor.show() + "÷" + term.show() + ")";
    }

    /**
     * This function will divide factor by term
     * term cannot be 0; otherwise, an exception will be thrown
     * @return BigDecimal format of result (precision: 110)
     */
    @Override
    public BigDecimal evaluate() throws Exception{
        if(term.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Error: Division by zero");
        }
        return (factor.evaluate().divide(term.evaluate(), 110, RoundingMode.CEILING));
    }

}
