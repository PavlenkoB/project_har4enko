package editor.tests.multithreadumltoimg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by
 * User: godex_000
 * Date: 13.09.2014.
 * Time: 1:53
 */


public class main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/editor/tests/multithreadumltoimg/vUmlToImg.fxml"));
        primaryStage.setTitle("АРХІТЕКТОР ПРОГРАМНИХ СИСТЕМ");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(640);
        primaryStage.show();
        primaryStage.setResizable(false);/**/
        //System.out.printf(String.valueOf(fibonachi(0,1,7,0)));
    }
}
