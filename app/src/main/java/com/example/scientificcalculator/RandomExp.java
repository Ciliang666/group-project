package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: RandomExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of random number
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class RandomExp extends Exp {

    public RandomExp(){ }

    public String show(){
        return "ran#";
    }

    /**
     * This function will return a random number between (0,1)
     * @return BigDecimal format of result
     */
    public BigDecimal evaluate() throws Exception{
       return new BigDecimal(Math.random());
    }
}
