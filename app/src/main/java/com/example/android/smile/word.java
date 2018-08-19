package com.example.android.smile;

public class word
{
    int imageid;
    String text;

    public word(){}

    public word(String text,int imageid)
    {
        this.text=text;
        this.imageid=imageid;
    }

    public void setImageid(int id){imageid=id;}

    public void setText(String text){this.text=text;}

    public String getText() {
        return text;
    }

    public int getImageid() {
        return imageid;
    }
}
