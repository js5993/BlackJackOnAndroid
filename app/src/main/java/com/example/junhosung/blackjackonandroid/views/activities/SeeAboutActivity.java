package com.example.junhosung.blackjackonandroid.views.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.junhosung.blackjackonandroid.R;
import com.example.junhosung.blackjackonandroid.views.fragment_template.SingleFragmentActivity;
import com.example.junhosung.blackjackonandroid.views.fragments.SeeAboutFragment;

public class SeeAboutActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SeeAboutFragment();
    }
}
