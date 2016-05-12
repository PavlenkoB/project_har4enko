package ua.edu.nau.godex.projectharchenko.mode_selection;

/**
 * Created by Alex on 22.06.2014.
 */

//import editor.controllers.main_C;
//import editor.models.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ua.edu.nau.godex.projectharchenko.editor.controllers.main_C;
import ua.edu.nau.godex.projectharchenko.editor.models.Main;

import java.io.IOException;

/**
 * mode    = 0 - створення нових наборів архітектур
 * = 1 - редактор патернів
 * = 2 - оцінка архітектур
 */
public class win_choiser {
    Main editor = new Main();

    public void win_choiser(int mode, Stage win) {
        Stage create_new_arch_win;
        create_new_arch_win = new Stage();
        Parent root;
        switch (mode) {
            case 0: {
                try {
                    root = FXMLLoader.load(getClass().getResource("/views/create_arch/create_arch.fxml"));
                    create_new_arch_win.setTitle("Створення альтернативних архітектур");
                    create_new_arch_win.setScene(new Scene(root, 1000, 600));
                    create_new_arch_win.setMinWidth(630);
                    create_new_arch_win.setMinHeight(400);
                    create_new_arch_win.setResizable(true);
                    create_new_arch_win.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //win.close();
                break;
            }
            case 2: {
                try {
                    root = FXMLLoader.load(getClass().getResource("/views/rating_arch/rating_arch.fxml"));
                    create_new_arch_win.setTitle("Оцінювання архітектур");
                    create_new_arch_win.setScene(new Scene(root, 1000, 600));
                    create_new_arch_win.setMinWidth(630);
                    create_new_arch_win.setMinHeight(400);
                    create_new_arch_win.setResizable(true);
                    create_new_arch_win.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //win.close();
                break;
            }
            case 1: {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/main_window_V2.fxml"));

                    Stage stage = new Stage(StageStyle.DECORATED);
                    try {
                        stage.setScene(new Scene((Pane) loader.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    main_C controller = loader.<main_C>getController();
                    controller.initData();
                    stage.setTitle("Управління репозиторіем патернів");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
