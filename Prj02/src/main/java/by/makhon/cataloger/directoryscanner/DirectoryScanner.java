package by.makhon.cataloger.directoryscanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {

    private List<File> filesList = new ArrayList<>();

    public List<File> getFilesList() {
        return filesList;
    }

    public void scanDirectories(String[] paths) {
        List<File> directories = new ArrayList<>();
        for (String path : paths) {
            directories.add(new File(path));
        }

        for (File directory : directories) {
            if (directory.listFiles() != null) {
                for (File dirItem : directory.listFiles()) {
                    if (dirItem.isFile()) {
                        filesList.add(dirItem);
                    }
                    if (dirItem.isDirectory()) {
                        String[] iterableListOfDirs = {dirItem.getAbsolutePath()};
                        scanDirectories(iterableListOfDirs);
                    }
                }
            } else {
                System.out.println("There are no mp3 files in directory: " + directory.getAbsolutePath());
            }
        }
    }

}
