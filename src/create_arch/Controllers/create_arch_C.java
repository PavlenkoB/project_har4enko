package create_arch.Controllers;

import editor.services.draw_uml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import rating_arch.DB_manager;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */

/**
 * Created by Alex on 10.05.2014.
 */
public class create_arch_C implements Initializable {
    public MenuItem close;
    public VBox background;
    public Button Arch_chek;
    public ListView Arch_list;
    public TextArea Description;
    public String name_choise;
    public Architecture[] archery;
    public ImageView Usecase_view;
    @FXML
    private Image class_image;


    DB_manager derby_DB = new DB_manager("paterns_DB");

    //Windows close dialog
    public Button cancelButton;
    public Button okButton;

    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/create_arch/Interface/Close.fxml"));
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
    //Windows close dialog

    public void disconnect_DB(ActionEvent actionEvent) {
        if (derby_DB != null) {
            derby_DB.disconectDB();
            derby_DB = null;
        }
        ObservableList<String> items = FXCollections.observableArrayList();
    }

    public void initialize(URL url, ResourceBundle rb) {
        try {
            set_usecase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set_usecase() throws IOException, SQLException {
        archery = usecase();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < archery.length; i++) {
            items.add(archery[i].getName());
        }
        Arch_list.setItems(items);
    }

    public Architecture[] usecase() throws IOException, SQLException {
        String query = "SELECT * FROM ARCHITECTURE";
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        while (buf_q_result.next()) {
            res_count++;
        }
        Architecture[] usecase = new Architecture[res_count];
        res_count = 0;
        while (q_result.next()) {
            usecase[res_count] = new Architecture();
            usecase[res_count].setId(q_result.getInt("ID"));
            usecase[res_count].setDescription(q_result.getString("Description"));
            usecase[res_count].setName(q_result.getString("NAME"));
           /*
            System.out.println("ID: " + usecase[res_count].getId());
            System.out.println("Description: " + usecase[res_count].getDescription());
            System.out.println("NAME: " + usecase[res_count].getName());
            */
            res_count++;
        }

        return (usecase);
    }

    public void arch_create_next(ActionEvent actionEvent) {
    }

    public void canceler(ActionEvent actionEvent) {
    }

    public void select_to_display(){
        if (derby_DB != null) {
            String name_list=Arch_list.getSelectionModel().getSelectedItem().toString();
            name_choise=name_list;
            for (int i=0;i<archery.length;i++){
                if (name_list.equals(archery[i].name)){
                    Description.setText(archery[i].description);
                    //Action_draw_class();
                    class_image= draw_uml.draw_class(archery[i].usecase);
                    Usecase_view.setFitHeight(class_image.getRequestedHeight());
                    Usecase_view.setFitWidth(class_image.getRequestedWidth());
                    Usecase_view.setImage(class_image);
                    Usecase_view.setImage(class_image);
                }
            }
        }
    }
    /*Действия*/
    @FXML//Отрисовка класса
    public void Action_draw_class() throws IOException, InterruptedException {
        class_image= draw_uml.draw_class("Class1 ..> class2");
        Usecase_view.setFitHeight(class_image.getRequestedHeight());
        Usecase_view.setFitWidth(class_image.getRequestedWidth());
        Usecase_view.setImage(class_image);
        Usecase_view.setImage(class_image);
    }
}
