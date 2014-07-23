package editor.services;

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
}
