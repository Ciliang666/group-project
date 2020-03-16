package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/**
 * @author maciliang
 * uid: u6803148
 */

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        Graph myGraph = new Graph(this,bundle.getString("def_func"));
        setContentView(myGraph);
    }


}
