package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import editor.classes.DerbyDBManager;
import editor.services.draw_uml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class modul_e_C implements Initializable {

    public ListView LV_modules_DB;
    public TableView TV_modules_DB;
    public Label selected_DB;
    public MenuBar MB_main_menu;
    public MenuItem MI_connect;
    public MenuItem MI_disconnect;
    public TextField TF_module_id_DB;
    public TextArea TA_module_description;
    public ChoiceBox CB_module_master;
    /*Кнопки*/
    @FXML
    private TextArea class_text;
    @FXML
    private TextField TF_module_name_DB;
    @FXML
    private Image class_image;
    @FXML
    private javafx.scene.image.ImageView class_imageview;

    DerbyDBManager derby_DB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO Del
        derby_DB = new DerbyDBManager("DB/paterns_DB");
        list_load_DB();/**/
        layer_load();

    }

    public String get_ID(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }

    public String get_NAME(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            line_pos++;
        }
        line_pos++;
        while (line_pos<in_string.length()) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }



    /*Действия*/
    @FXML//Отрисовка класса
    public void Action_draw_class() throws IOException, InterruptedException {
        class_image=draw_uml.draw_class(class_text.getText());
        class_imageview.setFitHeight(class_image.getRequestedHeight());
        class_imageview.setFitWidth(class_image.getRequestedWidth());
        class_imageview.setImage(class_image);
    }

    public void load_this_module_DB(ActionEvent actionEvent) {//TODO ЗАгрузить патерн с базы
        //Читае Идентиф. Параметра
        String query = "SELECT * FROM MODULE WHERE ID=" + get_ID(LV_modules_DB.getSelectionModel().getSelectedItem().toString());
        ResultSet q_result;
        try {
            q_result = derby_DB.executeQuery(query);
            q_result.next();
            TA_module_description.setText(q_result.getString("DESCRIPTION"));

            ResultSet rs = null;
            rs = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ID="+q_result.getString("LAY_ID"));//Получить данные о слою
            rs.next();
            CB_module_master.setValue(rs.getInt("ID") + "|" + rs.getString("NAME"));//Поставить селект
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save_this_module_DB(ActionEvent actionEvent) {//добавить патерн в базу
        if(TF_module_id_DB.getText().length()==0) {
            String query = "INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES ("+get_ID(CB_module_master.getSelectionModel().getSelectedItem().toString())+",'" + TF_module_name_DB.getText() + "','"+TA_module_description.getText()+"')";
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            String query = "UPDATE MODULE " +//TODO ДО какого модуля
                    "SET LAY_ID="+get_ID(CB_module_master.getSelectionModel().getSelectedItem().toString())+",NAME='"+TF_module_name_DB.getText()+"',DESCRIPTION='"+TA_module_description.getText()+"' WHERE ID="+get_ID(LV_modules_DB.getSelectionModel().getSelectedItem().toString());
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        list_load_DB();
        TF_module_id_DB.setEditable(true);
        LV_modules_DB.setDisable(false);
    }

    public void delete_module_DB(ActionEvent actionEvent) {//удалить з базы по ID
        String query = "DELETE FROM MODULE WHERE ID=" +  get_ID(LV_modules_DB.getSelectionModel().getSelectedItem().toString());
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
                rs = derby_DB.executeQuery("SELECT * FROM MODULE");
            } catch (SQLException e) {
                System.out.print("ssdsa");
                //TODO если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                try {
                    String query = "CREATE TABLE MODULE (\n" +
                            "  ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY\n" +
                            "    (START WITH 1, INCREMENT BY 1),\n" +
                            "  LAY_ID INT NOT NULL ,\n" +
                            "  NAME VARCHAR(255) NOT NULL,\n" +
                            "  DESCRIPTION CLOB(1073741823)\n" +
                            ")";
                    derby_DB.executeUpdate(query);
                    rs = derby_DB.executeQuery("SELECT * FROM MODULE");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            LV_modules_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            String id_name=LV_modules_DB.getSelectionModel().getSelectedItem().toString();
            String id,name=new String();
            id=get_ID(id_name);
            name=get_NAME(id_name);
            TF_module_id_DB.setText(id);
            TF_module_name_DB.setText(name);
        }
       load_this_module_DB(null);
    }

    public void connect_DB(ActionEvent actionEvent) {
        disconnect_DB(null);
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Выберете каталог с базой");
        db_dir.showDialog(null, "Выбрать...");
        // существет ли база(создана ли)

        derby_DB = new DerbyDBManager(db_dir.getSelectedFile().getAbsolutePath());
        selected_DB.setText(db_dir.getName(db_dir.getSelectedFile()));
        list_load_DB();
        MI_connect.setDisable(true);
        MI_disconnect.setDisable(false);
    }

    public void disconnect_DB(ActionEvent actionEvent) {//отключиться от БД
        if (derby_DB != null) {
            derby_DB.disconectDB();
            derby_DB = null;
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        LV_modules_DB.setItems(items);
        selected_DB.setText("<null>");
        MI_connect.setDisable(false);
        MI_disconnect.setDisable(true);
    }

    public void creat_DB(ActionEvent actionEvent) { //Создать БД
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Выберете каталог под базу");
        db_dir.showDialog(null, "Выбрать...");
        String new_db_name = JOptionPane.showInputDialog("Введите имя новой базы");
        new DerbyDBManager(db_dir.getSelectedFile().getAbsolutePath() + "\\" + new_db_name);
        //derby_DB = new DerbyDBManager(db_dir.getSelectedFile().getAbsolutePath());
        //list_load_DB();
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
        System.exit(1);
    }

    public void edit_module(ActionEvent actionEvent) {//Редактировать патерн
        TF_module_id_DB.setEditable(false);
        LV_modules_DB.setDisable(true);
        select_to_save_DB();
        load_this_module_DB(null);

    }

    public void layer_load(){//загрузить слои
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM LAYER");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            CB_module_master.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void module_master_select(){

    }
}