package com.example.julio.albumstore;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Julio on 3/31/15.
 */
public class Album {

    private String name;
    private Artist[] artists;
    private Image[] images;
    private String release_date;
    private String id;
    private String[] genres;
    private String href;
    private Paging tracks;
    private Copyright[] copyrights;
    private String uri;

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artists=" + Arrays.toString(artists) +
                ", images=" + Arrays.toString(images) +
                ", release_date='" + release_date + '\'' +
                ", id='" + id + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", href='" + href + '\'' +
                ", tracks=" + tracks +
                ", copyrights=" + Arrays.toString(copyrights) +
                ", uri='" + uri + '\'' +
                '}';
    }

    public Album(String name, Paging tracks, Image[] images, String release_date, String id, String[] genres, String href, Artist[] artists, Copyright[] copyrights, String uri) {
        this.name = name;
        this.artists = artists;
        this.images = images;
        this.release_date = release_date;
        this.id = id;
        this.genres = genres;
        this.href = href;
        this.tracks = tracks;
        this.copyrights = copyrights;
        this.uri = uri;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void setArtists(Artist[] artists) {
        this.artists = artists;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Paging getTracks() {
        return tracks;
    }

    public void setTracks(Paging tracks) {
        this.tracks = tracks;
    }

    public Copyright[] getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(Copyright[] copyrights) {
        this.copyrights = copyrights;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Album() {

    }

    public class Track{
        private Artist[] artists;
        private int duration_ms;
        private Boolean explicit;
        private String href;
        private String id;
        private String name;
        private String preview_url;
        private int track_number;
        private String uri;

        public Track() {
        }

        public Track(Artist[] artists, int duration_ms, Boolean explicit, String href, String id, String name, String preview_url, int track_number, String uri) {

            this.artists = artists;
            this.duration_ms = duration_ms;
            this.explicit = explicit;
            this.href = href;
            this.id = id;
            this.name = name;
            this.preview_url = preview_url;
            this.track_number = track_number;
            this.uri = uri;
        }

        public Artist[] getArtists() {

            return artists;
        }

        public void setArtists(Artist[] artists) {
            this.artists = artists;
        }

        public int getDuration_ms() {
            return duration_ms;
        }

        public void setDuration_ms(int duration_ms) {
            this.duration_ms = duration_ms;
        }

        public Boolean getExplicit() {
            return explicit;
        }

        public void setExplicit(Boolean explicit) {
            this.explicit = explicit;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPreview_url() {
            return preview_url;
        }

        public void setPreview_url(String preview_url) {
            this.preview_url = preview_url;
        }

        public int getTrack_number() {
            return track_number;
        }

        public void setTrack_number(int track_number) {
            this.track_number = track_number;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return "Track{" +
                    "artists=" + Arrays.toString(artists) +
                    ", duration_ms=" + duration_ms +
                    ", explicit=" + explicit +
                    ", href='" + href + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", preview_url='" + preview_url + '\'' +
                    ", track_number=" + track_number +
                    ", uri='" + uri + '\'' +
                    '}';
        }
    }


    public class Image{


        private int height;
        private int width;
        private String url;

        public Image() {
        }

        public Image(int height, int width, String url) {

            this.height = height;
            this.width = width;
            this.url = url;
        }

        public int getHeight() {

            return height;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "height=" + height +
                    ", width=" + width +
                    ", url='" + url + '\'' +
                    '}';
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
    public class Artist{

        @Override
        public String toString() {
            return "Artist{" +
                    "href='" + href + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", uri='" + uri + '\'' +
                    '}';
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public Artist(String href, String id, String name, String uri) {

            this.href = href;
            this.id = id;
            this.name = name;
            this.uri = uri;
        }

        public Artist() {

        }

        private String href;
        private String id;
        private String name;
        private String uri;
    }
    public class Copyright{
        @Override
        public String toString() {
            return "Copyright{" +
                    "text='" + text + '\'' +
                    '}';
        }

        private String text;

        public Copyright() {
        }

        public Copyright(String text) {

            this.text = text;
        }

        public String getText() {

            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

public class Paging{
    private String href;
    private Object[] items;
    private int limit;
    private String next;
    private String previous;
    private int total;


    @Override
    public String toString() {

        return "Paging{" +
                "href='" + href + '\'' +
                ", items=" + Arrays.toString(items) +
                ", limit=" + limit +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", total=" + total +
                '}';
    }


    public Paging() {
    }

    public String getHref() {

        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Paging(String href, Object[] items, int limit, String next, String previous, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.previous = previous;
        this.total = total;

    }
}
}

