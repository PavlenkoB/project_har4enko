package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AlxEx on 14.12.2015.
 */
public class Runner extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view_fxml/criterios_viewer.fxml"));
        primaryStage.setTitle("ПЕРЕГЛЯД КРИТЕРІЇВ");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(640);
        primaryStage.show();
        primaryStage.setResizable(true);
    }


    public static void main(String[] args) throws IOException, SQLException {
        launch();
    }
}
