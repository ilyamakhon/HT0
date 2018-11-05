package by.makhon.cataloger.logger;

import by.makhon.cataloger.bean.Mp3Bean;
import by.makhon.cataloger.bean.Mp3Duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesFinder {

    private List<Mp3Duplicate> removeDuplicates(List<Mp3Duplicate> mp3DuplicateList) {
        Set<Mp3Duplicate> removingDuplicatesSet = new HashSet<>(mp3DuplicateList);
        mp3DuplicateList.clear();
        mp3DuplicateList.addAll(removingDuplicatesSet);
        return mp3DuplicateList;
    }

    public List<Mp3Duplicate> getChecksumDuplicates(List<Mp3Bean> mp3Files) {
        List<Mp3Duplicate> mp3Beans = new ArrayList<>();
        for (Mp3Bean mp3Bean : mp3Files) {
            Mp3Duplicate mp3Duplicate = findChecksumDuplicates(mp3Files, mp3Bean.getChecksum());
            if (mp3Duplicate != null) {
                if (mp3Duplicate.getLocalLinks().size() > 1) {
                    mp3Beans.add(mp3Duplicate);
                }
            }
        }
        if (mp3Beans.isEmpty()){
            return null;
        } else {
            return removeDuplicates(mp3Beans);
        }
    }

    private Mp3Duplicate findChecksumDuplicates(List<Mp3Bean> mp3Files, String checksum) {
        Mp3Duplicate mp3Duplicate = new Mp3Duplicate();
        for (Mp3Bean mp3Bean : mp3Files) {
            if (mp3Bean.getChecksum().equals(checksum)) {
                String artistName = mp3Bean.getArtist();
                String localLink = mp3Bean.getLocalLink();
                mp3Duplicate.setArtistName(artistName);
                mp3Duplicate.addLink(localLink);
            }
        }
        return mp3Duplicate;
    }

    public List<Mp3Duplicate> getDuplicates(List<Mp3Bean> mp3Files) {
        List<Mp3Duplicate> mp3Beans = new ArrayList<>();
        for (Mp3Bean mp3Bean : mp3Files) {
            Mp3Duplicate mp3Duplicate = findDuplicates(mp3Files, mp3Bean.getArtist(), mp3Bean.getAlbum(), mp3Bean.getSong());
            if (mp3Duplicate != null) {
                if (mp3Duplicate.getLocalLinks().size() > 1) {
                    mp3Beans.add(mp3Duplicate);
                }
            }
        }
        if (mp3Beans.isEmpty()){
            return null;
        } else {
            return removeDuplicates(mp3Beans);
        }
    }

    private Mp3Duplicate findDuplicates(List<Mp3Bean> mp3Files, String artistName, String albumName, String songName) {
        Mp3Duplicate mp3Duplicate = new Mp3Duplicate();
        for (Mp3Bean mp3Bean : mp3Files) {
            if ( (mp3Bean.getArtist().equals(artistName)) &&
                    (mp3Bean.getAlbum().equals(albumName)) &&
                    (mp3Bean.getSong().equals(songName)) ) {

                mp3Duplicate.setArtistName(mp3Bean.getArtist());
                mp3Duplicate.setAlbumName(mp3Bean.getAlbum());
                mp3Duplicate.setSongName(mp3Bean.getSong());
                mp3Duplicate.addLink(mp3Bean.getLocalLink());
            }
        }
        return mp3Duplicate;
    }

}
