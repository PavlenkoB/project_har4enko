package editor.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main_layer_e extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/layer_editor.fxml"));
        primaryStage.setTitle("Harchenko");
        primaryStage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(230);//Минимальная шырина
        primaryStage.setMinHeight(390);//Минимальная высота окна
        primaryStage.show();
    }

    public void stop() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
