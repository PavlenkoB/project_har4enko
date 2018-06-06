package ua.edu.nau.icit.run;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    public static Logger logger = Logger.getLogger(Main.class);

/*    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
        logger.info(":Main program started");
        Parent root = FXMLLoader.load(getClass().getResource("/ua/edu/nau/icit/mode_selection/Selection_mode_user_menu.fxml"));
        primaryStage.setTitle("АРХІТЕКТОР ПРОГРАМНИХ СИСТЕМ");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(640);
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) throws IOException, SQLException {
        launch();
    }
}
