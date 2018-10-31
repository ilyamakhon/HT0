package by.makhon.cataloger;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.converter.SongConverter;
import by.makhon.cataloger.directoryscanner.DirectoryScanner;
import by.makhon.cataloger.view.HTMLBuilder;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        SongConverter songConverter = new SongConverter();
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        String[] paths = {"C:\\Users\\reven\\Downloads"};

        directoryScanner.scanDirectories(paths);
        List<File> filesToConvert = directoryScanner.getFilesList();
        songConverter.fileToSong(filesToConvert);
        htmlBuilder.buildHTML(songConverter.getArtists());
    }
}
