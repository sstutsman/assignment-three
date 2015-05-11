package com.example.br161.newapp;

/**
 * Created by oa5579pw on 3/30/2015.
 * updated
 */
public class Album {
    private String albumCoverArt;
    private String name;
    private String artist;
    private String trackCount;
    private String year;
    private String publisher;

    public Album(String name, String albumCoverArt, String artist, String trackCount, String year, String publisher) {
        this.albumCoverArt = albumCoverArt;
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;

    }

    public String getAlbumCoverArt() {
        return albumCoverArt;
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


}
