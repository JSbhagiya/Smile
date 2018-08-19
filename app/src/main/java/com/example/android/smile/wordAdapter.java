package com.example.android.smile;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word>{

    public wordAdapter(Activity context, ArrayList<word> words)
    {
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_element, parent, false);
        }

        word current= getItem(position);
        TextView text=(TextView)listItemView.findViewById(R.id.text);
        ImageView image=(ImageView)listItemView.findViewById(R.id.image);

        text.setText(current.getText());
        image.setImageResource(current.getImageid());





        return listItemView;
    }
}