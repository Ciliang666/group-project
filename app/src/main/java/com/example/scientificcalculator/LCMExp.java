package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: LCMExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of least common multiple
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class LCMExp extends Exp {
    private Exp leftExp;
    private Exp rightExp;

    public LCMExp(Exp leftExp, Exp rightExp) {
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    @Override
    public String show() { return "lcm" +"(" + leftExp.show() + "," + rightExp.show() + ")"; }

    /**
     * This function will calculate LCM of x and y
     * x and y should be integers; otherwise, an exception will be thrown
     * @return BigDecimal format of result
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        if((leftExp.evaluate().remainder(BigDecimal.ONE)).compareTo(BigDecimal.ZERO)!=0 ||
                (rightExp.evaluate().remainder(BigDecimal.ONE)).compareTo(BigDecimal.ZERO)!=0){
            throw new Exception("Range Error: Non-integer parameters");
        }

        Exp left = leftExp;
        Exp right = rightExp;

        while(right.evaluate().compareTo(BigDecimal.ZERO)!=0){
            BigDecimal r = left.evaluate().remainder(right.evaluate());
            left = right;
            right = new DecimalExp(r);
        }
        return ((leftExp.evaluate().multiply(rightExp.evaluate())).divide(left.evaluate()));
    }
}
