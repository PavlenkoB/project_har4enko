package ua.edu.nau.godex.projectharchenko.repository_editor.interfaces;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.FileUtils;

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
    public static Logger logger = Logger.getLogger(Configuration.class);
    public final static ConfigurationConfig PROGRAM_CONFIGURATION_CONFIG = new ConfigurationConfig();//завантажити конфігурацію
    public final static ResourceBundle RB = ResourceBundle.getBundle("localization.repository_editor", new Locale(PROGRAM_CONFIGURATION_CONFIG.language));//завантаження локалызації

    class ConfigurationConfig {

        public String language;
        public Integer drawThreads;

        public ConfigurationConfig() {
            logger.setLevel(Level.INFO);
            BasicConfigurator.configure();
            logger.info("Init Configuration");
            try {
                File config = new File("ConfigurationConfig.properties");
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
                logger.info("Configuration init error");
            }
            logger.info("Configuration init end");
        }
    }


}
