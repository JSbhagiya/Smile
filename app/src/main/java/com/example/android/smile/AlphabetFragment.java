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
public class AlphabetFragment extends Fragment {


    public AlphabetFragment() {
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
        View rootView= inflater.inflate(R.layout.list,container,false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> alphabet = new ArrayList<word>();

        alphabet.add(new word("A", R.drawable.a, R.raw.a));
        alphabet.add(new word("B", R.drawable.b, R.raw.b));
        alphabet.add(new word("C", R.drawable.c, R.raw.c));
        alphabet.add(new word("D", R.drawable.d, R.raw.d));
        alphabet.add(new word("E", R.drawable.e, R.raw.e));
        alphabet.add(new word("F", R.drawable.f, R.raw.f));
        alphabet.add(new word("G", R.drawable.g, R.raw.g));
        alphabet.add(new word("H", R.drawable.h, R.raw.h));
        alphabet.add(new word("I", R.drawable.i, R.raw.i));
        alphabet.add(new word("J", R.drawable.j, R.raw.j));
        alphabet.add(new word("K", R.drawable.k, R.raw.k));
        alphabet.add(new word("L", R.drawable.l, R.raw.l));
        alphabet.add(new word("M", R.drawable.m, R.raw.m));
        alphabet.add(new word("N", R.drawable.n, R.raw.n));
        alphabet.add(new word("O", R.drawable.o, R.raw.o));
        alphabet.add(new word("P", R.drawable.p, R.raw.p));
        alphabet.add(new word("Q", R.drawable.q, R.raw.q));
        alphabet.add(new word("R", R.drawable.r, R.raw.r));
        alphabet.add(new word("S", R.drawable.s, R.raw.s));
        alphabet.add(new word("T", R.drawable.t, R.raw.t));
        alphabet.add(new word("U", R.drawable.u, R.raw.u));
        alphabet.add(new word("V", R.drawable.v, R.raw.v));
        alphabet.add(new word("W", R.drawable.w, R.raw.w));
        alphabet.add(new word("X", R.drawable.x, R.raw.x));
        alphabet.add(new word("Y", R.drawable.y, R.raw.y));
        alphabet.add(new word("Z", R.drawable.z, R.raw.z));


        GridView list = (GridView) rootView.findViewById(R.id.gridview);
        wordAdapter adapter = new wordAdapter(getActivity(), alphabet, R.color.category_alphabets);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(Audiofocus, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), alphabet.get(i).getAudioid());
                    mediaPlayer.setOnCompletionListener(new CompletionListener());
                    mediaPlayer.start();
                }
            }
        });


        return rootView;
    }

}
