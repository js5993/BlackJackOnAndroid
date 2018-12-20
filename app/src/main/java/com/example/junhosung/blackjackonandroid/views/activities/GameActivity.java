package com.example.junhosung.blackjackonandroid.views.activities;

import android.support.v4.app.Fragment;

import com.example.junhosung.blackjackonandroid.views.fragment_template.SingleFragmentActivity;
import com.example.junhosung.blackjackonandroid.views.fragments.GameActivityFragment;

public class GameActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GameActivityFragment();
    }

}
