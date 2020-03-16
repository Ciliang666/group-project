package com.example.scientificcalculator;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void onCreate() {

    }

    @Test
    public void onClick() {

    }

    @Test
    public void testAdditionButton(){
        // check pressing the add button on mainActivity
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.input_display_edittext)).check(matches(withText(R.string.addition)));
    }

    @Test
    public void check_reminderText_MainActivity() {
        // check the text view content
        onView(withId(R.id.gcd_textview)).check(matches(withText("gcd")));
    }


}