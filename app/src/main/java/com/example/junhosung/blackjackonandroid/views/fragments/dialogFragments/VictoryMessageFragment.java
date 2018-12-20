package com.example.junhosung.blackjackonandroid.views.fragments.dialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.junhosung.blackjackonandroid.R;

/**
 * Created by Junho Sung on 8/22/2018.
 */

public class VictoryMessageFragment extends DialogFragment {

    public static VictoryMessageFragment newInstance(String score) {

        VictoryMessageFragment victoryMessageFragment = new VictoryMessageFragment();

        Bundle args = new Bundle();
        args.putString("score",score);
        victoryMessageFragment.setArguments(args);

        return victoryMessageFragment;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_victory,null);
        Bundle args = getArguments();
        String finalScore = args.getString("score");

        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        };

        return new AlertDialog.Builder(getActivity()).setTitle(" ")
                .setMessage(finalScore)
                .setView(view).setPositiveButton("ok",onClickListener)
                .create();
    }
}
