package by.makhon.cataloger.modelbuilder;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Model;
import by.makhon.cataloger.bean.Song;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.util.List;

public class ModelBuilder {
    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void buildModel(List<Mp3File> mp3Files) {
        for (Mp3File mp3File : mp3Files) {
            ID3v2 tag = mp3File.getId3v2Tag();

            Artist artist = findArtist(model.getArtists(), tag.getArtist());
            if (artist == null) {
                Song song = new Song(tag.getTitle(), convertSongDurationFromSeconds(mp3File.getLengthInSeconds()),
                        mp3File.getFilename());
                Album album = new Album(tag.getAlbum());
                Artist newArtist = new Artist(tag.getArtist(), tag.getAlbum());
                album.addSong(song);
                newArtist.addAlbum(album);
                model.addArtist(newArtist);
            } else {
                Album album = findAlbum(artist.getAlbums(), tag.getAlbum());
                if (album == null) {
                    Song song = new Song(tag.getTitle(), convertSongDurationFromSeconds(mp3File.getLengthInSeconds()),
                            mp3File.getFilename());
                    Album newAlbum = new Album(tag.getAlbum());
                    newAlbum.addSong(song);
                    artist.addAlbum(newAlbum);
                } else {
                    Song song = findSong(album.getSongs(), tag.getTitle());
                    if (song == null) {
                        Song newSong = new Song(tag.getTitle(), convertSongDurationFromSeconds(mp3File.getLengthInSeconds()),
                                mp3File.getFilename());
                        album.addSong(newSong);
                    }
                }
            }
        }
    }

    private String convertSongDurationFromSeconds(long duration) {
        long minutes = ((duration % 3600) / 60);
        long seconds = (duration % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }

    private Artist findArtist(List<Artist> artists, String artistName) {
        if (artists == null || artists.isEmpty()) {
            return null;
        }
        for (Artist artist : artists) {
            if (artist.getName() == null) {
                artist.setName("Unknown artist");
                return artist;
            }
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
            if (album.getName() == null) {
                album.setName("Unknown album");
                return album;
            }
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
            if (song.getName() == null) {
                song.setName("Unknown song");
                return song;
            }
            if (song.getName().equals(songName)) {
                return song;
            }
        }
        return null;
    }

}
