package com.example.android.smile;

public class word
{
    int imageid=-1;
    String text;
    int audioid=-1;


    public word(){}

    public word(String text,int imageid,int audioid)
    {
        this.text=text;
        this.imageid=imageid;
        this.audioid=audioid;

    }
    public word(String text,int audioid)
    {
        this.text=text;
        this.audioid=audioid;
    }
    public word(String text) {
        this.text = text;
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
        return true;
    }

    public boolean hasaudioid()
    {
        if(audioid==-1)
        {
            return false;
        }
        return true;
    }

    public int getAudioid() { return audioid;}
}
