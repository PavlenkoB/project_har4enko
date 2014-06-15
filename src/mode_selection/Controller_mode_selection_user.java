package mode_selection;

import editor.models.Main;
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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rating_arch.Controller.rating_arch_C;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Alex on 06.05.2014.
 */


public class Controller_mode_selection_user implements Initializable {
    Main editor = new Main();
    rating_arch_C rating = new rating_arch_C();
    public Button cancelButton;
    public Button sel_next;
    public ChoiceBox user_choise;
    public ChoiceBox func_choise;
    public TextField user_password;
    public Stage create_new_arch_win;

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


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> users = FXCollections.observableArrayList();
        users.addAll("Архітектор", "Адміністратор", "Експерт");
        user_choise.setItems(users);

        user_choise.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                func_mode_choise(new_value);
            }
        });
    }

    public void func_mode_choise(Number new_value) {
        ObservableList<String> func_mod = FXCollections.observableArrayList();
        func_mod.clear();
        if (new_value.intValue()==0){
            func_mod.addAll("Конструктор нових варіантів архітектур","Оцінювання існуючих архітектур");
        } else if (new_value.intValue()==1){
            func_mod.addAll("Редактор патернів та архітектур","Конструктор нових варіантів архітектур");
        } else if (new_value.intValue()==2){
            func_mod.add("Оцінювання існуючих архітектур");
        } else {
            System.out.println("ошибка");
        }
        func_choise.setItems(func_mod);;
    }


    public void sel_next_open_main(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next.getScene().getWindow();
        if (func_choise.getSelectionModel().getSelectedItem().equals("Конструктор нових варіантів архітектур")){
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
        } else if (func_choise.getSelectionModel().getSelectedItem().equals("Оцінювання існуючих архітектур")){
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
        } else if (func_choise.getSelectionModel().getSelectedItem().equals("Редактор патернів та архітектур")){
            try {
                editor.start(sel_mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
