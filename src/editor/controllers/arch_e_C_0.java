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
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class arch_e_C_0 implements Initializable {

    public ListView LV_archs_DB;
    public TableView TV_archs_DB;
    public Label selected_DB;
    public MenuBar MB_main_menu;
    public MenuItem MI_connect;
    public MenuItem MI_disconnect;
    public TextField TF_arch_id_DB;
    public TextArea TA_arch_description;
    /*Кнопки*/
    @FXML
    private TextArea arch_text;
    @FXML
    private TextField TF_arch_name_DB;
    @FXML
    private Image arch_image;
    @FXML
    private javafx.scene.image.ImageView arch_imageview;

    DerbyDBManager derby_DB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO Del
        derby_DB = new DerbyDBManager("DB/paterns_DB");
        list_load_DB();/**/
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
    public void Action_draw_arch() throws IOException, InterruptedException {
        arch_image=draw_uml.draw_class(arch_text.getText());
        arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        arch_imageview.setImage(arch_image);
    }

    public void load_this_arch_DB(ActionEvent actionEvent) {//TODO ЗАгрузить патерн с базы
        //Читае Идентиф. Параметра
        String query = "SELECT * FROM ARCHITECTURE WHERE ID=" + get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString());
        ResultSet q_result;
        try {
            q_result = derby_DB.executeQuery(query);
            q_result.next();
            arch_text.setText(q_result.getString("USECASE"));
            TA_arch_description.setText(q_result.getString("DESCRIPTION"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save_this_arch_DB(ActionEvent actionEvent) {//TODO добавить патерн в базу
        if(TF_arch_id_DB.getText().length()==0) {
            String query = "INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES ('" + TF_arch_name_DB.getText() + "','" + arch_text.getText() + "','"+TA_arch_description.getText()+"')";
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            String query = "UPDATE ARCHITECTURE " +
                    "SET NAME='"+TF_arch_name_DB.getText()+"',USECASE='" + arch_text.getText() + "',DESCRIPTION='"+TA_arch_description.getText()+"' WHERE ID="+get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString());
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }

        list_load_DB();
        TF_arch_id_DB.setEditable(true);
        LV_archs_DB.setDisable(false);
    }

    public void delete_arch_DB(ActionEvent actionEvent) {//TODO удалить з базы по ID
        String query = "DELETE FROM ARCHITECTURE WHERE ID=" +  get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString());
        try {
            derby_DB.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list_load_DB();
    }

    private void list_load_DB() {//TODO Загрузка з базы
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE");
            } catch (SQLException e) {
                System.out.print("Создаю таблицу)");
                //если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                /*try {
                    String query = "CREATE TABLE ARCHITECTURE (\n" +
                            "  ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY\n" +
                            "        (START WITH 1, INCREMENT BY 1),\n" +
                            "  MOD_ID INT NOT NULL,\n" +
                            "  NAME VARCHAR(255) NOT NULL,\n" +
                            "  VALUE CLOB(1073741823) NOT NULL,\n" +
                            "  DESCRIPTION CLOB(1073741823)\n" +
                            ")";
                    derby_DB.executeUpdate(query);
                    list_load_DB();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();*/
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            LV_archs_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            String id_name=LV_archs_DB.getSelectionModel().getSelectedItem().toString();
            String id,name=new String();
            id=get_ID(id_name);
            name=get_NAME(id_name);
            TF_arch_id_DB.setText(id);
            TF_arch_name_DB.setText(name);
        }
        load_this_arch_DB(null);
    }

    public void connect_DB(ActionEvent actionEvent) {
        disconnect_DB(null);
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Выберете каталог с базой");
        db_dir.showDialog(null, "Выбрать...");
        //TODO существет ли база(создана ли)

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
        LV_archs_DB.setItems(items);
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

    public void edit_arch(ActionEvent actionEvent) {//Редактировать патерн
        TF_arch_id_DB.setEditable(false);
        LV_archs_DB.setDisable(true);
        select_to_save_DB();
        load_this_arch_DB(null);

    }
}