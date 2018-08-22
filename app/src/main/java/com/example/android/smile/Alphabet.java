package com.example.android.smile;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Alphabet extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private class CompletionListener implements MediaPlayer.OnCompletionListener
    {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<word> alphabet= new ArrayList<word>();

        alphabet.add(new word("A",R.drawable.a,R.raw.a));
        alphabet.add(new word("B",R.drawable.b,R.raw.b));
        alphabet.add(new word("C",R.drawable.c,R.raw.c));
        alphabet.add(new word("D",R.drawable.d,R.raw.d));
        alphabet.add(new word("E",R.drawable.e,R.raw.e));
        alphabet.add(new word("F",R.drawable.f,R.raw.f));
        alphabet.add(new word("G",R.drawable.g,R.raw.g));
        alphabet.add(new word("H",R.drawable.h,R.raw.h));
        alphabet.add(new word("I",R.drawable.i,R.raw.i));
        alphabet.add(new word("J",R.drawable.j,R.raw.j));
        alphabet.add(new word("K",R.drawable.k,R.raw.k));
        alphabet.add(new word("L",R.drawable.l,R.raw.l));
        alphabet.add(new word("M",R.drawable.m,R.raw.m));
        alphabet.add(new word("N",R.drawable.n,R.raw.n));
        alphabet.add(new word("O",R.drawable.o,R.raw.o));
        alphabet.add(new word("P",R.drawable.p,R.raw.p));
        alphabet.add(new word("Q",R.drawable.q,R.raw.q));
        alphabet.add(new word("R",R.drawable.r,R.raw.r));
        alphabet.add(new word("S",R.drawable.s,R.raw.s));
        alphabet.add(new word("T",R.drawable.t,R.raw.t));
        alphabet.add(new word("U",R.drawable.u,R.raw.u));
        alphabet.add(new word("V",R.drawable.v,R.raw.v));
        alphabet.add(new word("W",R.drawable.w,R.raw.w));
        alphabet.add(new word("X",R.drawable.x,R.raw.x));
        alphabet.add(new word("Y",R.drawable.y,R.raw.y));
        alphabet.add(new word("Z",R.drawable.z,R.raw.z));


        GridView list= (GridView) findViewById(R.id.gridview);
        wordAdapter adapter = new wordAdapter(this,alphabet,R.color.category_alphabets);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),alphabet.get(i).getAudioid());
                mediaPlayer.setOnCompletionListener(new CompletionListener());
                mediaPlayer.start();
            }
        });
    }

}
