package com.maddux.assignmentthree;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by My Laptop on 4/7/2015.
 */
public class Album {
    private String name;
    private String artist;
    private int trackCount;
    private int year;
    private String publisher;
    private int art;

    public Album(int art, String name, String artist, int trackCount, int year, String publisher) {
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;
        this.art = art;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }
}
