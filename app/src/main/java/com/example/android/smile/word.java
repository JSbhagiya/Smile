package com.example.android.smile;

public class word
{
    int imageid=-1;
    String text;

    public word(){}

    public word(String text,int imageid)
    {
        this.text=text;
        this.imageid=imageid;
    }
    public word(String text)
    {
        this.text=text;
    }

    public void setImageid(int id){imageid=id;}

    public void setText(String text){this.text=text;}

    public String getText() {
        return text;
    }

    public int getImageid() {
        return imageid;
    }

    public boolean hasimage()
    {
        if(imageid==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
