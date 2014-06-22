package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import editor.services.draw_uml;
import editor.services.functions;
import editor.services.pattern_work;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class patern_e_C implements Initializable {

    @FXML
    public ListView LV_paterns_DB;
    @FXML
    public TableView TV_paterns_DB;
    @FXML
    public Label selected_DB;
    @FXML
    public MenuBar MB_main_menu;
    @FXML
    public MenuItem MI_connect;
    @FXML
    public MenuItem MI_disconnect;
    @FXML
    public TextField TF_patern_id_DB;
    @FXML
    public TextArea TA_patern_description;
    @FXML
    public ChoiceBox CB_paterns_master;
    @FXML
    public Pattern edited_pattern;
    Module edited_module;
    DerbyDBManager derby_DB;
    /*Кнопки*/
    @FXML
    private TextArea class_text;
    @FXML
    private TextField TF_patern_name_DB;
    @FXML
    private Image class_image;
    @FXML
    private javafx.scene.image.ImageView class_imageview;

    void initData(Module module, DerbyDBManager derby_con) {
        derby_DB = derby_con;
        edited_module = module;
        selected_DB.setText(derby_DB.getDbName().toString());
        list_load_DB();
    }

    public void initialize(URL url, ResourceBundle rb) {

        //list_load_DB();/**/

    }

    /*Действия*/
    @FXML//Отрисовка класса
    public void Action_draw_class(){
        Stage s = (Stage) class_text.getScene().getWindow();
        class_image = draw_uml.draw_class(class_text.getText());

        class_imageview.setFitHeight(class_image.getRequestedHeight());
        class_imageview.setFitWidth(class_image.getRequestedWidth());
        class_imageview.setImage(class_image);
    }


    //TODO загрузка превю
    public void load_this_patern_DB(ActionEvent actionEvent) {//ЗАгрузить патерн с базы
        //Читае Идентиф. Параметра
        edited_pattern = pattern_work.pattern_load_from_DB(functions.get_ID(LV_paterns_DB.getSelectionModel().getSelectedItem().toString()), derby_DB);


        TA_patern_description.setText(edited_pattern.getDescription());
        TF_patern_id_DB.setText(edited_pattern.getId().toString());
        class_text.setText(edited_pattern.getUml_text());
        TF_patern_name_DB.setText(edited_pattern.getName());
        class_image = edited_pattern.getPreview();
        class_imageview.setFitHeight(class_image.getRequestedHeight());
        class_imageview.setFitWidth(class_image.getRequestedWidth());
        class_imageview.setImage(class_image);
    }

    //TODO сохранение превю
    public void save_this_patern_DB(ActionEvent actionEvent) {//добавить патерн в базу
        edited_pattern.setMod_id(functions.get_ID(CB_paterns_master.getSelectionModel().getSelectedItem().toString()));
        edited_pattern.setName(TF_patern_name_DB.getText());
        edited_pattern.setUml_text(class_text.getText());
        edited_pattern.setDescription(TA_patern_description.getText());
        edited_pattern.setPreview(class_image);
        if (pattern_work.pattern_save_to_DB(edited_pattern, derby_DB).getStatus() == true) {
            JOptionPane.showMessageDialog(null, "Паттерн збережено.", "Інформація", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Помилка збереження зверныться до Адмыныстратора чи програміста.", "Попередження", JOptionPane.WARNING_MESSAGE);
        }
        list_load_DB();
        TF_patern_id_DB.setEditable(true);
        LV_paterns_DB.setDisable(false);
    }

    public void delete_patern_DB(ActionEvent actionEvent) {//удалить з базы по ID
        String query = "DELETE FROM PATERNS WHERE ID=" + functions.get_ID(LV_paterns_DB.getSelectionModel().getSelectedItem().toString());
        try {
            derby_DB.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list_load_DB();
    }

    private void list_load_DB() {//Загрузка з базы
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID="+edited_module.getId());
            } catch (SQLException e) {
                //если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                try {
                    String query = "CREATE TABLE PATERNS (\n" +
                            "  ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY\n" +
                            "        (START WITH 1, INCREMENT BY 1),\n" +
                            "  MOD_ID INT NOT NULL,\n" +
                            "  NAME VARCHAR(255) NOT NULL,\n" +
                            "  VALUE CLOB(1073741823) NOT NULL,\n" +
                            "  DESCRIPTION CLOB(1073741823),\n" +
                            "  PREVIEW BLOB" +
                            ")";
                    derby_DB.executeUpdate(query);
                    rs = derby_DB.executeQuery("SELECT * FROM PATERNS");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            LV_paterns_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            String id_name = LV_paterns_DB.getSelectionModel().getSelectedItem().toString();
            String id, name = new String();
            id = functions.get_ID(id_name).toString();
            name = functions.get_NAME(id_name);
            TF_patern_id_DB.setText(id);
            TF_patern_name_DB.setText(name);
        }
        //load_this_patern_DB(null);
    }


    public void show_help(ActionEvent actionEvent) {// Отобразить помощь
        try {
            Parent Parent = FXMLLoader.load(getClass().getResource("../views/help.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Помощь");
            Stage.setScene(new Scene(Parent));
            Stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show_about(ActionEvent actionEvent) {

    }

    public void close_mw(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/main_window_V2.fxml")
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        main_C controller = loader.<main_C>getController();
        controller.initData(edited_module,derby_DB);

        stage.show();
        Stage stage_this = (Stage) MB_main_menu.getScene().getWindow();
        // do what you have to do
        stage_this.close();

    }

    public void edit_patern(ActionEvent actionEvent) {//Редактировать патерн
        TF_patern_id_DB.setEditable(false);
        LV_paterns_DB.setDisable(true);
        select_to_save_DB();
        load_this_patern_DB(null);

    }

    public void moduls_load() {//загрузить модули
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM MODULE");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            CB_paterns_master.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void layer_master_select() {

    }

    public void create_pattern(ActionEvent actionEvent) {
        JDialog Jname=new JDialog();
        Jname.setAlwaysOnTop(true);
        String name = (String) JOptionPane.showInputDialog(null, "Введіть назву", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, "");

        //dialog.get
        if (name != null && !name.equals("")) {
            try {
                derby_DB.executeUpdate("INSERT INTO PATERNS (MOD_ID,NAME,VALUE,DESCRIPTION) VALUES (" + edited_module.getId() + ",'" + name + "','" + " " + "','" + " " + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list_load_DB();
        }/**/
    }
}