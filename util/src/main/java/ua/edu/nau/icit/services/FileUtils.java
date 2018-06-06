package ua.edu.nau.icit.services;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

/**
 * Created by godex_000 on 23.07.2014.
 */
public class FileUtils {
    /**
     * Отримати формат файлу (*.оце)
     *
     * @param fileName імя файлу
     * @return формат
     */
    public static String getExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }

    /**
     *
     * @param initDir
     * @param title
     * @param stage
     * @return
     */
    public static List<File> selectFiles(File initDir, String title, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(initDir);
        fileChooser.setTitle(title);
        return fileChooser.showOpenMultipleDialog(stage);
    }

    /**
     * @param initDir
     * @param title
     * @param stage
     * @return
     */
    public static File selectFile(File initDir, String title, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(initDir);
        fileChooser.setTitle(title);
        return fileChooser.showOpenDialog(null);
    }


    /**
     * Копіювання файлу використовуючи потоки
     *
     * @param source      з якого файлу копіювати
     * @param destination куди копіювати
     * @throws IOException
     */
    public static void copyFileUsingStream(File source, File destination) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            System.out.printf("File copy completed " + destination.getAbsolutePath().toString() + "\n");
        } finally {
            is.close();
            os.close();
        }
    }
}
