package com.example.rahul.donationtrackerapp.Controllers;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


//Made by Bailey Spencer
@RunWith(AndroidJUnit4.class)
public class LoginTest{

    @Rule
    public ActivityTestRule<Login> mActivityRule =
            new ActivityTestRule<>(Login.class);


    @Test
    public void missingUsername() {
        //missing username
        onView(withId(R.id.editText_username)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editText_password)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.button_login)).perform(click());
        onView(withId(R.id.editText_password)).check(matches(withText("")));
    }

    @Test
    public void invalidUsername() {
        //fields filled out, user doesn't exist
        onView(withId(R.id.editText_username)).perform(typeText("NoUserName"), closeSoftKeyboard());
        onView(withId(R.id.editText_password)).perform(typeText("Password"), closeSoftKeyboard());
        onView(withId(R.id.button_login)).perform(click());
        onView(withId(R.id.editText_username)).check(matches(withText("")));
    }

    @Test
    public void invalidPassword() {
        //valid username, incorrect password
        onView(withId(R.id.editText_username)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.editText_password)).perform(typeText("notPassword"), closeSoftKeyboard());
        onView(withId(R.id.button_login)).perform(click());
        onView(withId(R.id.editText_username)).check(matches(withText("")));
    }

    @Test(expected = android.support.test.espresso.NoMatchingViewException.class)
    public void validLogin(){
        //valid username, valid password
        onView(withId(R.id.editText_username)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.editText_password)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.button_login)).perform(click());
        onView(withId(R.id.editText_password)).check(matches(withText("success")));

    }


}
