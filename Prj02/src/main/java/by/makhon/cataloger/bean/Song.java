package by.makhon.cataloger.bean;

import java.util.Objects;

public class Song {

    private String artist;
    private String album;
    private String name;
    private String duration;
    private String localLink;

    public Song() {
    }

    public Song(String artist, String album, String name, String duration, String localLink) {
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.duration = duration;
        this.localLink = localLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocalLink() {
        return localLink;
    }

    public void setLocalLink(String localLink) {
        this.localLink = localLink;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
