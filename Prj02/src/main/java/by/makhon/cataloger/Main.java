package by.makhon.cataloger;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Model;
import by.makhon.cataloger.bean.Song;
import by.makhon.cataloger.converter.FileConverter;
import by.makhon.cataloger.modelbuilder.ModelBuilder;
import by.makhon.cataloger.scanner.DirectoryScanner;
import by.makhon.cataloger.view.HTMLBuilder;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        FileConverter fileConverter = new FileConverter();
        ModelBuilder modelBuilder = new ModelBuilder();
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        String[] paths = {"C:\\Users\\reven\\Downloads"};

        directoryScanner.scanDirectories(paths);
        List<File> filesToConvert = directoryScanner.getFilesList();
        List<Mp3File> mp3Files = fileConverter.fileToMP3(filesToConvert);
        modelBuilder.buildModel(mp3Files);
        Model model = modelBuilder.getModel();
        for (Artist artist : model.getArtists()) {
            System.out.println("Artist: " + artist.getName());
            for (Album album : artist.getAlbums()) {
                System.out.println("Album: " + album.getName());
                for (Song song : album.getSongs()) {
                    System.out.println("Song name: " + song.getName() + " Duration: " + song.getDuration());
                    System.out.println(song.getLocalLink());
                }
            }
            System.out.println("\n");
        }
        htmlBuilder.buildHTML(model);
    }
}
