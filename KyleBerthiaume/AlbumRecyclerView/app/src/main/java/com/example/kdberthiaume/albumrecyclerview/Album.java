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
    private String trackCount;
    private String publisher;
    private String tracks;

    public  Album(Drawable art, String albumName, String artist, String trackCount, String pub ,
                  String tracks){
        this.coverArt = art;
        this.albumName = albumName;
        this.artist = "By: " + artist;
        this.trackCount = "Track count: " + trackCount;
        this.publisher = pub;
        this.tracks = tracks;

    }

    public String getAlbumName(){
        return albumName;
    }

    public String getArtist(){
        return artist;
    }

    public String getTrackCount(){
        return trackCount;
    }

    public String getPub(){
        return publisher;
    }

    public Drawable getCoverArt(){
        return coverArt;
    }

    public String getTracks() {
        return tracks;
    }
}
