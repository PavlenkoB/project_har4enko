package editor.models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/main_window_V2.fxml"));
        primaryStage.setTitle("Редактор");
        primaryStage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(900);//Минимальная шырина
        primaryStage.setMinHeight(700);//Минимальная высота окна
        primaryStage.show();
    }

    public void stop() {
        //Чистим за собой
    }
}
