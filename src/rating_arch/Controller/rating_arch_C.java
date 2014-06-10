package rating_arch.Controller;

import editor.classes.DerbyDBManager;
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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class rating_arch_C implements Initializable {
    public AnchorPane Rating_arch_1;
    public ChoiceBox task_list;
    public TextArea task_description;
    public Button cancelButton;

    DerbyDBManager derby_DB = new DerbyDBManager("DB/paterns_DB");

    //Windows close dialog
    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/Close.fxml"));
            stage.setTitle("Закриття програми");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Exit(ActionEvent actionEvent) {
        disconnect_DB(null);
        System.exit(1);
    }

    public void GoBack_main(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void disconnect_DB(ActionEvent actionEvent) {
        if (derby_DB != null) {
            derby_DB.disconectDB();
            derby_DB = null;
        }
        ObservableList<String> items = FXCollections.observableArrayList();
    }
    //Windows close dialog

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Rating_arch_1.setVisible(true);
            Start_rating();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Start_rating() {
        Rating_arch_1.setVisible(true);
    }

    public void back_to_mode_sel(ActionEvent actionEvent) {
    }

    public void choice_task(ActionEvent actionEvent) {
    }
}
