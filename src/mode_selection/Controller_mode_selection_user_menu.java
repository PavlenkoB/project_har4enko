package mode_selection;

import editor.models.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rating_arch.Controller.rating_arch_C;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alex on 06.05.2014.
 */


public class Controller_mode_selection_user_menu {
    public AnchorPane sel_next;
    Main editor = new Main();
    rating_arch_C rating = new rating_arch_C();
    public Button cancelButton;


    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/mode_selection/Close.fxml"));
            stage.setTitle("Закриття програми");
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


    public void rating_arch(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next.getScene().getWindow();
        new win_choiser().win_choiser(2,sel_mode);
    }

    public void create_new_arch(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next.getScene().getWindow();
        new win_choiser().win_choiser(0,sel_mode);
    }

    public void edit_arch(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next.getScene().getWindow();
        new win_choiser().win_choiser(1,sel_mode);
    }
}
