package com.example.junhosung.blackjackonandroid;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Junho Sung on 8/15/2018.
 */

public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void play(final Context context) {
        stop();

        mediaPlayer = MediaPlayer.create(context,R.raw.song2);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                play(context);
            }
        });

        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

}
