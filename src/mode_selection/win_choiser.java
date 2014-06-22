package mode_selection;

/**
 * Created by Alex on 22.06.2014.
 */

import editor.models.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
                    root = FXMLLoader.load(getClass().getResource("/create_arch/Interface/create_arch.fxml"));
                    create_new_arch_win.setTitle("Створення нової архітектури");
                    create_new_arch_win.setScene(new Scene(root, 1000, 600));
                    create_new_arch_win.setMinWidth(630);
                    create_new_arch_win.setMinHeight(400);
                    create_new_arch_win.setResizable(true);
                    create_new_arch_win.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                win.close();
            }
            case 1: {
                try {
                    root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/rating_arch.fxml"));
                    create_new_arch_win.setTitle("Оцінювання існуючих архітектур");
                    create_new_arch_win.setScene(new Scene(root, 1000, 600));
                    create_new_arch_win.setMinWidth(630);
                    create_new_arch_win.setMinHeight(400);
                    create_new_arch_win.setResizable(true);
                    create_new_arch_win.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                win.close();
            }
            case 2: {
                try {
                    editor.start(win);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
