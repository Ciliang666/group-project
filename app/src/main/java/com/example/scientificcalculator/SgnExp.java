package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: SgnExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of sign function
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class SgnExp extends Exp {
    private Exp exp;

    public SgnExp(Exp exp){
        this.exp = exp;
    }

    public String show(){
        return "sgn" + "(" + exp.show() + ")";
    }

    /* This function will return the sign of exp value
     * @return BigDecimal format of result (+1, -1 or 0)
     */
    public BigDecimal evaluate() throws Exception{
        if(exp.evaluate().compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.ZERO;
        }
        else if(exp.evaluate().compareTo(BigDecimal.ZERO)>0){
            return BigDecimal.ONE;
        }
        else{
            return new BigDecimal(-1);
        }
    }

}
