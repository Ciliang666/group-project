package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Name: PermutationExp.java
 *
 * Works:
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of Permutation
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class PermutationExp extends Exp {
    private Exp leftExp;
    private Exp rightExp;

    public PermutationExp(Exp leftExpexp, Exp rightExpexp) {
        this.leftExp = leftExpexp;
        this.rightExp = rightExpexp;
    }

    @Override
    public String show() { return "nPr" +"(" + leftExp.show() + "," + rightExp.show() + ")"; }

    /**
     * This function will calculate the right-permutation of left
     * left and right have to be positive integers: 0<=right<=left; and exceptions will be thrown if it is out of range
     * @return BigDecimal format of number of possible right-permutation of left
     */
    @Override
    public BigDecimal evaluate() throws Exception {

        if(leftExp.evaluate().compareTo(BigDecimal.ZERO)<0 || rightExp.evaluate().compareTo(BigDecimal.ZERO)<0 ){
            throw new Exception("Range Error: Parameters out of range");
        }
        if(leftExp.evaluate().compareTo(rightExp.evaluate())<0 ){
            throw new Exception("Range Error: Parameters out of range");
        }
        Exp ab = new SubExp(leftExp,rightExp);
        return (new FactorialExp(leftExp)).evaluate().divide((new FactorialExp(ab)).evaluate());
    }
}
