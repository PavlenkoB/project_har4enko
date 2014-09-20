package editor.interfaces;

import editor.services.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 26.07.2014.
 */
public interface Configuration {
    public final static config programConfig = new config();//завантажити конфігурацію
    public final static ResourceBundle RB = ResourceBundle.getBundle("localization.editor", new Locale(programConfig.language));//завантаження локалызації

    class config {
        public String language;
        public Integer drawThreads;

        public config() {
            try {
                File config = new File("config.properties");
                if (!config.exists()) {
                    FileUtils.copyFileUsingStream(new File(getClass().getClassLoader().getResource("default_config.properties").toURI()), config);
                }
                FileInputStream fis;
                Properties property = new Properties();
                fis = new FileInputStream(config);
                property.load(fis);
                language = property.getProperty("language");
                drawThreads = Integer.parseInt(property.getProperty("drawThreads"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
