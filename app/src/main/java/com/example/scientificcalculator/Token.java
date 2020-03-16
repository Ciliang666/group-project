package com.example.scientificcalculator;

/**
 * Token class to save extracted token from tokenizer.
 * Each token has its surface form saved in {@code _token}
 * and type saved in {@code _type} which is one of the predefined type in Type enum.
 * INT: integer
 * DECIMAL: decimal
 * ADD: +
 * SUB: -
 * MUL: ×
 * DIV: ÷
 * LBRA: (
 * RBRA: )
 * sin: sin
 * cos: cos
 * tan: tan
 * arcsin: sin\u207B\u00B9
 * arccos: cos\u207B\u00B9
 * arctan: tan\u207B\u00B9
 * pi: π
 * e: e
 * ln: ln
 * logxY: log\u2093y
 * comma: ,
 * log: log
 * mod: mod
 * combination: nCr
 * permutation: nPr
 * sqrt: √
 * cbrt: ∛
 * gcd: gcd
 * lcm: lcm
 * abs: abs
 * sgn: sgn
 * random: random#
 * ypower: Xʸ
 * minusonepower: x\u207B\u00B9
 * square: x\u00B2
 * cube: x\u00B3
 * xroot: \u02E3\u221Ay\u0305
 * tenbasex: 10^
 * ebasex: e^
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */
public class Token {
    public enum Type {UNKNOWN, INT, DECIMAL, ADD, SUB, MUL, DIV, LBRA, RBRA, sin, cos, tan, arcsin,
        arccos, arctan, pi, e, ln, logxy, comma, log, mod, combination, permutation,
        sqrt, cbrt, gcd, lcm, abs, sgn, random, ypower, minusonepower, square, cube,
        xroot, tenbasex, ebasex,varX};
    private String _token = "";
    private Type _type = Type.UNKNOWN;

    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }

    public String token() {
        return _token;
    }

    public Type type() {
        return _type;
    }
}
