package com.example.junhosung.blackjackonandroid.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.junhosung.blackjackonandroid.R;

public class WelcomeMenuActivity extends AppCompatActivity {

    private Button btnOpenGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_menu);

        btnOpenGame = (Button) findViewById(R.id.btn_open_game);
        btnOpenGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeMenuActivity.this,GameActivity.class);
                startActivity(i);
            }
        });


    }
}
