package com.example.scientificcalculator;

/**
 * Tokenizer - this uses the StreamTokenizer class to make a simpler tokenizer
 * which provides a stream of tokens which include: integer, decimal, ADD, SUB,
 * MUL, DIV, LBRA, RBRA, sin, cos, tan, arcsin, arccos, arctan, pi, e, ln, logxY,
 * comma, log, mod, combination, nCr, permutation, sqrt, cbrt, gcd, lcm, abs, sgn,
 * random, ypower, minusonepower, square, cube, xroot, tenbasex, ebasex
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public abstract class Tokenizer {
    public abstract boolean hasNext();
    public abstract Token current();
    public abstract void next() throws Exception;
}
