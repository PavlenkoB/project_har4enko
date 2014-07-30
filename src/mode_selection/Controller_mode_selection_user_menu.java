package mode_selection;

import Classes.log_in;
import editor.models.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import rating_arch.Controller.rating_arch_C;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alex on 06.05.2014.
 */


public class Controller_mode_selection_user_menu implements Initializable {
    public AnchorPane sel_next;
    public Menu adm_menu;
    public Menu arch_menu;
    public Menu exp_menu;
    public ChoiceBox user_choise;
    public PasswordField pass_write;
    public AnchorPane log_massage;
    Main editor = new Main();
    rating_arch_C rating = new rating_arch_C();
    public Button cancelButton;

    ArrayList<log_in> log_ins = new ArrayList<>();


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

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> user = FXCollections.observableArrayList();
        user.clear();
        user.addAll(new String("Адміністратор"),new String("Архітектор"),new String("Експерт"));
        user_choise.setItems(user);

        BufferedReader logining_read = null;
        ArrayList <String> buff_log = new ArrayList<>();

        try {
            logining_read = new BufferedReader(new FileReader("DB/ssap"));
        String line;
            while ((line = logining_read.readLine()) != null) {
                buff_log.add(line);
                log_ins.add(new log_in());
            }
            logining_read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i=0; i<buff_log.size(); i++){
            int string_length = 0;
            String log="";
            String pass="";
            boolean contr = false;

            while (string_length<(buff_log.get(i).length())){
                if ((buff_log.get(i).charAt(string_length)=='/')){
                    contr=true;
                }
                if (!contr){
                    log+=buff_log.get(i).charAt(string_length);
                }
                if ((contr)&!(buff_log.get(i).charAt(string_length)=='/')){
                    pass+=buff_log.get(i).charAt(string_length);
                }
                string_length++;
            }

            log_ins.get(i).setLogin(log);
            log_ins.get(i).setPassword(pass);
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

    public void logining(ActionEvent actionEvent) {
        String password=null;
        boolean log = false;
        if(user_choise.getSelectionModel().getSelectedItem().equals("Адміністратор")){
            for (int i=0; i<log_ins.size();i++){
                if (log_ins.get(i).getLogin().equals("adm") & pass_write.getText().equals(log_ins.get(i).getPassword())){
                    adm_menu.setDisable(false);
                    arch_menu.setDisable(true);
                    exp_menu.setDisable(true);

                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Вхід виконано - Адміністратором");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                    log = true;
                }
                else if (!log){
                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Пароль введений невірно");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                }
            }
        };
        if(user_choise.getSelectionModel().getSelectedItem().equals("Архітектор")){
            for (int i=0; i<log_ins.size();i++){
                if (log_ins.get(i).getLogin().equals("arch") & pass_write.getText().equals(log_ins.get(i).getPassword())){
                    adm_menu.setDisable(true);
                    arch_menu.setDisable(false);
                    exp_menu.setDisable(true);

                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Вхід виконано - Архітектором");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                    log = true;
                }
                else if (!log){
                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Пароль введений невірно");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                }
            }
        };
        if(user_choise.getSelectionModel().getSelectedItem().equals("Експерт")){
            for (int i=0; i<log_ins.size();i++){
                if (log_ins.get(i).getLogin().equals("exp") & pass_write.getText().equals(log_ins.get(i).getPassword())){
                    adm_menu.setDisable(true);
                    arch_menu.setDisable(true);
                    exp_menu.setDisable(false);

                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Вхід виконано - Експертом");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                    log = true;
                }
                else if (!log){
                    log_massage.getChildren().clear();
                    Label log_mass = new Label("Пароль введений невірно");
                    log_mass.setAlignment(Pos.CENTER);
                    log_mass.setFont(Font.font(15));
                    log_massage.setRightAnchor(log_mass,25.0);
                    log_massage.setLeftAnchor(log_mass, 25.0);
                    log_massage.setTopAnchor(log_mass, 5.0);
                    log_massage.setBottomAnchor(log_mass,5.0);
                    log_massage.getChildren().add(log_mass);
                }
            }
        };
    }
}
