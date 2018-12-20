package com.example.junhosung.blackjackonandroid.views.fragments.dialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.example.junhosung.blackjackonandroid.R;

/**
 * Created by Junho Sung on 12/16/2018.
 */

public class DrawMessageFragment extends DialogFragment {

    public static DrawMessageFragment newInstance(String score) {

        DrawMessageFragment drawMessageFragment = new DrawMessageFragment();

        Bundle args = new Bundle();
        args.putString("score",score);
        drawMessageFragment.setArguments(args);

        return drawMessageFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_draw,null);
        Bundle args = getArguments();
        String finalScore = args.getString("score");

        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        };

        return new AlertDialog.Builder(getActivity()).setTitle(" ")
                .setMessage(finalScore)
                .setView(view).setPositiveButton("ok",onClickListener)
                .create();



    }
}
