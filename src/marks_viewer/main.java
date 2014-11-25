package marks_viewer;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import rating_arch.Controller.rating_arch_C;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/marks_viewer/view_fxml/marks_viewer.fxml"));
        primaryStage.setTitle("ПЕРЕГЛЯД ОЦІНОК");
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