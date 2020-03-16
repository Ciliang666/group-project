package com.example.scientificcalculator;

import java.math.BigDecimal;

/**
 * Abstract class Exp to represent expressions
 *
 *@author: Yihua Zhang
 *@Uid: u6575450
 *@Date: 16/10/2019
 */

public abstract class Exp {
    public abstract String show();
    public abstract BigDecimal evaluate() throws Exception;
}
