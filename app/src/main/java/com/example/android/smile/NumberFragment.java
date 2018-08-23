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
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {


    public NumberFragment() {
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
        View rootView = inflater.inflate(R.layout.list,container,false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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


        wordAdapter adapter = new wordAdapter(getActivity(), numbers, R.color.category_numbers);
        GridView list = (GridView) rootView.findViewById(R.id.gridview);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(Audiofocus, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), numbers.get(i).getAudioid());
                    mediaPlayer.setOnCompletionListener(new CompletionListener());
                    mediaPlayer.start();
                }

            }
        });

        return rootView;
    }

}
