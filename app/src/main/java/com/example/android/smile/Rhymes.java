package com.example.android.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Rhymes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplelist);

        ArrayList<word> rhymeslist = new ArrayList<word>();
        rhymeslist.add(new word("London Bridge is falling down"));
        rhymeslist.add(new word("Twinkle Twinkle Little Star"));
        rhymeslist.add(new word("Head,Shoulders,Knees and Toes"));
        rhymeslist.add(new word("Baba Black Sheep"));
        rhymeslist.add(new word("Humpty Dumpty"));
        rhymeslist.add(new word("Johny Johny"));
        rhymeslist.add(new word("Ring around the roses"));
        rhymeslist.add(new word("Marry had a little lamb"));
        rhymeslist.add(new word("Here we go around"));
        rhymeslist.add(new word("Jack and Jill"));

        SimpleAdapter adapter = new SimpleAdapter(this,rhymeslist);
        ListView list= (ListView)findViewById(R.id.simple_list);
        list.setAdapter(adapter);
    }
}
