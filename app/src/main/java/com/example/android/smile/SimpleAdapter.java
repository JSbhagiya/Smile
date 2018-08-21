package com.example.android.smile;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleAdapter extends ArrayAdapter<word>{
    int colorid;

    public SimpleAdapter(Activity context, ArrayList<word> words,int colorid)
    {

        super(context,0,words);
        this.colorid=colorid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.simple_list_element, parent, false);
        }

        word current= getItem(position);
        TextView text=(TextView)listItemView.findViewById(R.id.text);

        text.setText(current.getText());





        int actualcolor= ContextCompat.getColor(getContext(),colorid);
        listItemView.setBackgroundColor(actualcolor);

        return listItemView;
    }
}
