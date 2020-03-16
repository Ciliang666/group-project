package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;
/**
 * @author maciliang
 * uid: u6803148
 */

public class HelpActivity extends AppCompatActivity {
    /**
     * show the supported advanced functions and basic instructions
     */
    private static final String MASSAGE = "This is the version 1.0 of our Scientific Calculator.\n" +
            "You can define your own mathematical functions via \"DEFINE FUNCTION\" button.\n" +
            "Please click \"CHECK FORM\" button after defining a function\n" +
            "You can save the defined function via \"SAVE\" button.\n" +
            "You can draw the defined function image via\"DRAW\" button.\n" +
            "You can call your saved self-defined function in the main calculator interface. Please" +
            "click \"def_func\" button and you can use it.\n" +
            "The current version only supports self-defined function with one variable(y=f(x)).\n" +
            "We will provide more functions in the later update.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        TextView help_msg = findViewById(R.id.help_msg);
        help_msg.setText(MASSAGE);
    }
}
