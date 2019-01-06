package com.example.junhosung.blackjackonandroid.views.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.junhosung.blackjackonandroid.R;
import com.example.junhosung.blackjackonandroid.views.fragment_template.SingleFragmentActivity;
import com.example.junhosung.blackjackonandroid.views.fragments.WelcomeScreenFragment;

public class WelcomeScreenActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new WelcomeScreenFragment();
    }
}
