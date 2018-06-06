package ua.edu.nau.icit.interfaces;

import ua.edu.nau.icit.services.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
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
            System.out.println("Init Configuration");
            try {
                File config = new File("config.properties");
                config.createNewFile();

                //TODO problem
                FileWriter configwrite= new FileWriter(config);
                configwrite.write("language = ua_UA\n" +
                        "drawThreads = 2");

                configwrite.close();
                if (!config.exists()) {

                    System.out.println("Configuration file copy");
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

            System.out.println("Configuration init end");
        }
    }


}
