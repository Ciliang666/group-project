package com.example.scientificcalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: PersonalDecimalFormat.java
 *
 * Works:
 * This class is used to specify the decimal precision of result
 *
 * @author: Yihua Zhang
 * @Uid: u6575450
 * @Date: 16/10/2019
 */

public class PersonalDecimalFormat {

    // default precision is 8
    private int pre = 8;
    private DecimalFormat df = new DecimalFormat("###.00000000");

    public PersonalDecimalFormat(int pre){
        this.pre = pre;
        setDecimal();
    }

    /**
     * This function will set the decimal precision of result according to pre
     */
    private void setDecimal(){
        List<String> list = new ArrayList<String>();
        list.add("###.");
        for(int i=0; i<pre; i++){
            list.add("0");
        }
        df = new DecimalFormat(String.join("",list));
    }

    /**
     * This function will return the result matched with defined decimal format
     * @return the result as a string
     */
    public String getResult(String result) {

        int point = 0;
        if(result.contains(".")){
            point = result.indexOf(".");
            if (result.substring(point,result.length()-1).length() > pre) {
                return (df.format(Float.valueOf(result)));
            } else {
                return (result);
            }
        }
        else{
            return (result);
        }
    }
}
