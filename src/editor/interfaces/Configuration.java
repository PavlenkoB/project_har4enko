package editor.interfaces;

import editor.services.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by godex_000 on 26.07.2014.
 */
public interface Configuration {
    public final static config program_config = new config();//завантажити конфігурацію
    public final static ResourceBundle resourceBundle = ResourceBundle.getBundle("localization.editor", new Locale(program_config.language));//завантаження локалызації

    class config {
        public String language;
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
