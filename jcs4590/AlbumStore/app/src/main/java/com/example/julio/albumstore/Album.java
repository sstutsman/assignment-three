package com.example.julio.albumstore;

import java.util.Date;

/**
 * Created by Julio on 3/31/15.
 */
public class Album {

    protected String name;
    protected String artistName;
    protected String publisher;
    protected String coverArtURLString;
    protected Date releaseDate;
    protected int trackCount;

    public Album(String name, String artistName, String coverArtURLString){
        this.artistName = artistName;
        this.name = name;
        this.coverArtURLString = coverArtURLString;

    }

}
