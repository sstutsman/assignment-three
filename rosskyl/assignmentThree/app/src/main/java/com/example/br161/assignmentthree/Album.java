package com.example.br161.assignmentthree;

/**
 * Created by al1694bc on 3/30/2015.
 */
public class Album {

    private String name;

    private String artist;

    private String publisher;

    private String genre;

    private String albumCoverName;

    private String[] songs;

    private int numTracks;

    private int year;


    public Album(String name, String artist, String publisher, String genre, String albumCoverName,
                 String[] songs, int numTracks, int year) {

        this.name = name;
        this.artist = artist;
        this.publisher = publisher;
        this.genre = genre;
        this.albumCoverName = albumCoverName;
        this.songs = songs;
        this.numTracks = numTracks;
        this.year = year;
    }//end Album method

    public String getName() {

        return name;
    }//end getName method

    public String getArtist() {

        return artist;
    }//end getArtist method

    public String getPublisher() {

        return publisher;
    }//end getPublisher method

    public String getGenre() {

        return genre;
    }//end getGenre method

    public String getAlbumCoverName() {
        return albumCoverName;
    }//end getAlbumCoverName

    public String[] getSongs() {

        return songs;
    }//end getSongs method

    public int getNumTracks() {

        return numTracks;
    }//end getNumTracks method

    public int getYear() {

        return year;
    }//end getYear method
}//end Album class
