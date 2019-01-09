package com.example.junhosung.blackjackonandroid;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.junhosung.blackjackonandroid.views.activities.GameActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Junho Sung on 1/9/2019.
 */

@RunWith(AndroidJUnit4.class)
public class GameFragmentUITest {

    @Rule
    public ActivityTestRule<GameActivity> mGameActivityActivityTestRule =
            new ActivityTestRule<>(GameActivity.class);

    @Before
    public void setup() throws Exception {
        mGameActivityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void clickDealButton() throws Exception {
        Espresso.onView(withId(R.id.btn_deal)).perform(click());
        Espresso.onView(withId(R.id.layout_dealer_hand)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.layout_player_hand)).check(matches(isDisplayed()));
    }

    @Test
    public void clickResetCash() throws Exception {
        Espresso.onView(withId(R.id.btn_reset_cash)).perform(click());
        Espresso.onView(withId(R.id.txtView_display_cash)).check(matches(withText("500")));

    }

    @Test
    public void clickBet1Button() throws Exception {
        Espresso.onView(withId(R.id.btn_bet_1)).perform(click());
        Espresso.onView(withId(R.id.txtView_display_bet)).check(matches(withText("1")));
    }

    @Test
    public void clickBet5Button() throws Exception {
        Espresso.onView(withId(R.id.btn_bet_5)).perform(click());
        Espresso.onView(withId(R.id.txtView_display_bet)).check(matches(withText("5")));

    }

    @Test
    public void clickBet25Button() throws Exception {
        Espresso.onView(withId(R.id.btn_bet_25)).perform(click());
        Espresso.onView(withId(R.id.txtView_display_bet)).check(matches(withText("25")));
    }

    @Test
    public void clickBet100Button() throws Exception {
        Espresso.onView(withId(R.id.btn_bet_100)).perform(click());
        Espresso.onView(withId(R.id.txtView_display_bet)).check(matches(withText("100")));
    }


}
