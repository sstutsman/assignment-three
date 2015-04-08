package com.duranovic.albumapp;

// Arnej Duranovic
// 03/30/2015


import android.graphics.drawable.Drawable;

public class Album {
    private int albumArt;
    private String name;
    private String artist;
    private String trackCount;
    private String year;
    private String publisher;
    private String tracks;

    public Album(int albumArt, String name, String artist, String trackCount, String year, String publisher, String tracks) {
        this.albumArt = albumArt;
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;
        this.tracks = tracks;
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

    public String getTracks() {
        return tracks;
    }

    public int getalbumArt() {
        return albumArt;
    }

}