package com.example.scientificcalculator;

import java.math.BigDecimal;

public class XExp extends Exp {

    private BigDecimal x;

    public XExp(BigDecimal x) {
        this.x = x;
    }


    @Override
    public String show() {
        return x.toPlainString();
    }

    @Override
    public BigDecimal evaluate() throws Exception {
        return x;
    }
}
