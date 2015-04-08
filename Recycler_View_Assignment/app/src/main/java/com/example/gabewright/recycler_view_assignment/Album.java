package com.example.gabewright.recycler_view_assignment;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by GabeWright on 4/6/15.
 */
public class Album{
    private String name;
    private String artist;
    private String tcount;
    private String year;
    private String publisher;
    private Drawable art;
    int drawableint;

    public Album(String name, String artist, String tcount, String year, String publisher, Drawable art, int drawableint){
        this.name = name;
        this.artist = artist;
        this.tcount = tcount;
        this.year = year;
        this.publisher = publisher;
        this.art = art;
        this.drawableint = drawableint;


    }



    public String getName()  {
        return name;
    }

    public String getArtist()  {
        return artist;
    }

    public String getTcount() { return tcount; }

    public String getYear() { return year; }

    public String getPublisher() { return publisher; }

    public Drawable getArt() {return art; }

    public int getDrawableint() {return drawableint;}

}
