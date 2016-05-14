package ua.edu.nau.godex.projectharchenko.repository_editor.controllers;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 03.07.2014.
 */
public class ImagePreviewController implements Initializable {
    public ImageView IV_IP;
    public ScrollPane SP_IP;
    public AnchorPane AP_IP;
    public Parent root;

    /**
     * Показує выкно за превюшкою
     *
     * @param show_image зображення що потрібно показати
     * @param title      заголовок вікна
     */
    void initData(Image show_image, String title) {
        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.setTitle(title);
        thisstage.getIcons().add(new Image("/res/img/preview-icon.png"));
        IV_IP.setImage(show_image);
        IV_IP.setFitHeight(show_image.getHeight());
        IV_IP.setFitWidth(show_image.getWidth());

        //AP_IP.setPrefWidth(show_image.getWidth());
        //AP_IP.setPrefHeight(show_image.getHeight());
        //SP_IP.setPrefHeight(show_image.getHeight());
        //SP_IP.setPrefWidth(show_image.getWidth());
        thisstage.setMinHeight(show_image.getHeight()+40);
        thisstage.setMinWidth(show_image.getWidth()+40);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.printf("");

    }
}
