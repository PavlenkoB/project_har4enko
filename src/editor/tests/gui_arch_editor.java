package editor.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by godex_000 on 21.05.2014.
 */
public class gui_arch_editor extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/arch_editor.fxml"));
        primaryStage.setTitle("Графічний редактор архітектур");
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
