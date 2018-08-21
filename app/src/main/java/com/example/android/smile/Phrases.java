package com.example.android.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplelist);

        ArrayList<word> phrases= new ArrayList<word>();
        phrases.add(new word("Good Morning"));
        phrases.add(new word("How are you?"));
        phrases.add(new word("I had a great day"));
        phrases.add(new word("Have a nice day"));
        phrases.add(new word("ThankYou"));
        phrases.add(new word("Excuse me."));
        phrases.add(new word("I am Sorry."));
        phrases.add(new word("Where are you from?"));
        phrases.add(new word("I am learning English"));
        phrases.add(new word("Nice to meet you"));

        SimpleAdapter adapter= new SimpleAdapter(this,phrases);
        ListView list= findViewById(R.id.simple_list);
        list.setAdapter(adapter);
    }
}
