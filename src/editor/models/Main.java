package models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/main_window.fxml"));
        primaryStage.setTitle("Harchenko");
        primaryStage.getIcons().add(new Image("/res/img/uml_icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public void stop() {
        //Чистим за собой
        new File("class.txt").delete();
        new File("class.png").delete();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
