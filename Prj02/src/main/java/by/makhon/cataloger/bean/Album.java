package by.makhon.cataloger.bean;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String artistName;
    private String name;
    private List<Song> songs = new ArrayList<>();

    public Album() {
    }

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public void setName(String albumName) {
        this.name = albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
}
