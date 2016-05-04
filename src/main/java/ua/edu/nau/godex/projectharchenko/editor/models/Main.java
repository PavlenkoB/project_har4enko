package ua.edu.nau.godex.projectharchenko.editor.models;

import editor.classes.Modals;
import editor.interfaces.Configuration;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application implements Configuration {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
        logger.info(":Start editor");
        FXMLLoader mainFXML = new FXMLLoader();
        mainFXML.setResources(ResourceBundle.getBundle("localization.editor", new Locale(programConfig.language)));
        //mainFXML.load()
        Parent root = mainFXML.load(getClass().getResource("/editor/views/main_window_V2.fxml"));
        primaryStage.getIcons().add(new Image("res/img/uml_icon.png"));
        primaryStage.setTitle(RB.getString("управління_репозиторієм_патернів_редактор_архітектур"));
        primaryStage.setMinWidth(900);//Минимальная шырина
        primaryStage.setMinHeight(700);//Минимальная высота окна
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"),
                        RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"))) {//да
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
