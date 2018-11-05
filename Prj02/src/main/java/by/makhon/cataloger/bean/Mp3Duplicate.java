package by.makhon.cataloger.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mp3Duplicate {
    private String artistName;
    private String albumName;
    private String songName;
    private List<String> localLinks = new ArrayList<>();

    public Mp3Duplicate() {
    }

    public Mp3Duplicate(String artistName, String albumName, String songName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songName = songName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public List<String> getLocalLinks() {
        return localLinks;
    }

    public void setLocalLinks(List<String> localLinks) {
        this.localLinks = localLinks;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void addLink(String link) {
        localLinks.add(link);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mp3Duplicate that = (Mp3Duplicate) o;
        return Objects.equals(artistName, that.artistName) &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(songName, that.songName) &&
                Objects.equals(localLinks, that.localLinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistName, albumName, songName, localLinks);
    }
}
