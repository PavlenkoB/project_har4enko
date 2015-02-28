package editor.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main_arch_e extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/arch_editor_0.fxml"));
        primaryStage.setTitle("Harchenko");
        primaryStage.getIcons().add(new Image("/res/img/uml_icon.png"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(230);//Минимальная шырина
        primaryStage.setMinHeight(390);//Минимальная высота окна
        primaryStage.show();


    }

    public void stop() {
        //Чистим за собой
        new File("class.txt").delete();
        new File("class.png").delete();
    }
}
