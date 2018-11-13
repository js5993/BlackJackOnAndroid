package com.example.junhosung.blackjackonandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class GameActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.gameActivityFragmentContainer);

        if (fragment == null) {
            fragment = new GameActivityFragment();
            fragmentManager.beginTransaction().add(R.id.gameActivityFragmentContainer,fragment).commit();
        }



    }

}
