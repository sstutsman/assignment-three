package com.example.kdberthiaume.albumrecyclerview;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by smlpookey on 3/30/2015.
 */
public class Album {
    private Drawable coverArt;
    private String albumName;
    private String artist;
    private int trackCount;
    private String publisher;

    public void Album(Drawable art, String albumName, String artist, int trackCount, String pub){
        this.coverArt = art;
        this.albumName = albumName;
        this.artist = artist;
        this.trackCount = trackCount;
        this.publisher = pub;

    }
}
