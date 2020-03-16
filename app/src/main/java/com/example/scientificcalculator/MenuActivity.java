package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * @author maciliang
 * uid: u6803148
 */
public class MenuActivity extends AppCompatActivity {
    /**
     * a simple menu interface that provides some functions
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void btn_back_to_main(View view) {
        finish();
    }

    public void btn_def_func(View view) {
        startActivity(new Intent(this,DefineFunc.class));
    }

    public void btn_help(View view) {
        startActivity(new Intent(this,HelpActivity.class));
    }
}
