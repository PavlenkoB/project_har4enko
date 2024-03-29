package mode_selection;

import editor.models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import rating_arch.Controller.RatingArchController;

import java.io.IOException;

/**
 * Created by Alex on 06.05.2014.
 */


public class Controller_mode_selection {
    Main editor = new Main();
    RatingArchController rating = new RatingArchController();

    public RadioButton choice1_set_new_arch;
    public RadioButton choice1_add_new_patt;
    public RadioButton choice1_rate_task;
    public Button cancelButton;
    public Button sel_next_1;
    public Stage create_new_arch_win;

    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/mode_selection/Close.fxml"));
            stage.setTitle("Завершити програму");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GoBack_main(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void Exit(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void sel_next_open_main(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next_1.getScene().getWindow();
        if (choice1_set_new_arch.isSelected()) {
            try {
                create_new_arch_win = new Stage();
                Parent root;
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
            sel_mode.close();
        }
        if (choice1_rate_task.isSelected()) {
            try {
                create_new_arch_win = new Stage();
                Parent root;
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
            sel_mode.close();
        }
        if (choice1_add_new_patt.isSelected()) {
            try {
                editor.start(sel_mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //sel_mode.close();
    }

}
