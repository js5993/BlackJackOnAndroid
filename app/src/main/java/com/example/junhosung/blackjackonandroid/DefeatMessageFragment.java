package com.example.junhosung.blackjackonandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Junho Sung on 8/22/2018.
 */


public class DefeatMessageFragment extends DialogFragment {


    public static DefeatMessageFragment newInstance(String score) {

        DefeatMessageFragment defeatMessageFragment = new DefeatMessageFragment();

        Bundle args = new Bundle();
        args.putString("score",score);
        defeatMessageFragment.setArguments(args);

        return defeatMessageFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_defeat,null);
        Bundle args = getArguments();
        String finalScore = args.getString("score");

        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        };

        return new AlertDialog.Builder(getActivity()).setTitle("")
                .setMessage(finalScore)
                .setView(view).setPositiveButton("ok",onClickListener)
                .create();

    }
}
