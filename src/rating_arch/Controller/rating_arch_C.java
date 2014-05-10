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
public class rating_arch_C {
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

    public Architecture[] usecase() throws IOException, SQLException {
        String query = "SELECT * FROM ARCHITECTURE";
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        //q_result.last();
        //res_count = q_result.getRow();
        while (buf_q_result.next()) {
            res_count++;
        }
        Architecture[] usecase = new Architecture[res_count];
        res_count = 0;
        //q_result.first();
        while (q_result.next()) {
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
