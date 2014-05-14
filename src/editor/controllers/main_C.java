package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import editor.classes.DerbyDBManager;
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
import javax.swing.text.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class main_C implements Initializable {

    public ListView LV_paterns_DB;
    public TableView TV_paterns_DB;
    public Label selected_DB;
    public MenuBar MB_main_menu;
    public MenuItem MI_connect;
    public MenuItem MI_disconnect;
    public TextField TF_patern_id_DB;
    /*Кнопки*/
    @FXML
    private TextArea class_text;
    @FXML
    private TextField TF_patern_name_DB;
    @FXML
    private Image class_image;
    @FXML
    private javafx.scene.image.ImageView class_imageview;

    DerbyDBManager derby_DB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
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
    public void Action_draw_class() throws IOException, InterruptedException {
        BufferedWriter out_data = new BufferedWriter(new FileWriter(new File("class.txt")));
        StringReader stringReader = new StringReader(class_text.getText());
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        out_data.write("@startuml");
        out_data.newLine();
        out_data.write("skinparam backgroundColor transparent\n" +//Прозрачный фон
                "skinparam roundCorner 10");                        //Скругленый углы
        out_data.newLine();
        for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            out_data.write(line);
            out_data.newLine();
        }
        out_data.newLine();
        out_data.write("@enduml");
        bufferedReader.close();
        out_data.close();
        /*out_data.write("@startuml");
        out_data.newLine();
        out_data.write(class_text.getText());
        out_data.newLine();
        out_data.write("@enduml");
        out_data.close();*/
        String[] cmd = {"cmd", "/C", "plantuml.jar -charset utf-8 class.txt"};     //запустить отрисовку
        Process p = Runtime.getRuntime().exec(cmd);
        System.out.println("Waiting for batch file ...");
        p.waitFor();                                                            //Ждать пока отрисует
        System.out.println("Batch file done.");
        class_image = new Image("file:class.png", true);
        class_image.getRequestedHeight();
        class_imageview.setFitHeight(class_image.getRequestedHeight());
        class_imageview.setFitWidth(class_image.getRequestedWidth());
        class_imageview.setImage(class_image);
    }

    public void load_this_patern_DB(ActionEvent actionEvent) {//TODO ЗАгрузить патерн с базы
        //Читае Идентиф. Параметра
        String query = "SELECT * FROM PATERNS WHERE ID=" + get_ID(LV_paterns_DB.getSelectionModel().getSelectedItem().toString());
        ResultSet q_result;
        try {
            q_result = derby_DB.executeQuery(query);
            q_result.next();
            class_text.setText(q_result.getString("VALUE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save_this_patern_DB(ActionEvent actionEvent) {//TODO добавить патерн в базу
        if(TF_patern_id_DB.getText().length()==0) {
            String query = "INSERT INTO PATERNS (MOD_ID,NAME,VALUE,DESCRIPTION) VALUES (2,'" + TF_patern_name_DB.getText() + "','" + class_text.getText() + "','jhg')";
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            String query = "UPDATE PATERNS " +
                    "SET MOD_ID=2,NAME='"+TF_patern_name_DB.getText()+"',VALUE='" + class_text.getText() + "',DESCRIPTION='jhg' WHERE ID="+get_ID(LV_paterns_DB.getSelectionModel().getSelectedItem().toString());
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        list_load_DB();
        TF_patern_id_DB.setEditable(true);
        LV_paterns_DB.setDisable(false);
    }

    public void delete_patern_DB(ActionEvent actionEvent) {//TODO удалить з базы по ID
        String query = "DELETE FROM PATERNS WHERE ID=" +  get_ID(LV_paterns_DB.getSelectionModel().getSelectedItem().toString());
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
                rs = derby_DB.executeQuery("SELECT * FROM PATERNS");
            } catch (SQLException e) {
                System.out.print("ssdsa");
                //если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                try {
                    String query = "CREATE TABLE PATERNS (\n" +
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
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            LV_paterns_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
        String id_name=LV_paterns_DB.getSelectionModel().getSelectedItem().toString();
        String id,name=new String();
            id=get_ID(id_name);
            name=get_NAME(id_name);
            TF_patern_id_DB.setText(id);
            TF_patern_name_DB.setText(name);
        }
        load_this_patern_DB(null);
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
        LV_paterns_DB.setItems(items);
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

            //hide this current window (if this is whant you want
            //((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show_about(ActionEvent actionEvent) {

    }

    public void close_mw(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void edit_patern(ActionEvent actionEvent) {//Редактировать патерн
        TF_patern_id_DB.setEditable(false);
        LV_paterns_DB.setDisable(true);
        select_to_save_DB();
        load_this_patern_DB(null);

    }
}