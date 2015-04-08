package com.example.julio.albumstore;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by jcs on 4/3/15.
 */
public class CurrentSession {



    private Album[] allAlbums;
    private String access_token;
    private String refresh_token;
    private Integer  expires_in;
    private String token_type;

    @Override
    public String toString() {
        return "CurrentSession{" +
                "allAlbums=" + Arrays.toString(allAlbums) +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                '}';
    }

    public CurrentSession(String access_token, String refresh_token, Integer expires_in, String token_type) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
    }

    public CurrentSession() {

    }

    public Album[] getAllAlbums() {

        return allAlbums;
    }

    public void setAllAlbums(Album[] allAlbums) {
        this.allAlbums = allAlbums;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public CurrentSession(Album[] allAlbums, String access_token, String refresh_token, Integer expires_in, String token_type) {

        this.allAlbums = allAlbums;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
    }
}
