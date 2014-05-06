package rating_arch.Controller;

import rating_arch.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import rating_arch.DB_manager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Controller_main {
    public Button cancelButton;
    public RadioButton choice1_set_new_arch;
    public RadioButton choice1_rate_task;
    public Button sel_next_1;
    public Stage create_new_arch_win;


    DB_manager derby_DB = new DB_manager("paterns_DB");


    public void close(ActionEvent actionEvent) throws IOException {

        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/close.fxml"));
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

    public void sel_next_open_main(ActionEvent actionEvent) {
        Stage sel_mode = (Stage) sel_next_1.getScene().getWindow();
        if (choice1_set_new_arch.isSelected()) {
            try {
                create_new_arch_win = new Stage();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/Create_new_arch.fxml"));
                create_new_arch_win.setTitle("Archery create");
                create_new_arch_win.setScene(new Scene(root, 800, 600));
                create_new_arch_win.setResizable(true);
                create_new_arch_win.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (choice1_rate_task.isSelected()) {
            try {
                create_new_arch_win = new Stage();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/close.fxml"));
                create_new_arch_win.setTitle("Archery rate");
                create_new_arch_win.setScene(new Scene(root, 800, 600));
                create_new_arch_win.setResizable(false);
                create_new_arch_win.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sel_mode.close();
    }

    public Architecture[] usecase() throws IOException, SQLException {
        String query = "SELECT * FROM ARCHITECTURE";
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        //q_result.last();
        //res_count = q_result.getRow();
        while (buf_q_result.next()){
            res_count++;
        }
        Architecture[] usecase = new Architecture[res_count];
        res_count = 0;
        //q_result.first();
        while (q_result.next()){
            usecase[res_count] = new Architecture();
            usecase[res_count].setId(q_result.getInt("ID"));
            usecase[res_count].setDescription(q_result.getString("Description"));
            usecase[res_count].setName(q_result.getString("NAME"));
            System.out.println("ID: " + usecase[res_count].getId());
            System.out.println("Description: " + usecase[res_count].getDescription());
            System.out.println("NAME: " + usecase[res_count].getName());
            res_count++;
        }

        return (usecase);
    }

}
