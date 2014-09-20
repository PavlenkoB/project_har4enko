package editor.controllers;

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
public class image_preview_C implements Initializable {
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
        thisstage.getIcons().add(new Image("/editor/res/img/preview-icon.png"));
        thisstage.setHeight(show_image.getHeight());
        thisstage.setWidth(show_image.getWidth());
        IV_IP.setFitHeight(show_image.getHeight());
        IV_IP.setFitWidth(show_image.getWidth());
        IV_IP.setImage(show_image);
        AP_IP.setPrefWidth(show_image.getWidth());
        AP_IP.setPrefHeight(show_image.getHeight());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.printf("");

    }
}
