package ua.edu.nau.godex.projectharchenko.run;


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

/*    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/

    static {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
    }

    public static void main(String[] args) throws IOException, SQLException {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info(":RunRepEditor program started");
        Parent root = FXMLLoader.load(getClass().getResource("/views/mode_selection/Selection_mode_user_menu.fxml"));
        primaryStage.setTitle("АРХІТЕКТОР ПРОГРАМНИХ СИСТЕМ");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(640);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
