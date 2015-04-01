package com.duranovic.albumapp;

// Arnej Duranovic
// 03/30/2015


import android.graphics.drawable.Drawable;

public class Album {
    private Drawable albumArt;
    private String name;
    private String artist;
    private String trackCount;
    private String year;
    private String publisher;

    public Album(Drawable albumArt, String name, String artist, String trackCount, String year, String publisher) {
        this.albumArt = albumArt;
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public String getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public Drawable getalbumArt() {
        return albumArt;
    }

}