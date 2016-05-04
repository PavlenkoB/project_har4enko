package ua.edu.nau.godex.projectharchenko.criterios_viewer.src;

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

/**
 * Created by AlxEx on 14.12.2015.
 */
public class Runner extends Application {
    private static Logger logger = Logger.getLogger(Runner.class.getClass());

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
        logger.info(":Criterion marking program started");

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
