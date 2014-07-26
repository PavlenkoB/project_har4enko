package editor.classes;

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
public class configuration {
    public String language;
    public configuration() {
        try {
        File config=new File("config.properties");
        if(!config.exists()){

                FileUtils.copyFileUsingStream(new File(getClass().getClassLoader().getResource("default_config.properties").toURI()),config);

        }
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream(config);
        property.load(fis);
        language=property.getProperty("language");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
