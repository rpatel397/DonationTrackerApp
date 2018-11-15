package com.example.rahul.donationtrackerapp.Controllers;


import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
public class WelcomeScreenTest {


    /**
     * this line is preferred way to hook up to activity
     */
    @Rule
    public ActivityTestRule<Register> mActivityRule =
            new ActivityTestRule<>(Register.class);


    @Test(expected = android.support.test.espresso.NoMatchingViewException.class)
    public void checkAdd() {


        onView(withId(R.id.editText_Name)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editText_ID)).perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.editText_Password)).perform(typeText("Test"), closeSoftKeyboard());


        onView(withId(R.id.button_registrationLogin)).perform(click());

        onView(withId(R.id.editText_Name)).check(matches(withText("")));
        onView(withId(R.id.editText_Name)).check(matches(withText("")));
        onView(withId(R.id.editText_Name)).check(matches(withText("")));

        onView(withId(R.id.editText_Name)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.editText_ID)).perform(typeText("Bailey"), closeSoftKeyboard());
        onView(withId(R.id.editText_Password)).perform(typeText("Bailey"), closeSoftKeyboard());

        onView(withId(R.id.button_registrationLogin)).perform(click());

        onView(withId(R.id.editText_Name)).check(matches(withText("")));
        onView(withId(R.id.editText_Name)).check(matches(withText("")));
        onView(withId(R.id.editText_Name)).check(matches(withText("")));

        onView(withId(R.id.editText_Name)).perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.editText_ID)).perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.editText_Password)).perform(typeText("Test"), closeSoftKeyboard());

        onView(withId(R.id.button_registrationLogin)).perform(click());

        onView(withId(R.id.editText_Name)).check(matches(withText("")));

    }
}
