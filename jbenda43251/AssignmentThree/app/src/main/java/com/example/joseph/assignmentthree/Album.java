package com.example.joseph.assignmentthree;

/**
 * Created by Joseph on 3/30/2015.
 */
public class Album {
    private String name;
    private String artist;
    private String publisher;
    private int track_count;
    private int year;
    private int cover_art;

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTrack_count(int track_count) {
        this.track_count = track_count;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCover_art(int cover_art) {
        this.cover_art = cover_art;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getTrack_count() {
        return track_count;
    }

    public int getYear() {
        return year;
    }

    public int getCover_art() {
        return cover_art;
    }



    public Album(String n, String a, String p, int t_c, int y, int c_a)
    {
        name = n;
        artist = a;
        publisher = p;
        track_count = t_c;
        year = y;
        cover_art = c_a;
    }
}
