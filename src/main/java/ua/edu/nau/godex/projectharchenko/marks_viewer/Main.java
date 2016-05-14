package ua.edu.nau.godex.projectharchenko.marks_viewer;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */

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

    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, SQLException {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
        logger.info(":MarkViewer program started");
        Parent root = FXMLLoader.load(getClass().getResource("/views/marks_viewer/marks_viewer.fxml"));
        primaryStage.setTitle("ПЕРЕГЛЯД ОЦІНОК");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(640);
        primaryStage.show();
        primaryStage.setResizable(true);
    }
}