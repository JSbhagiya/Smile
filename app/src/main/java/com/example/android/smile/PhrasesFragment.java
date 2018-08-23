package com.example.android.smile;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }
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
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.simplelist,container,false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("Good Morning", R.raw.good_morning));
        phrases.add(new word("How are you?", R.raw.how_are_you));
        phrases.add(new word("I had a great day", R.raw.i_had_a_great_day));
        phrases.add(new word("Have a nice day", R.raw.have_a_nice_day));
        phrases.add(new word("ThankYou", R.raw.thank_you));
        phrases.add(new word("Excuse me.", R.raw.excuse_me));
        phrases.add(new word("I am Sorry.", R.raw.i_am_sorry));
        phrases.add(new word("Where are you from?", R.raw.where_are_you_from));
        phrases.add(new word("I am learning English", R.raw.i_am_learning_english));
        phrases.add(new word("Nice to meet you", R.raw.nice_to_meet_you));

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), phrases, R.color.category_phrases);
        ListView list = rootView.findViewById(R.id.simple_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(Audiofocus, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), phrases.get(i).getAudioid());
                    mediaPlayer.setOnCompletionListener(new CompletionListener());
                    mediaPlayer.start();
                }
            }
        });
       return rootView;
    }

}
