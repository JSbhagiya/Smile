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

        GridView list= (GridView) findViewById(R.id.gridview);
        wordAdapter adapter = new wordAdapter(this,alphabet);
        list.setAdapter(adapter);
    }

}
