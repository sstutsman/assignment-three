package com.example.br161.peterassignment_cubed;

import android.graphics.drawable.Drawable;

/**
 * Created by Peter Thompson on 3/30/2015.
 */
public class CDAlbum {
    private String albumName;
    private String albumArtist;
    private String albumTrackCount;
    private String albumYear;
    private String albumPublisher;
    private String albumGenre;
    private Drawable albumCover;
    private String something;
    private String something2;
    private String something3;



    public CDAlbum(String name, String artist, String trackCount, String year, String publisher)
    {
        this.albumName = name;
        this.albumArtist = artist;
        this.albumTrackCount = trackCount;
        this.albumYear = year;
        this.albumPublisher = publisher;
    } // end constructor

    public String getAlbumName()        { return albumName; }
    public String getAlbumArtist()      { return albumArtist; }
    public String getAlbumTrackCount()  { return albumTrackCount; }
    public String getAlbumYear()        { return albumYear; }
    public String getAlbumPublisher()   { return albumPublisher; }
    public String getAlbumGenre()       { return albumGenre; }
    public Drawable getAlbumCover()     { return albumCover; }


}
