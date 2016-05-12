package ua.edu.nau.godex.projectharchenko.repository_editor.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.DerbyDBManager;
import ua.edu.nau.godex.projectharchenko.repository_editor.controllers.patterns_manager_C;

import java.io.IOException;

public class pattern_manager extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DerbyDBManager derby_DB = new DerbyDBManager("DB/paterns_DB");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/repository_editor/views/pattern_manager.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        patterns_manager_C controller = loader.<patterns_manager_C>getController();
        controller.initData(derby_DB);
        stage.setTitle("Менеджер патернів ");
        stage.show();
    }

    public void stop() {

    }
}
