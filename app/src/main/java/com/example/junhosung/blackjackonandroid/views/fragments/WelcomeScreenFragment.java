package com.example.junhosung.blackjackonandroid.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.junhosung.blackjackonandroid.R;
import com.example.junhosung.blackjackonandroid.views.activities.GameActivity;
import com.example.junhosung.blackjackonandroid.views.activities.SeeAboutActivity;

/**
 * Created by Junho Sung on 1/6/2019.
 */

public class WelcomeScreenFragment extends Fragment {

    TextView mGameTitle;
    Button mBtnStartGame;
    Button mBtnSeeInfo;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_screen,container,false);

        mGameTitle = (TextView) view.findViewById(R.id.txt_game_title);
        mGameTitle.setText(R.string.blackjack);

        mBtnStartGame = (Button) view.findViewById(R.id.btn_play_game);
        mBtnStartGame.setText(R.string.play_game);
        mBtnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                startActivity(intent);
            }
        });

        mBtnSeeInfo = (Button) view.findViewById(R.id.btn_about);
        mBtnSeeInfo.setText(R.string.about);
        mBtnSeeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SeeAboutActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
