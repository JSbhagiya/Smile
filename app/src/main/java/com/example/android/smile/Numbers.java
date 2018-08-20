package com.example.android.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList <word> numbers = new ArrayList<word>();
        numbers.add(new word("Zero",R.drawable.zero));
        numbers.add(new word("One",R.drawable.one));
        numbers.add(new word("Two",R.drawable.two));
        numbers.add(new word("Three",R.drawable.three));
        numbers.add(new word("Four",R.drawable.four));
        numbers.add(new word("Five",R.drawable.five));
        numbers.add(new word("Six",R.drawable.six));
        numbers.add(new word("Seven",R.drawable.seven));
        numbers.add(new word("Eight",R.drawable.eight));
        numbers.add(new word("Nine",R.drawable.nine));


        wordAdapter adapter= new wordAdapter(this,numbers);
        GridView list= (GridView)findViewById(R.id.gridview);
        list.setAdapter(adapter);

    }
}
