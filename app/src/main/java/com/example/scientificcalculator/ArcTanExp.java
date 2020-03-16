package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: ArcTanExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of arctan
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class ArcTanExp extends Exp {
    private Exp exp;
    public ArcTanExp (Exp exp){
        this.exp = exp;
    }

    public String show(){
        return "tan\u207B\u00B9" + "(" + exp.show() + ")";
    }

    /**
     * This function will calculate the Arctan function of exp
     * @return BigDecimal degree format of Arcsin
     */
    public BigDecimal evaluate() throws Exception{
        return(BigDecimal.valueOf(Math.atan(exp.evaluate().doubleValue())));
    }
}
