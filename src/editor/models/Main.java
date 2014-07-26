package editor.models;

import editor.classes.configuration;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.util.Locale;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final configuration program_config=new configuration();//завантажити конфігурацію
        final ResourceBundle resourceBundle= ResourceBundle.getBundle("localization.editor");
        FXMLLoader mainFXML=new FXMLLoader();
        mainFXML.setResources(ResourceBundle.getBundle("localization.editor",new Locale(program_config.language)));
        //mainFXML.load()
        Parent root = mainFXML.load(getClass().getResource("/editor/views/main_window_V2.fxml"));


        primaryStage.setTitle(resourceBundle.getString("управління_репозиторієм_патернів_редактор_архітектур"));
        primaryStage.setMinWidth(900);//Минимальная шырина
        primaryStage.setMinHeight(700);//Минимальная высота окна
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Object[] options = {resourceBundle.getString("загальні.так"),
                        resourceBundle.getString("загальні.ні")};
                int n = JOptionPane.showOptionDialog(null,
                        resourceBundle.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"),
                        resourceBundle.getString("загальні.увага"),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
                if (n == 0) {//да
                } else {//нет
                    we.consume();
                }
            }
        });
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void stop() {
        //Чистим за собой
    }
}
