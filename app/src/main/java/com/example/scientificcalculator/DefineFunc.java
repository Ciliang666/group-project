package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author maciliang
 * uid: u6803148
 */

public class DefineFunc extends AppCompatActivity {
    EditText display_def_func;
    String definedFunction = "";
    String lastInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_func);
        display_def_func = findViewById(R.id.tex_def_func);
        display_def_func.setShowSoftInputOnFocus(false);
    }

    /**
     * insert a number or a function into editText
     * @param s a number or a function expression
     */
    private void insert(String s){
        Editable editable = display_def_func.getText();
        editable.insert(display_def_func.getSelectionStart(), s);
        definedFunction = display_def_func.getText().toString();
    }

    public void btn_num_one(View view) {
        lastInput = "1";
        insert(lastInput);
    }

    public void btn_num_two(View view) {
        lastInput = "2";
        insert(lastInput);
    }

    public void btn_num_three(View view) {
        lastInput = "3";
        insert(lastInput);
    }

    public void btn_num_four(View view) {
        lastInput = "4";
        insert(lastInput);
    }

    public void btn_num_five(View view) {
        lastInput = "5";
        insert(lastInput);
    }

    public void btn_num_six(View view) {
        lastInput = "6";
        insert(lastInput);
    }

    public void btn_num_seven(View view) {
        lastInput = "7";
        insert(lastInput);
    }

    public void btn_num_eight(View view) {
        lastInput = "8";
        insert(lastInput);
    }

    public void btn_num_nine(View view) {
        lastInput = "9";
        insert(lastInput);
    }

    public void btn_num_zero(View view) {
        lastInput = "0";
        insert(lastInput);
    }

    public void btn_num_pi(View view) {
        lastInput = "π";
        insert(lastInput);
    }

    public void btn_decimal_point(View view) {
        lastInput = ".";
        insert(lastInput);
    }

    public void btn_euler_number(View view) {
        lastInput = "e";
        insert(lastInput);
    }

    public void btn_plus(View view) {
        lastInput = "+";
        insert(lastInput);
    }

    public void btn_minus(View view) {
        lastInput = "-";
        insert(lastInput);
    }

    public void btn_times(View view) {
        lastInput = "×";
        insert(lastInput);
    }

    public void btn_divide(View view) {
        lastInput = "÷";
        insert(lastInput);
    }

    public void btn_sq(View view) {
        lastInput = "x\u00B2"+"()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_square_root(View view) {
        lastInput = "\u221A"+"()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_log_x(View view) {
        lastInput = "log()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_ln_x(View view) {
        lastInput = "ln()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_absolute(View view) {
        lastInput = "abs()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_sin(View view) {
        lastInput = "sin()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_cos(View view) {
        lastInput = "cos()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_tan(View view) {
        lastInput = "tan()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_asin(View view) {
        lastInput = "sin\u207B\u00B9"+"()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_acos(View view) {
        lastInput = "cos\u207B\u00B9"+"()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_tri_atan(View view) {
        lastInput = "tan\u207B\u00B9"+"()";
        insert(lastInput);
        display_def_func.setSelection(display_def_func.getSelectionStart() - 1);
    }

    public void btn_left_bra(View view) {
        lastInput = "(";
        insert(lastInput);
    }

    public void btn_right_bra(View view) {
        lastInput = ")";
        insert(lastInput);
    }

    public void btn_x_var(View view) {
        lastInput = "X";
        insert(lastInput);
    }

    public void btn_delete(View view) {
        if(display_def_func.getSelectionStart()!=0) {
            Editable editable = display_def_func.getText();
            editable.delete(display_def_func.getSelectionStart()-1, display_def_func.getSelectionStart());
        }
    }

    public void btn_all_clear(View view) {
        display_def_func.setText("");
    }

    /**
     * evaluate the result of input expression and check the form
     */
    private void evaluate(){
        try {
            if(!isLeftEqualRight()){
                throw new Exception("Hint: Invalid bracket");
            }
            RightTokenizer rTokenizer = new RightTokenizer(display_def_func.getText().toString());
            Exp exp = new RightParser(rTokenizer).parseExp();

            // exp.show() vs input_display_edittext.getText().toString()
            String newExp =  exp.show().replace("(","");
            newExp = newExp.replace(")", "");
            String newInput = display_def_func.getText().toString().replace("(","");
            newInput = newInput.replace(")", "");
            if(newExp.compareTo(newInput) != 0){
                throw new Exception("Error: Invalid format");
            }

        }catch(Exception e){
            if(e.getMessage().startsWith("Unsupported format, please specify operation sign") ||
                    e.getMessage().startsWith("Error: Invalid decimal") ||
                    e.getMessage().startsWith("Error: Invalid format") ||
                    e.getMessage().startsWith("Error: Division by zero")){
                display_def_func.setText(e.getMessage());
                return;
            }
            if(e.getMessage().startsWith("(Please perfect format)") ||
                    e.getMessage().startsWith("Hint: Invalid bracket") ||
                    e.getMessage().startsWith("Hint: Invalid decimal")){
                display_def_func.setText(e.getMessage());
                return;
            }
            e.printStackTrace();
        }
    }

    /**
     * save the defined function that can be called in the main activity
     */
    public void btn_save_func(View view) {
        Bundle save_function = new Bundle();
        Intent toMain = new Intent(this,MainActivity.class);
        save_function.putString("def_func", display_def_func.getText().toString());
        toMain.putExtras(save_function);
        startActivity(toMain);
    }

    /**
     * brackets check helper
     * @return ture if the form is correct
     */
    private boolean isLeftEqualRight(){
        String content = display_def_func.getText().toString();
        int leftBracket = 0;
        int rightBracket = 0;
        for(int i = 0; i<content.length(); i++){
            if(content.charAt(i) == '('){
                leftBracket++;
            }
            else if(content.charAt(i) == ')'){
                rightBracket++;
            }
        }
        if(leftBracket == rightBracket){
            return true;
        }
        return false;
    }

    public void btn_draw_graph(View view) {
        Bundle function = new Bundle();
        Intent toDraw = new Intent(this,DrawActivity.class);
        function.putString("def_func", display_def_func.getText().toString());
        toDraw.putExtras(function);
        startActivity(toDraw);
    }

    public void btn_form_check(View view) {
        evaluate();
    }


}
