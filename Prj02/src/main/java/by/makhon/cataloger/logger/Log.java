package by.makhon.cataloger.logger;

import by.makhon.cataloger.bean.Mp3Bean;
import by.makhon.cataloger.bean.Mp3Duplicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Log {
    private static final Logger rootLogger = LogManager.getRootLogger();

    public void log(List<Mp3Bean> mp3Files) {
        DuplicatesFinder duplicatesFinder = new DuplicatesFinder();

        List<Mp3Duplicate> mp3ChecksumDuplicateList = duplicatesFinder.getChecksumDuplicates(mp3Files);
        if (mp3ChecksumDuplicateList != null) {
            int i = 0;
            for (Mp3Duplicate mp3Duplicate : mp3ChecksumDuplicateList) {
                i++;
                mp3Duplicate.setArtistName("Duplicate " + i);
                System.out.println(mp3Duplicate.getArtistName() + " ");
                for (String link : mp3Duplicate.getLocalLinks()) {
                    System.out.println(link);
                }
            }
        }

        List<Mp3Duplicate> mp3Duplicates = duplicatesFinder.getDuplicates(mp3Files);
        if (mp3Duplicates != null) {
            Set<Mp3Duplicate> mp3DuplicateSet = new HashSet<>(mp3Duplicates);
            for (Mp3Duplicate mp3Duplicate : mp3DuplicateSet) {
                System.out.println("Artist: " + mp3Duplicate.getArtistName() +
                        " Album: " + mp3Duplicate.getAlbumName() +
                        " Song: " + mp3Duplicate.getSongName());
                for (String link : mp3Duplicate.getLocalLinks()) {
                    System.out.println(link);
                }
            }
        }
    }
}
