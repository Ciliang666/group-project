package com.example.scientificcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Name: LogXYExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of logx(y)
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class LogXYExp extends Exp {
    private Exp expRoot;
    private Exp exp;

    public LogXYExp(Exp expRoot, Exp exp) {
        this.expRoot = expRoot;
        this.exp = exp;
    }

    @Override
    public String show() {
        return "log\u2093y" +"(" + expRoot.show() + "," + exp.show() + ")";
    }

    /**
     * This function will calculate logx(y)
     * x should be an positive integer and y should be an positive number; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        LnExp e = new LnExp(exp);
        LnExp root = new LnExp(expRoot);
        if(root.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new Exception("Range Error: Parameters out of range");
        }
        return e.evaluate().divide(root.evaluate(),110, RoundingMode.CEILING);
    }

}
