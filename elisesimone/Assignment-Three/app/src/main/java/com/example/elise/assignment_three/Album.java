package com.example.elise.assignment_three;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

/**
 * Created by Elise on 3/30/2015.
 */
public class Album {
    private Drawable cover;
    private String name;
    private String artist;
    private Integer trackCount;
    private Integer year;
    private String publisher;

    public Album(Drawable cover, String name, String artist,
                 Integer trackCount, Integer year, String publisher){
        this.cover = cover;
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;
    }

    public Drawable getCover(){
        return cover;
    }

    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public Integer getTrackCount(){
        return trackCount;
    }

    public Integer getYear(){
        return year;
    }

    public String getPublisher(){
        return publisher;
    }
}
