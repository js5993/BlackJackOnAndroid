package com.example.junhosung.blackjackonandroid.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.junhosung.blackjackonandroid.fragment_template.SingleFragmentActivity;
import com.example.junhosung.blackjackonandroid.fragments.GameActivityFragment;
import com.example.junhosung.blackjackonandroid.R;

public class GameActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GameActivityFragment();
    }

}
