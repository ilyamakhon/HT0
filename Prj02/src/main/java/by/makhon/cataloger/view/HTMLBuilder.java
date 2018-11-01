package by.makhon.cataloger.view;

import by.makhon.cataloger.bean.Album;
import by.makhon.cataloger.bean.Artist;
import by.makhon.cataloger.bean.Model;
import by.makhon.cataloger.bean.Song;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTMLBuilder {

    public void buildHTML(Model model) {
        String htmlFilePath = "C:\\Users\\reven\\Desktop\\HT0\\Prj02\\music_catalogue.html";
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
            for (Artist artist : model.getArtists()) {
                htmlList.add("<div id=\"" + artist.getName() + "\">");
                htmlList.add("<p style=\"margin: 10px 0 0 0;\">Artist: " + artist.getName() + "</p>");
                htmlList.add("<p style=\"margin: 5px 0 0 50px;\">Album: " + artist.getAlbum() + "</p>");
                for (Album album : artist.getAlbums()) {
                    for (Song song : album.getSongs()) {
                        htmlList.add("<p style=\"margin: 5px 0 0 105px; display: inline-block;\">Song title: " + song.getName() + "</p>" +
                                "<p style=\"margin: 0 20px; display: inline-block; \" >Song duration: "+ song.getDuration() + "</p>"
                                + "<a style=\"display: inline-block; \" href=\"" + song.getLocalLink() + "\">Local link</a>");
                    }
                }
                htmlList.add("</div>");
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
