package ua.edu.nau.godex.projectharchenko.repository_editor;

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
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.Modals;
import ua.edu.nau.godex.projectharchenko.repository_editor.interfaces.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

public class RunRepEditor extends Application implements Configuration {
    public static Logger logger = Logger.getLogger(RunRepEditor.class.getName());

    static {
        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        logger.info(":Start repository_editor");
        FXMLLoader mainFXML = new FXMLLoader();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("localization.repository_editor", new Locale(PROGRAM_CONFIGURATION_CONFIG.language));
        mainFXML.setResources(resourceBundle);
        //mainFXML.load()
        Parent root = mainFXML.load(getClass().getResource("/views/repository_editor/main_window_V2.fxml"));
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
        primaryStage.show();/**/
    }

    public void stop() {
        //Чистим за собой
    }
}
