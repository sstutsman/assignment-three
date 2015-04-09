package com.example.charlesflaten.assign301;

/**
 * Created by Charles Flaten on 3/30/2015.
 */
public class Album {
    private String name,artist,publisher;
            Integer trackCount,year,albumCoverArt;


    public Album(Integer albumCoverArt,String name, String artist,Integer trackCount, Integer year, String publisher) {
        this.albumCoverArt = albumCoverArt;
        this.name = name;
        this.artist = artist;
        this.trackCount = trackCount;
        this.year = year;
        this.publisher = publisher;

    }

    public Integer getAlbumCoverArt() { return albumCoverArt;}
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public Integer getTrackCount() {return trackCount;}
    public Integer getYear() { return year;}
    public String getPublisher() { return publisher;}




}
