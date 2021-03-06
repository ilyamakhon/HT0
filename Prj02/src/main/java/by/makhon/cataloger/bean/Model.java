package by.makhon.cataloger.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Model, bean for creating html view
 * Contains full information about artists, albums, songs
 */
public class Model {

    private List<Artist> artists = new ArrayList<>();

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }
}
