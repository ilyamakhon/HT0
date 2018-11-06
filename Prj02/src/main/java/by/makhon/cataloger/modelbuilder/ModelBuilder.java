package by.makhon.cataloger.modelbuilder;

import by.makhon.cataloger.bean.*;

import java.util.List;

/**
 * Class ModelBuilder creates model for correct building HTML view
 */
public class ModelBuilder {
    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void buildModel(List<Mp3Bean> mp3Files) {
        for (Mp3Bean mp3File : mp3Files) {
            String artistName = mp3File.getArtist();
            String albumName = mp3File.getAlbum();
            String songName = mp3File.getSong();
            String duration = mp3File.getDuration();
            String localLink = mp3File.getLocalLink();

            Artist artist = findArtist(model.getArtists(), artistName);
            if (artist == null) {
                Song song = new Song(songName, duration, localLink);
                Album album = new Album(albumName);
                Artist newArtist = new Artist(artistName);
                album.addSong(song);
                newArtist.addAlbum(album);
                model.addArtist(newArtist);
                continue;
            }
            Album album = findAlbum(artist.getAlbums(), albumName);
            if (album == null) {
                Song song = new Song(songName, duration, localLink);
                Album newAlbum = new Album(albumName);
                newAlbum.addSong(song);
                artist.addAlbum(newAlbum);
                continue;
            }
            Song newSong = new Song(songName, duration, localLink);
            album.addSong(newSong);
        }
    }

    private Artist findArtist(List<Artist> artists, String artistName) {
        if (artists == null || artists.isEmpty()) {
            return null;
        }
        for (Artist artist : artists) {
            if (artist.getName().equals(artistName)) {
                return artist;
            }
        }
        return null;
    }

    private Album findAlbum(List<Album> albums, String albumName) {
        if (albums == null || albums.isEmpty()) {
            return null;
        }
        for (Album album : albums) {
            if (album.getName().equals(albumName)) {
                return album;
            }
        }
        return null;
    }

    private Song findSong(List<Song> songs, String songName) {
        if (songs == null || songs.isEmpty()) {
            return null;
        }
        for (Song song : songs) {
            if (song.getName().equals(songName)) {
                return song;
            }
        }
        return null;
    }

}
