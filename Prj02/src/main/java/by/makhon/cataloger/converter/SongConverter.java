package by.makhon.cataloger.converter;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Song;
import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongConverter {
    private List<Artist> artists = new ArrayList<>();

    public List<Artist> getArtists() {
        return artists;
    }

    public void fileToSong(List<File> files) {
        try {
            for (File file : files) {
                String fileExtension = getFileExtension(file);
                if (fileExtension.equals("mp3")) {
                    Mp3File mp3File = new Mp3File(file.getAbsolutePath());
                    if (mp3File.hasId3v2Tag()) {
                        ID3v2 tag = mp3File.getId3v2Tag();
                        Artist artist = new Artist(tag.getArtist());
                        Album album = new Album(tag.getArtist(), tag.getAlbum());
                        Song song = new Song(tag.getArtist(), tag.getAlbum(), tag.getTitle(),
                                        convertSongDurationFromSeconds(mp3File.getLengthInSeconds()),
                                        file.getAbsolutePath());
                        album.addSong(song);
                        artist.addAlbum(album);
                        artists.add(artist);
                    }
                }
            }
        } catch (UnsupportedTagException | IOException | InvalidDataException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private String convertSongDurationFromSeconds(long duration) {
        long minutes = ((duration % 3600) / 60);
        long seconds = (duration % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
