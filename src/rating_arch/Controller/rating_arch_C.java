package rating_arch.Controller;

import Classes.Architecture;
import editor.classes.DerbyDBManager;
import editor.services.functions;
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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM TASK");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                //System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            task_list.setItems(items);
            task_list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                    task_description_view(new_value);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        try {
            rs_task = derby_DB.executeQuery("SELECT * FROM TASK WHERE ID=" + functions.get_ID((String) task_list.getItems().get(new_value.intValue())));
            rs_task.next();
            task_description.clear();
            task_description.setText(rs_task.getString("DESCRIPTION"));
            task_description.setEditable(false);
        } catch (SQLException e) {
        }
        ;
    }

    public void back_to_mode_sel(ActionEvent actionEvent) {
    }

    public void choice_task(ActionEvent actionEvent) {
    }

}
