package by.makhon.cataloger.view;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Song;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTMLBuilder {

    public void buildHTML(List<Artist> artists) {
        String htmlFilePath = "C:\\Users\\reven\\IdeaProjects\\cataloger\\songs_catalogue.html";
        List<String> htmlList = new ArrayList<>();
        File htmlFile = new File(htmlFilePath);
        try {
            if(htmlFile.createNewFile()){
                System.out.println(htmlFilePath + " File Created");
            }else {
                System.out.println("File " + htmlFilePath + " already exists");
            }
            FileOutputStream fos = new FileOutputStream(htmlFilePath);
            htmlList.add("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    " <head>\n" +
                    "  <meta charset=\"utf-8\" />\n" +
                    "  <title>HTML5</title>\n" +
                    " </head>" +
                    "<body>\n");
            for (Artist artist : artists) {
                htmlList.add("<p>Singer: " + artist.getName() + "</p>");
                for (Album album : artist.getAlbums()) {
                    if (artist.getName().equals(album.getArtistName())){
                        htmlList.add("<p style=\"margin-left: 50px\">Album: " + album.getName() + "</p>");
                        for (Song song : album.getSongs()) {
                            if (song.getAlbum().equals(album.getName()) && song.getArtist().equals(artist.getName())) {
                                htmlList.add("<p style=\"margin-left: 100px\">Song title: " + song.getName() + "</p>" +
                                        "<p style=\"margin-left: 150px; display: inline-block; \" >Song duration: "+ song.getDuration() + "</p>"
                                        + "<a style=\"margin-left: 25px; display: inline-block; \" href=\"" + song.getLocalLink() + "\">" +
                                        song.getLocalLink() + "</a>");
                            }
                        }
                    }
                }
            }
            htmlList.add(
                    " </body>\n" +
                    "</html>");
            for (String data : htmlList) {
                fos.write(data.getBytes());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
