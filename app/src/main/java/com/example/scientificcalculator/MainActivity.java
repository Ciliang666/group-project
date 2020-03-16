package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView shift_textview;
    EditText input_display_edittext;
    TextView output_display_textview;
    Button shift_button, menu_button, more_button, delete_button, ac_button;
    Button drg_button, format_shift_button, left_shift_button, right_shift_button, derivative_button, precision_button;
    Button pi_button, sin_button, cos_button, tan_button, i_button, e_button;
    Button x_min_one_button, x_square_button, root_button, pow_y_button, log_ten_button, ln_button;
    Button seven_button, eight_button, nine_button, left_bracket_button, right_bracket_button;
    Button four_button, five_button, six_button, multi_button, div_button;
    Button one_button, two_button, three_button, add_button, sub_button;
    Button zero_button, decimal_point_button, pos_neg_button, exp_button, equal_button;
    boolean shift = false;
    int precision = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////////////////////////////////////////////
        shift_textview = findViewById(R.id.shift_textview);
        input_display_edittext = findViewById(R.id.input_display_edittext);
        input_display_edittext.setShowSoftInputOnFocus(false);              //hide keyboard

        output_display_textview = findViewById(R.id.output_display_textview);
        shift_button = findViewById(R.id.shift_button);
        menu_button = findViewById(R.id.menu_button);
        more_button = findViewById(R.id.more_button);
        delete_button = findViewById(R.id.delete_button);
        ac_button = findViewById(R.id.ac_button);
        drg_button = findViewById(R.id.drg_button);
        format_shift_button = findViewById(R.id.format_shift_button);
        left_shift_button = findViewById(R.id.left_shift_button);
        right_shift_button = findViewById(R.id.right_shift_button);
        derivative_button = findViewById(R.id.derivative_button);
        precision_button = findViewById(R.id.precision_button);
        pi_button = findViewById(R.id.pi_button);
        sin_button = findViewById(R.id.sin_button);
        cos_button = findViewById(R.id.cos_button);
        tan_button = findViewById(R.id.tan_button);
        i_button = findViewById(R.id.i_button);
        e_button = findViewById(R.id.e_button);
        x_min_one_button  = findViewById(R.id.x_min_one_button);
        x_square_button = findViewById(R.id.x_square_button);
        root_button = findViewById(R.id.root_button);
        pow_y_button = findViewById(R.id.pow_y_button);
        log_ten_button = findViewById(R.id.log_ten_button);
        ln_button = findViewById(R.id.ln_button);
        seven_button = findViewById(R.id.seven_button);
        eight_button = findViewById(R.id.eight_button);
        nine_button = findViewById(R.id.nine_button);
        left_bracket_button = findViewById(R.id.left_bracket_button);
        right_bracket_button = findViewById(R.id.right_bracket_button);
        four_button = findViewById(R.id.four_button);
        five_button = findViewById(R.id.five_button);
        six_button = findViewById(R.id.six_button);
        multi_button = findViewById(R.id.multi_button);
        div_button = findViewById(R.id.div_button);
        one_button = findViewById(R.id.one_button);
        two_button = findViewById(R.id.two_button);
        three_button = findViewById(R.id.three_button);
        add_button = findViewById(R.id.add_button);
        sub_button = findViewById(R.id.sub_button);
        zero_button = findViewById(R.id.zero_button);
        decimal_point_button = findViewById(R.id.decimal_point_button);
        pos_neg_button = findViewById(R.id.pos_neg_button);
        exp_button = findViewById(R.id.exp_button);
        equal_button = findViewById(R.id.equal_button);
        ///////////////////////////////////////////////////////////////////////////
        shift_button.setOnClickListener(this);
        menu_button.setOnClickListener(this);
        more_button.setOnClickListener(this);
        delete_button.setOnClickListener(this);
        ac_button.setOnClickListener(this);
        drg_button.setOnClickListener(this);
        format_shift_button.setOnClickListener(this);
        left_shift_button.setOnClickListener(this);
        right_shift_button.setOnClickListener(this);
        derivative_button.setOnClickListener(this);
        precision_button.setOnClickListener(this);
        pi_button.setOnClickListener(this);
        sin_button.setOnClickListener(this);
        cos_button.setOnClickListener(this);
        tan_button.setOnClickListener(this);
        i_button.setOnClickListener(this);
        e_button.setOnClickListener(this);
        x_min_one_button.setOnClickListener(this);
        x_square_button.setOnClickListener(this);
        root_button.setOnClickListener(this);
        pow_y_button.setOnClickListener(this);
        log_ten_button.setOnClickListener(this);
        ln_button.setOnClickListener(this);
        seven_button.setOnClickListener(this);
        eight_button.setOnClickListener(this);
        nine_button.setOnClickListener(this);
        left_bracket_button.setOnClickListener(this);
        right_bracket_button.setOnClickListener(this);
        four_button.setOnClickListener(this);
        five_button.setOnClickListener(this);
        six_button.setOnClickListener(this);
        multi_button.setOnClickListener(this);
        div_button.setOnClickListener(this);
        one_button.setOnClickListener(this);
        two_button.setOnClickListener(this);
        three_button.setOnClickListener(this);
        add_button.setOnClickListener(this);
        sub_button.setOnClickListener(this);
        zero_button.setOnClickListener(this);
        decimal_point_button.setOnClickListener(this);
        pos_neg_button.setOnClickListener(this);
        exp_button.setOnClickListener(this);
        equal_button.setOnClickListener(this);
        zero_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String output = input_display_edittext.getText().toString();
        fontResize();
        switch(v.getId()){
            //shift_button
            case R.id.shift_button:
                if(shift == false){
                    shift = true;
                    shift_textview.setText(this.getString(R.string.shift));
                }
                else {
                    turnOffShift();
                }
                break;
            //menu_button
            case R.id.menu_button:
                startActivity(new Intent(this,MenuActivity.class));
                break;
            //more_button
            case R.id.more_button:
                LinearLayout fifthLine = findViewById(R.id.forthFunctionLine);
                LinearLayout fifthLineAlt = findViewById(R.id.forthFunctionLineAlt);

                if(fifthLine.getVisibility()== View.GONE){
                    fifthLine.setVisibility(View.VISIBLE);
                    fifthLineAlt.setVisibility(View.GONE);
                }
                else if(fifthLineAlt.getVisibility()== View.GONE){
                    fifthLineAlt.setVisibility(View.VISIBLE);
                    fifthLine.setVisibility(View.GONE);
                }
                break;
            //delete_button
            case R.id.delete_button:
                if(input_display_edittext.getSelectionStart()!=0) {
                    Editable editable = input_display_edittext.getText();
                    int index = input_display_edittext.getSelectionStart();
                    if(input_display_edittext.getText().toString().indexOf(this.getString(R.string.random)) >= 0){
                        int position = input_display_edittext.getText().toString().indexOf(this.getString(R.string.random));
                        if(index > position && index <= position + 4){
                            editable.delete(position, position + 4);
                            break;
                        }
                    }
                    if(input_display_edittext.getText().toString().indexOf("precision of result") >= 0){
                        input_display_edittext.setText("");
                    }
                    editable.delete(index-1, index);
                }
                // parsing analysis
                break;
            //ac_button
            case R.id.ac_button:
                input_display_edittext.setText("");
                output_display_textview.setTextColor(this.getColor(R.color.text));
                output_display_textview.setTextSize(24);
                break;
            //drg_button
            case R.id.drg_button:
                ////////////////???????????????
                break;
            //format_shift_button
            case R.id.format_shift_button:
                ////////////////???????????????
                break;
            //left_shift_button
            case R.id.left_shift_button:
                if(input_display_edittext.getSelectionStart() > 0) {
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                break;
            //right_shift_button
            case R.id.right_shift_button:
                if(input_display_edittext.getSelectionStart() < input_display_edittext.length()) {
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() + 1);
                }
                break;
            //derivative_button
            case R.id.derivative_button:
                ////////////////???????????????
                break;
            //constant_button
            case R.id.precision_button:
                if(!shift) {
                    input_display_edittext.setText("");
                    insertChar("Please specify precision of result and then press '=' (range: 1-100):");
                    output_display_textview.setText("");
                }
                else{
                    turnOffShift();
                }
                break;
            //pi_button
            case R.id.pi_button:
                if(!shift) {
                    insertChar(this.getString(R.string.π));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            //sin_button
            case R.id.sin_button:
                if(!shift) {
                    insertChar(this.getString(R.string.sin));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                else{
                    insertChar(this.getString(R.string.arcsin));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //cos_button
            case R.id.cos_button:
                if(!shift) {
                    insertChar(this.getString(R.string.cos));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                else{
                    insertChar(this.getString(R.string.arccos));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //tan_button
            case R.id.tan_button:
                if(!shift) {
                    insertChar(this.getString(R.string.tan));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                else {
                    insertChar(this.getString(R.string.arctan));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //i_button
            case R.id.i_button:
                ////////////////???????????????
                Bundle bundle = getIntent().getExtras();
                if (bundle==null){
                    input_display_edittext.setText("Error: you haven't define any function!");
                }
                else {
                    String myFunction = bundle.getString("def_func");
                    input_display_edittext.setText(myFunction);
                }

                break;
            //e_button
            case R.id.e_button:
                ////////////////???????????????
                if(!shift) {
                    insertChar(this.getString(R.string.e));
                }
                else{
                    insertChar(this.getString(R.string.logx));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                break;
            //x_min_one_button
            case R.id.x_min_one_button:
                if(!shift) {
                    insertChar("x\u207B\u00B9");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                else{
                    turnOffShift();
                }
                break;
            //i_button
            case R.id.x_square_button:
                if(!shift) {
                    insertChar("x\u00B2");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                else{
                    insertChar("x\u00B3");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //e_button
            case R.id.root_button:
                if(!shift) {
                    insertChar("\u221A");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                else{
                    insertChar("\u221B");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //x_min_one_button
            case R.id.pow_y_button:
                if(!shift) {
                    insertChar("X\u02B8");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                else{
                    insertChar("\u02E3\u221Ay\u0305");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }

                break;
            case R.id.log_ten_button:
                if(!shift) {
                    insertChar(this.getString(R.string.log));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                else{
                    insertChar("10^");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            //x_min_one_button
            case R.id.ln_button:
                ////////////////???????????????
                if(!shift) {
                    insertChar(this.getString(R.string.ln));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                }
                else {
                    insertChar("e^");
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            case R.id.seven_button:
                if(!shift) {
                    insertChar(this.getString(R.string.seven));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.eight_button:
                if(!shift) {
                    insertChar(this.getString(R.string.eight));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.nine_button:
                if(!shift) {
                    insertChar(this.getString(R.string.nine));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.left_bracket_button:
                if(!shift) {
                    insertChar(this.getString(R.string.left_bracket));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.right_bracket_button:
                if(!shift) {
                    insertChar(this.getString(R.string.right_bracket));
                }
                else{

                    turnOffShift();
                }
                break;
            case R.id.four_button:
                if(!shift) {
                    insertChar(this.getString(R.string.four));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.five_button:
                if(!shift) {
                    insertChar(this.getString(R.string.five));
                }
                else{
                    insertChar(this.getString(R.string.combination));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                break;
            case R.id.six_button:
                if(!shift) {
                    insertChar(this.getString(R.string.six));
                }
                else{
                    insertChar(this.getString(R.string.permutation));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                break;
            case R.id.multi_button:
                if(!shift) {
                    insertChar(this.getString(R.string.multiplication));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.div_button:
                if(!shift) {
                    insertChar(this.getString(R.string.division));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.one_button:
                if(!shift) {
                    insertChar(this.getString(R.string.one));
                }
                else{
                    insertChar(this.getString(R.string.greatest_common_divisor));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                break;
            case R.id.two_button:
                if(!shift) {
                    insertChar(this.getString(R.string.two));
                }
                else{
                    insertChar(this.getString(R.string.least_common_multiple));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.comma));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 2);
                    turnOffShift();
                }
                break;
            case R.id.three_button:
                if(!shift) {
                    insertChar(this.getString(R.string.three));
                }
                else{
                    insertChar(this.getString(R.string.absolute));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            case R.id.add_button:
                if(!shift) {
                    insertChar(this.getString(R.string.addition));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.sub_button:
                if(!shift) {
                    insertChar(this.getString(R.string.subtraction));
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.zero_button:
                if(!shift) {
                    insertChar(this.getString(R.string.zero));
                }
                else{
                    insertChar(this.getString(R.string.sign_function));
                    insertChar(this.getString(R.string.left_bracket));
                    insertChar(this.getString(R.string.right_bracket));
                    input_display_edittext.setSelection(input_display_edittext.getSelectionStart() - 1);
                    turnOffShift();
                }
                break;
            case R.id.decimal_point_button:
                if(!shift) {
                    insertChar(this.getString(R.string.decimal_point));
                    ///parse
                }
                else{
                    insertChar(this.getString(R.string.random));
                    turnOffShift();
                }
                break;
            case R.id.pos_neg_button:
                if(!shift) {

                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.exp_button:
                if(!shift) {

                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
            case R.id.equal_button:
                if(!shift) {
                    if(input_display_edittext.getText().toString().contains("precision of result")){
                        String pre = input_display_edittext.getText().toString().split(":")[2];

                        if(pre.matches("^([1-9]|[1-9]\\d|100)$")){
                            precision = Integer.parseInt(pre);
                            input_display_edittext.setText("");

                        }
                        else{
                            output_display_textview.setText("format error");
                        }
                    }
                }
                else{
                    ///????????
                    turnOffShift();
                }
                break;
        }
        evaluate();
        ///////////////////////
    }

    private void insertChar(String ch){
        Editable editable = input_display_edittext.getText();
        editable.insert(input_display_edittext.getSelectionStart(), ch);
    }

    private void turnOffShift(){
        shift_textview.setText("");
        shift = false;
    }

    private void fontResize(){
        if(input_display_edittext.length()>28){
            input_display_edittext.setTextSize(20);
        }
        else{
            input_display_edittext.setTextSize(24);
        }
    }

    private void evaluate(){
        if(input_display_edittext.length()==0){
            output_display_textview.setText("0");
            return;
        }
        if(input_display_edittext.getText().toString().contains("precision of result")){
            return;
        }
        try {
            if(!isLeftEqualRight()){
                throw new Exception("Hint: Invalid bracket");
            }
            RightTokenizer rTokenizer = new RightTokenizer(input_display_edittext.getText().toString());
            Exp exp = new RightParser(rTokenizer).parseExp();

            // exp.show() vs input_display_edittext.getText().toString()
            String newExp =  exp.show().replace("(","");
            newExp = newExp.replace(")", "");
            newExp = newExp.replace("e", String.valueOf(new BigDecimal(Math.E)));

            String newInput = input_display_edittext.getText().toString().replace("(","");
            newInput = newInput.replace(")", "");
            newInput = newInput.replace("π", String.valueOf(new BigDecimal(Math.PI)));
            newInput = newInput.replace("e", String.valueOf(new BigDecimal(Math.E)));

            if(newExp.compareTo(newInput) != 0){
                throw new Exception("Error: Invalid format");
                //throw new Exception("Error: Invalid format "+newExp+" "+ newInput);
            }

            String result = String.valueOf(exp.evaluate());
            PersonalDecimalFormat format = new PersonalDecimalFormat(precision);
            result = format.getResult(result);

            output_display_textview.setTextColor(this.getColor(R.color.text));
            output_display_textview.setTextSize(24);
            output_display_textview.setText(result);

        }catch(Exception e){
            if(e.getMessage().startsWith("Unsupported format, please specify operation sign") ||
                    e.getMessage().startsWith("Error: Invalid decimal") ||
                    e.getMessage().startsWith("Error: Invalid format") ||
                    e.getMessage().startsWith("Error: Division by zero")||
                    e.getMessage().startsWith("Range Error: Unsupported Trigonometric function of Complex")||
                    e.getMessage().startsWith("Range Error: Unsupported Logarithm function of Complex")||
                    e.getMessage().startsWith("Range Error: Unsupported Root function of Complex") ||
                    e.getMessage().startsWith("Range Error: Parameters out of range") ||
                    e.getMessage().startsWith("Range Error: Unsupported decimal factorial") ||
                    e.getMessage().startsWith("Range Error: Non-integer parameters") ){
                output_display_textview.setText(e.getMessage());
                output_display_textview.setTextColor(this.getColor(R.color.alert));
                output_display_textview.setTextSize(16);
                return;
            }
            if(e.getMessage().startsWith("(Please perfect format)") ||
                    e.getMessage().startsWith("Hint: Invalid bracket") ||
                    e.getMessage().startsWith("Hint: Invalid decimal")){
                output_display_textview.setText(e.getMessage());
                output_display_textview.setTextColor(this.getColor(R.color.hint));
                output_display_textview.setTextSize(16);
                return;
            }
            e.printStackTrace();
        }
    }

    private boolean isLeftEqualRight(){
        String content = input_display_edittext.getText().toString();
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
}
