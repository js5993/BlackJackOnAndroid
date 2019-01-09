package com.example.junhosung.blackjackonandroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.junhosung.blackjackonandroid.views.activities.GameActivity;
import com.example.junhosung.blackjackonandroid.views.activities.SeeAboutActivity;
import com.example.junhosung.blackjackonandroid.views.activities.WelcomeScreenActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.espresso.Espresso;


import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class WelcomeScreenFragmentUITest {

    @Rule
    public IntentsTestRule<WelcomeScreenActivity> mWelcomeScreenActivityActivityTestRule =
            new IntentsTestRule<>(WelcomeScreenActivity.class);

    @Before
    public void setup() throws Exception {
        mWelcomeScreenActivityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void clickAbout() throws Exception {
        Espresso.onView(withId(R.id.btn_about)).perform(click());
        intended(hasComponent(SeeAboutActivity.class.getName()));
    }

    @Test
    public void clickPlayGame() throws Exception {
        Espresso.onView(withId(R.id.btn_play_game)).perform(click());
        intended(hasComponent(GameActivity.class.getName()));
    }


}
