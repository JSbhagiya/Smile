package com.example.android.smile;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Phrases extends AppCompatActivity {
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
        setContentView(R.layout.simplelist);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("Good Morning", R.raw.good_morning));
        phrases.add(new word("How are you?", R.raw.how_are_you));
        phrases.add(new word("I had a great day", R.raw.i_had_a_great_day));
        phrases.add(new word("Have a nice day", R.raw.have_a_nice_day));
        phrases.add(new word("ThankYou", R.raw.thank_you));
        phrases.add(new word("Excuse me.", R.raw.thank_you));
        phrases.add(new word("I am Sorry.", R.raw.thank_you));
        phrases.add(new word("Where are you from?", R.raw.thank_you));
        phrases.add(new word("I am learning English", R.raw.thank_you));
        phrases.add(new word("Nice to meet you", R.raw.thank_you));

        SimpleAdapter adapter = new SimpleAdapter(this, phrases, R.color.category_phrases);
        ListView list = findViewById(R.id.simple_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(Audiofocus, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), phrases.get(i).getAudioid());
                    mediaPlayer.setOnCompletionListener(new CompletionListener());
                    mediaPlayer.start();
                }
            }
        });
    }
}
