package com.example.android.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Alphabet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList<word> alphabet= new ArrayList<word>();

        alphabet.add(new word("A",R.drawable.a));
        alphabet.add(new word("B",R.drawable.b));
        alphabet.add(new word("C",R.drawable.c));
        alphabet.add(new word("D",R.drawable.d));
        alphabet.add(new word("E",R.drawable.e));
        alphabet.add(new word("F",R.drawable.f));
        alphabet.add(new word("G",R.drawable.g));
        alphabet.add(new word("H",R.drawable.h));
        alphabet.add(new word("I",R.drawable.i));
        alphabet.add(new word("J",R.drawable.j));
        alphabet.add(new word("K",R.drawable.k));
        alphabet.add(new word("L",R.drawable.l));
        alphabet.add(new word("M",R.drawable.m));
        alphabet.add(new word("N",R.drawable.n));
        alphabet.add(new word("O",R.drawable.o));
        alphabet.add(new word("P",R.drawable.p));
        alphabet.add(new word("Q",R.drawable.q));
        alphabet.add(new word("R",R.drawable.r));
        alphabet.add(new word("S",R.drawable.s));
        alphabet.add(new word("T",R.drawable.t));
        alphabet.add(new word("U",R.drawable.u));
        alphabet.add(new word("V",R.drawable.v));
        alphabet.add(new word("W",R.drawable.w));
        alphabet.add(new word("X",R.drawable.x));
        alphabet.add(new word("Y",R.drawable.y));
        alphabet.add(new word("Z",R.drawable.z));


        GridView list= (GridView) findViewById(R.id.gridview);
        wordAdapter adapter = new wordAdapter(this,alphabet);
        list.setAdapter(adapter);
    }

}
