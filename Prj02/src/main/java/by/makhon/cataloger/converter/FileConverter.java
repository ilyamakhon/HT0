package by.makhon.cataloger.converter;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Model;
import by.makhon.cataloger.bean.Song;
import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileConverter {

    public List<Mp3File> fileToMP3(List<File> files) {
        List<Mp3File> mp3Files = new ArrayList<>();
        try {
            for (File file : files) {
                String fileExtension = getFileExtension(file);
                if (fileExtension.equals("mp3")) {
                    Mp3File mp3File = new Mp3File(file.getAbsolutePath());
                    if (mp3File.hasId3v2Tag()) {
                        mp3Files.add(mp3File);
                    }

                }
            }
        } catch (UnsupportedTagException | IOException | InvalidDataException | NullPointerException e) {
            e.printStackTrace();
        }
        return mp3Files;
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
