package editor.services;

import java.io.*;

/**
 * Created by godex_000 on 23.07.2014.
 */
public class FileUtils {
    /**
     * Отримати формат файлу (*.оце)
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
     * Копіювання файлу використовуючи потоки
     * @param source з якого файлу копіювати
     * @param destination куди копіювати
     * @throws java.io.IOException
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
        } finally {
            is.close();
            os.close();
        }
    }
}
