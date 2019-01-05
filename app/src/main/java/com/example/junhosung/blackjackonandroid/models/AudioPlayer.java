package com.example.junhosung.blackjackonandroid.models;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.junhosung.blackjackonandroid.R;

/**
 * Created by Junho Sung on 8/15/2018.
 */

public class AudioPlayer {

    private MediaPlayer mMediaPlayer;

    public void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void play(final Context context) {
        stop();

        mMediaPlayer = MediaPlayer.create(context, R.raw.song2);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                play(context);
            }
        });

        mMediaPlayer.start();
        mMediaPlayer.setLooping(true);
    }

}
