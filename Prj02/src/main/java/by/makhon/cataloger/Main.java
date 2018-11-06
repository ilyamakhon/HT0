package by.makhon.cataloger;

import by.makhon.cataloger.bean.*;
import by.makhon.cataloger.converter.FileConverter;
import by.makhon.cataloger.logger.LogFileAppender;
import by.makhon.cataloger.modelbuilder.ModelBuilder;
import by.makhon.cataloger.scanner.DirectoryScanner;
import by.makhon.cataloger.view.HTMLBuilder;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        FileConverter fileConverter = new FileConverter();
        ModelBuilder modelBuilder = new ModelBuilder();
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        LogFileAppender logFileAppender = new LogFileAppender();

        directoryScanner.scanDirectories(args);
        List<File> filesToConvert = directoryScanner.getFilesList();
        List<Mp3Bean> mp3Files = fileConverter.fileToMP3(filesToConvert);
        modelBuilder.buildModel(mp3Files);
        Model model = modelBuilder.getModel();
        htmlBuilder.buildHTML(model);
        logFileAppender.log(mp3Files);
    }
}
