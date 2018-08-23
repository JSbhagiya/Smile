package com.example.android.smile;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private class CompletionListener implements MediaPlayer.OnCompletionListener {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    }

    private AudioManager audioManager;

    private class Focusmanager implements AudioManager.OnAudioFocusChangeListener {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }

            if (i == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
            if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    }

    private Focusmanager Audiofocus = new Focusmanager();

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(Audiofocus);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> numbers = new ArrayList<word>();
        numbers.add(new word("Zero", R.drawable.zero, R.raw.zero));
        numbers.add(new word("One", R.drawable.one, R.raw.one));
        numbers.add(new word("Two", R.drawable.two, R.raw.two));
        numbers.add(new word("Three", R.drawable.three, R.raw.three));
        numbers.add(new word("Four", R.drawable.four, R.raw.four));
        numbers.add(new word("Five", R.drawable.five, R.raw.five));
        numbers.add(new word("Six", R.drawable.six, R.raw.six));
        numbers.add(new word("Seven", R.drawable.seven, R.raw.seven));
        numbers.add(new word("Eight", R.drawable.eight, R.raw.eight));
        numbers.add(new word("Nine", R.drawable.nine, R.raw.nine));


        wordAdapter adapter = new wordAdapter(this, numbers, R.color.category_numbers);
        GridView list = (GridView) findViewById(R.id.gridview);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(Audiofocus, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), numbers.get(i).getAudioid());
                    mediaPlayer.setOnCompletionListener(new CompletionListener());
                    mediaPlayer.start();
                }

            }
        });

    }
}
