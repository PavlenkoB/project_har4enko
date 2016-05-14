package ua.edu.nau.godex.projectharchenko.repository_editor.controllers;

import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex on 02.05.2014.
 */
//TODo delete
public class HelpController implements Initializable {
    public static Logger logger = Logger.getLogger(HelpController.class.getName());
    public WebView WV_help;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        WebEngine webEngine = WV_help.getEngine();
        URL urlHello = getClass().getResource("/repository_editor/res/help/PlantUML.htm");
        webEngine.load(urlHello.toExternalForm());
        logger.info("s");
    }
}
