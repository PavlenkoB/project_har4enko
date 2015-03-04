package tests;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ocin_arch extends Application {

/*    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/rating_arch.fxml"));
        primaryStage.setTitle("Оцінювання архітектур");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setMinHeight(630);
        primaryStage.setMinWidth(400);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, SQLException {
        launch();
    }
}
