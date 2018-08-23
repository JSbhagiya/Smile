package com.example.android.smile;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
public class RhymesFragment extends Fragment {


    public RhymesFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.simplelist,container,false);
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

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),rhymeslist,R.color.category_rhymes);
        ListView list= (ListView)rootView.findViewById(R.id.simple_list);
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
                    getActivity().startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    getActivity().startActivity(webIntent);
                }
            }

        });
        return rootView;
    }

}
