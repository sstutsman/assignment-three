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
    private int albumCover;




    public CDAlbum(String albumname, String artist, String trackCount, String year, String publisher, String genre, int albumart)
    {
        this.albumName = albumname;
        this.albumArtist = artist;
        this.albumTrackCount = trackCount;
        this.albumYear = year;
        this.albumPublisher = publisher;
        this.albumGenre = genre;
        this.albumCover = albumart;

    } // end constructor

    public String getAlbumName()        { return albumName; }
    public String getAlbumArtist()      { return albumArtist; }
    public String getAlbumTrackCount()  { return albumTrackCount; }
    public String getAlbumYear()        { return albumYear; }
    public String getAlbumPublisher()   { return albumPublisher; }
    public String getAlbumGenre()       { return albumGenre; }
    public int getAlbumCover()     { return albumCover; }


}
