package editor.controllers;

import editor.classes.DerbyDBManager;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 04.07.2014.
 */
public class patterns_manager_C implements Initializable {
    DerbyDBManager DB_connection;
    void initData(DerbyDBManager derbyDBManager) {
        DB_connection=derbyDBManager;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
