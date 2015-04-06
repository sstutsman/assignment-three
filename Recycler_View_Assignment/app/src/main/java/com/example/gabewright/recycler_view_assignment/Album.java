package com.example.gabewright.recycler_view_assignment;

/**
 * Created by GabeWright on 4/6/15.
 */
public class Album{
    private String name;
    private String artist;
    private String tcount;
    private String year;
    private String publisher;

    public Album(String name, String artist, String tcount, String year, String publisher){
        this.name = name;
        this.artist = artist;
        this.tcount = tcount;
        this.year = year;
        this.publisher = publisher;

    }

    public String getName()  {
        return name;
    }

    public String getArtist()  {
        return artist;
    }

    public String getTcount() { return tcount; }

    public String getYear() { return year; }

    public String getPublisher() { return publisher; }

}
