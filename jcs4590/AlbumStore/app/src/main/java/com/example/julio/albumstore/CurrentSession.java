package com.example.julio.albumstore;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by jcs on 4/3/15.
 */
public class CurrentSession {

    @Override
    public String toString() {
        return "CurrentSession{" +
                "allAlbums=" + Arrays.toString(allAlbums) +
                ", authToken='" + authToken + '\'' +
                '}';
    }

    private Album[] allAlbums;
    private String authToken;


    public CurrentSession(){
        allAlbums = null;
        authToken = null;


    }

    public CurrentSession(Album[] allAlbums, String authToken) {
        this.allAlbums = allAlbums;
        this.authToken = authToken;
    }


    public Album[] getAllAlbums() {
        return allAlbums;
    }

    public void setAllAlbums(Album[] allAlbums) {
        this.allAlbums = allAlbums;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
