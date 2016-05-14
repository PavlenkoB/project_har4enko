package ua.edu.nau.godex.projectharchenko.repository_editor.services;


import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by godex_000 on 22.07.2014.
 */
public class FileSearch {

    public static Logger logger = Logger.getLogger(FileSearch.class.getName());

    private static String fileNameToSearch;
    private static List<String> result = new ArrayList<String>();

    public static String getFileNameToSearch() {
        return fileNameToSearch;
    }

    public void setFileNameToSearch(String fileNameToSearch) {
        this.fileNameToSearch = fileNameToSearch;
    }

    public static void main(String[] args) {

        FileSearch fileSearch = new FileSearch();

        //try different directory and filename :)
        fileSearch.searchDirectory(new File("/Users/mkyong/websites"), "post.php");

        int count = fileSearch.getResult().size();
        if (count == 0) {
            logger.info("\nNo result found!");
        } else {
            logger.info("\nFound " + count + " result!\n");
            for (String matched : fileSearch.getResult()) {
                logger.info("Found : " + matched);
            }
        }
    }

    private static void search(File file) {

        if (file.isDirectory()) {
            logger.info("Searching directory ... " + file.getAbsoluteFile());

            //do you have permission to read this directory?
            if (file.canRead()) {
                for (File temp : file.listFiles()) {
                    if (temp.isDirectory()) {
                        search(temp);
                    } else {
                        if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {
                            result.add(temp.getAbsoluteFile().toString());
                        }

                    }
                }

            } else {
                logger.info(file.getAbsoluteFile() + "Permission Denied");
            }
        }

    }

    public List<String> getResult() {
        return result;
    }

    public void searchDirectory(File directory, String fileNameToSearch) {

        setFileNameToSearch(fileNameToSearch);

        if (directory.isDirectory()) {
            search(directory);
        } else {
            logger.info(directory.getAbsoluteFile() + " is not a directory!");
        }

    }

}
