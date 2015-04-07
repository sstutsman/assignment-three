/**
 * Created by Joseph on 4/4/2015.
 */
public class Song {

    private String album;
    private String name;
    private double length;
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song(String a, String n)
    {
        this.album = a;
        this.name = n;
    }

}
