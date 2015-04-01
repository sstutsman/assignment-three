package com.example.alex.disk_jam;

import android.graphics.drawable.Drawable;

/**
 * Created by Alex on 4/1/2015.
 */
public class Album {

    private String title;
    private String artist;
    private int trackCt;
    private int pubYr;
    private String publisher;
    private Drawable albumArt;

    public Album(String title, String artist, int trackCt, int pubYr, String publisher, Drawable albumArt){
        this.title = title;
        this.artist = artist;
        this.trackCt = trackCt;
        this.pubYr = pubYr;
        this.publisher = publisher;
        this.albumArt = albumArt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrackCt() {
        return trackCt;
    }

    public void setTrackCt(int trackCt) {
        this.trackCt = trackCt;
    }

    public int getPubYr() {
        return pubYr;
    }

    public void setPubYr(int pubYr) {
        this.pubYr = pubYr;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Drawable getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(Drawable albumArt) {
        this.albumArt = albumArt;
    }

}

