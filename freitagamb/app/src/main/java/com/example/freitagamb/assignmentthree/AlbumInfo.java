package com.example.freitagamb.assignmentthree;

public class AlbumInfo {
    int artID;
    String artist;
    String publisher;
    String album;
    int year;
    int trackCnt;

    AlbumInfo(int artID,String artist, String album, int trackCnt, int year, String publisher){
        this.artID = artID;
        this.artist = artist;
        this.album = album;
        this.trackCnt = trackCnt;
        this.year = year;
        this.publisher = publisher;
    }
}