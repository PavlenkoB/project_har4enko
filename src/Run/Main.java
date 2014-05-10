package Run;

import rating_arch.Classes.Architecture;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rating_arch.Controller.rating_arch_C;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

/*    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        rating_arch_C ti = new rating_arch_C();
        Architecture[] ui =  ti.usecase();
        Parent root = FXMLLoader.load(getClass().getResource("/mode_selection/Selection_mode.fxml"));
        primaryStage.setTitle("Selection Mode");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }



    public static void main(String[] args) throws IOException, SQLException {
        launch(args);


    }
}
