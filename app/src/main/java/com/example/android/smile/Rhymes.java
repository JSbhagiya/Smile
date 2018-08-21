package com.example.android.smile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Rhymes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplelist);

       final ArrayList<word> rhymeslist = new ArrayList<word>();
        rhymeslist.add(new word("London Bridge is falling down","0-Y7Qi3fMs0"));
        rhymeslist.add(new word("Twinkle Twinkle Little Star","6VjmKnFlJm0"));
        rhymeslist.add(new word("Head,Shoulders,Knees and Toes","h4eueDYPTIg"));
        rhymeslist.add(new word("Baba Black Sheep","1dttq5p0xUM"));
        rhymeslist.add(new word("Humpty Dumpty","AIIj0mBX1jU"));
        rhymeslist.add(new word("Johny Johny","wCsEG1Jjr0o"));
        rhymeslist.add(new word("Ring around the roses","Zq2WWU5dzm0"));
        rhymeslist.add(new word("Marry had a little lamb","CkRdvGmcCBE"));
        rhymeslist.add(new word("Here we go around","NZ1a94-tNyw"));
        rhymeslist.add(new word("Jack and Jill","ecQYsQkfNPc"));

        SimpleAdapter adapter = new SimpleAdapter(this,rhymeslist,R.color.category_rhymes);
        ListView list= (ListView)findViewById(R.id.simple_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word current= rhymeslist.get(i);
                String id=current.getvideoid();
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
                appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + id));
                webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    getApplicationContext().startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    getApplicationContext().startActivity(webIntent);
                }
            }

        });
    }
}
