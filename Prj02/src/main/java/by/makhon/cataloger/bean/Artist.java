package by.makhon.cataloger.bean;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private String album;
    private String song;
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, String album, String song) {
        this.name = name;
        this.album = album;
        this.song = song;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
}
