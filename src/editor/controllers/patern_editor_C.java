package editor.controllers;

import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 23.07.2014.
 */
public class patern_editor_C implements Initializable {
    void initData(Pattern pattern, DerbyDBManager derby_con) {
        /*
        derby_DB = derby_con;
        edited_module = module;
        selected_DB.setText(derby_DB.getDbName().toString());
        list_load_DB(null);
        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));


        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Object[] options = {"Так",
                        "Ні"};
                int n = JOptionPane.showOptionDialog(null,
                        "Ви впевнені, що бажаете вийти незбережені зміни буде втрачено?",
                        "Увага",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
                if (n == 0) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/main_window_V2.fxml")
                    );

                    Stage stage = new Stage(StageStyle.DECORATED);
                    try {
                        stage.setScene(new Scene((Pane) loader.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    main_C controller = loader.<main_C>getController();
                    controller.initData(null, derby_DB);

                    stage.show();
                    Stage stage_this = (Stage) MB_main_menu.getScene().getWindow();
                    // do what you have to do
                    stage_this.close();
                } else {
                    we.consume();
                }
            }
        });
        /**/
            }

    public void initialize(URL url, ResourceBundle rb) {
/*
//при двойном клике грузить патерн
        LV_paterns_DB.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1 && derby_DB != null) {
                    load_this_patern_DB(null);
                }
            }
        });
        //list_load_DB();/**/
/**/
    }
}
