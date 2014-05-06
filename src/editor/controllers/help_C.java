package controllers;

import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex on 02.05.2014.
 */
public class help_C implements Initializable {
    public WebView WV_help;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
        WebEngine webEngine = WV_help.getEngine();
        URL urlHello = getClass().getResource("/html/PlantUMLGuide.htm");
        webEngine.load(urlHello.toExternalForm());
        //webEngine.load();
        System.out.print("s");
    }
}
