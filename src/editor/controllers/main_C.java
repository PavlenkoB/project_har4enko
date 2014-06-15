package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import editor.classes.DerbyDBManager;
import editor.classes.result_info;
import editor.services.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.xml.soap.Node;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class main_C implements Initializable {
    public Label selected_DB;
    public Button B_connect;
    public Button B_create;
    public Button B_disconnect;
    public Pane B_G_editors;
    /*Кнопки*/

    public TextArea TA_arch_description;
    public TextField TF_arch_id_DB;
    public TextField TF_arch_name_DB;
    public ListView LV_archs_DB;
    public TextArea TA_arch_relations;
    public Pane P_arch_struct;
    public ImageView IV_arch_imageview;
    public Pane P_IV;
    public ScrollPane SP_P_IV;
    public MenuItem MM_1_1_connect;
    public MenuItem MM_1_2_create_DB;
    public MenuItem MM_1_3_disconnect;
    DerbyDBManager derby_DB;
    Architecture arch_tmp, arch_old = new Architecture();
    @FXML
    private Image arch_image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//TODO Del
        try {
            derby_DB = new DerbyDBManager("DB/paterns_DB");
            list_load_DB();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }

        if (derby_DB != null) {
            MM_1_1_connect.setDisable(true);
            MM_1_3_disconnect.setDisable(false);
        }/**/
    }

    public void connect_DB(ActionEvent actionEvent) {
        try {
            disconnect_DB(null);
            JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
            db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            db_dir.setAcceptAllFileFilterUsed(false);
            db_dir.setDialogTitle("Выберете каталог с базой");
            db_dir.showDialog(null, "Выбрать...");
            // существет ли база(создана ли)

            derby_DB = new DerbyDBManager(db_dir.getSelectedFile().getAbsolutePath());
            selected_DB.setText(db_dir.getName(db_dir.getSelectedFile()));
            //TODO доступность кнопок
            list_load_DB();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }
        if (derby_DB != null) {
            MM_1_1_connect.setDisable(true);
            MM_1_3_disconnect.setDisable(false);
        }
    }

    public void disconnect_DB(ActionEvent actionEvent) {//отключиться от БД
        if (derby_DB != null) {
            derby_DB.disconectDB();
        }
        derby_DB = null;
        LV_archs_DB.setItems(null);
        P_arch_struct.getChildren().clear();

        selected_DB.setText("<не обрана>");
        //TODO доступность кнопок
        if (derby_DB == null) {
            MM_1_1_connect.setDisable(false);
            MM_1_3_disconnect.setDisable(true);
        }
    }

    public void creat_DB(ActionEvent actionEvent) { //Создать БД
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Выберете каталог під базу");
        db_dir.showDialog(null, "Обрати...");
        //String new_db_name = JOptionPane.showInputDialog("Введіть імя нової бази");


        derby_DB = new DerbyDBManager(db_dir.getSelectedFile().getAbsolutePath() + "\\");

        System.out.print("Создаю таблиці)");
        try {
            File in_dir = new File(getClass().getClassLoader().getResource("editor/sql/create_DB").getFile());
            //ResourceAsStream("/editor/sql/creat_DB");

            File[] fList;

            fList = in_dir.listFiles();

            for (int i = 0; i < fList.length; i++) {
                //Нужны только папки в место isFile() пишим isDirectory()
                if (fList[i].isFile()) {

                    String filename = fList[i].getName();
                    int dotPos = filename.lastIndexOf(".");
                    String ext = filename.substring(dotPos);
                    if (ext.equals(".sql")) {
                        derby_DB.executeUpdate_from_file(fList[i]);
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO создание
    }


    public void close_mw(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void show_help(ActionEvent actionEvent) {// Отобразить помощь
        try {
            Parent Parent = FXMLLoader.load(getClass().getResource("../views/help.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle("Допомога");
            Stage.setScene(new Scene(Parent));
            Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show_about(ActionEvent actionEvent) {


    }


    public void create_backup(ActionEvent actionEvent) throws IOException {
        File mydir = new File("DB");
        File myfile = new File("DB_backup/" + new SimpleDateFormat("dd.MM.yyyy_HH_mm_ss").format(new Date()) + ".zip");
        zip.zip_dir(mydir, myfile);
        System.out.println(mydir.toURI().relativize(myfile.toURI()).getPath());
    }


    public void clear_db(ActionEvent actionEvent) {
        //TODO del
        derby_DB = new DerbyDBManager("DB/paterns_DB");
        //TODO Уборка в базе
        ArrayList<Integer> arch_id = new ArrayList<>();
        ArrayList<Integer> lay_id = new ArrayList<>();
        ArrayList<Integer> mod_id = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE");
            while (rs.next()) {
                arch_id.add(rs.getInt("ID"));
            }
            rs = derby_DB.executeQuery("SELECT * FROM LAYER");
            while (rs.next()) {
                Boolean svyazan = false;
                for (int s = 0; s < arch_id.size(); s++) {
                    if (rs.getInt("ARCH_ID") == arch_id.get(s))
                        svyazan = true;
                }
                if (svyazan == true)
                    lay_id.add(rs.getInt("ID"));
                else {
                    derby_DB.executeUpdate("DELETE FROM LAYER WHERE ID=" + rs.getInt("ID"));
                }
            }

            rs = derby_DB.executeQuery("SELECT * FROM MODULE");
            while (rs.next()) {
                Boolean svyazan = false;
                for (int s = 0; s < lay_id.size(); s++) {
                    if (rs.getInt("LAY_ID") == lay_id.get(s))
                        svyazan = true;
                }
                if (svyazan == true)
                    mod_id.add(rs.getInt("ID"));
                else {
                    derby_DB.executeUpdate("DELETE FROM MODULE WHERE ID=" + rs.getInt("ID"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        derby_DB.disconectDB();
    }


    public void load_this_arch_DB(ActionEvent actionEvent) {//ЗАгрузить архитектуру с базы
        //Читае Идентиф. Параметра
        arch_tmp = arch_work.arch_load_from_DB(functions.get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString()), derby_DB);
        try {
            arch_old = arch_tmp.clone();//сохраним оригинальный вариант архитектуры
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        TA_arch_relations.setText(arch_tmp.getUsecase());
        TA_arch_description.setText(arch_tmp.getDescription());
        draw_arch_struct();
    }


    public void delete_arch_DB(ActionEvent actionEvent) {//удалить з базы по ID
        String query = "DELETE FROM ARCHITECTURE WHERE ID=" + functions.get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString());
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
                rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE");
            } catch (SQLException e) {
                e.printStackTrace();
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
            String id_name = LV_archs_DB.getSelectionModel().getSelectedItem().toString();
            String id, name = new String();
            id = functions.get_ID(id_name).toString();
            name = functions.get_NAME(id_name);
            TF_arch_id_DB.setText(id);
            TF_arch_name_DB.setText(name);
        }
        load_this_arch_DB(null);
        if (arch_tmp.getPreview() != null) {
            arch_image = arch_tmp.getPreview();
        } else {
            arch_image = new Image("editor/res/img/preview-not-available.jpg");
        }
        //TODO перепроверить вывод что бы было удобно
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        //SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);
    }

    public void draw_arch_struct() {//відобразити структуру архітектури
        P_arch_struct.getChildren().clear();
        Integer pos_x = 0, pos_y = 0, s_x1 = 30, s_y1 = 30, s_x2 = 80, s_y2 = 30;
        Button tmp_btn;
        Label tmp_label;
        //pos_x += s_x1;
        //pos_y += s_y1;
        for (int s_lay = 0; s_lay < arch_tmp.getLayers().size(); s_lay++) {
            //Редагування
            tmp_btn = new Button("Редагувати");
            //tmp_btn.setPrefWidth(s_x2);
            //tmp_btn.setPrefHeight(s_y2);
            tmp_btn.setLayoutX(pos_x);
            tmp_btn.setLayoutY(pos_y);
            final int finalS_lay4 = s_lay;
            tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    edit_lay(finalS_lay4);
                }
            });
            P_arch_struct.getChildren().add(tmp_btn);
                /*Кнопка видалення*/
            tmp_btn = new Button("Видалити");
            //tmp_btn.setPrefWidth(s_x2);
            //tmp_btn.setPrefHeight(s_y2);
            tmp_btn.setLayoutX(pos_x + s_x2);
            tmp_btn.setLayoutY(pos_y);
            final int finalS_lay2 = s_lay;
            tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    del_lay(finalS_lay2);
                }
            });
            P_arch_struct.getChildren().add(tmp_btn);
            // Імя шару
            tmp_label = new Label("Шар " + arch_tmp.getLayers().get(s_lay).getName());
            tmp_label.setLayoutX(pos_x + s_x2 + s_x2);
            tmp_label.setLayoutY(pos_y);
            P_arch_struct.getChildren().add(tmp_label);
            pos_y += s_y1;
            pos_x += s_x1;
            //Модулі
            for (int s_mod = 0; s_mod < arch_tmp.getLayers().get(s_lay).getModules().size(); s_mod++) {//вивід модулів
                /*Кнопка Патернів*/
                tmp_btn = new Button("Патерни...");
                //tmp_btn.setPrefWidth(s_x2);
                //tmp_btn.setPrefHeight(s_y2);
                tmp_btn.setLayoutX(pos_x);
                tmp_btn.setLayoutY(pos_y);
                final int finalS_mod4 = s_mod;
                final int finalS_lay5 = s_lay;
                tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        edit_mod_paterns(finalS_lay5, finalS_mod4);
                    }
                });
                P_arch_struct.getChildren().add(tmp_btn);
                /*Кнопка редагування*/
                tmp_btn = new Button("Редагувати");
                //tmp_btn.setPrefWidth(s_x2);
                //tmp_btn.setPrefHeight(s_y2);
                pos_x += s_x2;
                tmp_btn.setLayoutX(pos_x);
                tmp_btn.setLayoutY(pos_y);
                final int finalS_mod1 = s_mod;
                final int finalS_lay3 = s_lay;
                tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        edit_mod(finalS_lay3, finalS_mod1);
                    }
                });
                P_arch_struct.getChildren().add(tmp_btn);
                /*Кнопка видалення*/

                tmp_btn = new Button("Видалити");
                //tmp_btn.setPrefWidth(s_x2);
                //tmp_btn.setPrefHeight(s_y2);
                pos_x += s_x2;
                tmp_btn.setLayoutX(pos_x);
                tmp_btn.setLayoutY(pos_y);
                final int finalS_mod = s_mod;
                final int finalS_lay1 = s_lay;
                tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        del_mod(finalS_lay1, finalS_mod);
                    }
                });
                P_arch_struct.getChildren().add(tmp_btn);
                /*Імя модулю*/
                tmp_label = new Label("Модуль " + arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getName());
                pos_x += s_x2;
                tmp_label.setLayoutX(pos_x);
                tmp_label.setLayoutY(pos_y);
                P_arch_struct.getChildren().add(tmp_label);
                pos_y += s_y2 - s_y1;//різниця між висотой між слоями і розміром кнопки
                pos_y += s_y1 + 5;//Сдвиг вниз
                pos_x = s_x1;
            }
            tmp_btn = new Button("Додати модуль");
            tmp_btn.setLayoutX(pos_x);
            tmp_btn.setLayoutY(pos_y);
            final int finalS_lay = s_lay;
            tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    add_custom_mod_to_layer(arch_tmp, finalS_lay);
                }
            });
            P_arch_struct.getChildren().add(tmp_btn);
            pos_y += s_y1;
            pos_x -= s_x1;
        }
        tmp_btn = new Button("Додати шар");
        tmp_btn.setLayoutX(pos_x);
        tmp_btn.setLayoutY(pos_y);
        tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                add_custom_layer_to_arch(arch_tmp);
            }
        });
        P_arch_struct.getChildren().add(tmp_btn);
        //P_arch_struct.setPrefHeight(pos_y);
    }

    private void edit_mod_paterns(int lay, int mod) {//Редагувати патрни шару
        try {
            arch_old = arch_tmp.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        arch_work.arch_save_to_DB(arch_old, derby_DB);
    }

    public void add_custom_layer_to_arch(Architecture arch_in) {//Додати шар в архітектуру
        Layer layer = new Layer();

        String name = (String) JOptionPane.showInputDialog("Введіть назву");
        if (name != null && !name.equals("")) {
            String description = (String) JOptionPane.showInputDialog("Введіть опис");
            layer.setName(name);
            layer.setDescription(description);
            arch_in.getLayers().add(layer);
            arch_tmp = arch_in;
        }
        draw_arch_struct();
    }

    public void add_custom_mod_to_layer(Architecture arch_in, Integer lay_nom) {//додати модуль в шар
        Module module = new Module();
        String name = (String) JOptionPane.showInputDialog("Введіть назву");
        if (name != null && !name.equals("")) {//перевірка на пустий ввід
            String description = (String) JOptionPane.showInputDialog("Введіть опис");
            module.setName(name);
            module.setDescription(description);
            arch_in.getLayers().get(lay_nom).getModules().add(module);
            arch_tmp = arch_in;
        }
        draw_arch_struct();
    }

    public void del_mod(Integer lay_nom, Integer mod_nom) {
        Object stringArray[] = {"Так", "Ні"};
        int response = JOptionPane.showOptionDialog(null, "Ви впевнені що хочете видалити модуль?", "Питання",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, stringArray[0]);
        if (response == JOptionPane.YES_OPTION) {
            arch_tmp.getLayers().get(lay_nom.intValue()).getModules().remove(mod_nom.intValue());
        }
        draw_arch_struct();
    }

    public void del_lay(Integer lay_nom) {
        Object stringArray[] = {"Так", "Ні"};
        int response = JOptionPane.showOptionDialog(null, "Ви впевнені що хочете видалити шар?", "Питання",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, stringArray[0]);
        if (response == JOptionPane.YES_OPTION) {
            arch_tmp.getLayers().remove(lay_nom.intValue());
        }
        draw_arch_struct();
    }

    public void edit_mod(Integer lay_nom, Integer mod_nom) {
        String name = (String) JOptionPane.showInputDialog(null, "Введіть назву", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).getName());
        if (name != null && !name.equals("")) {
            arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).setName(name);
            arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).setDescription((String) JOptionPane.showInputDialog(null, "Введіть опис", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).getDescription()));
        }
        draw_arch_struct();
    }

    public void edit_lay(Integer lay_nom) {
        String name = (String) JOptionPane.showInputDialog(null, "Введіть назву", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, arch_tmp.getLayers().get(lay_nom).getName());
        if (name != null && !name.equals("")) {
            arch_tmp.getLayers().get(lay_nom).setName(name);
            arch_tmp.getLayers().get(lay_nom).setDescription((String) JOptionPane.showInputDialog(null, "Введіть опис", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, arch_tmp.getLayers().get(lay_nom).getDescription()));
        }
        draw_arch_struct();
    }


    public void arch_uml_gen(ActionEvent actionEvent) {
        //arch_image = draw_uml.draw_class(functions.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));

        arch_image = ImageConverter.AWTImgtoFXImg(ImageConverter.FXimgToAWTimg(draw_uml.draw_class(arch_work.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()))));
        /**/
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);
    }

    public void arch_uml_text_draw(ActionEvent actionEvent) {

    }

    public void save_this_arch_to_DB(ActionEvent actionEvent) {
        //TODO решить как лутьше
        //arch_image = draw_uml.draw_class(functions.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        arch_tmp.setPreview(arch_image);
        arch_tmp.setUsecase(TA_arch_relations.getText());
        arch_tmp.setDescription(TA_arch_description.getText());
        try {
        arch_tmp.setId(Integer.parseInt(TF_arch_id_DB.getText()));}
        catch (NumberFormatException e){
            e.printStackTrace();
            arch_tmp.setId(null);
        }
        result_info result=arch_work.arch_save_to_DB(arch_tmp, derby_DB);
        if(result.getStatus()==true){

            JOptionPane.showMessageDialog(null, "Архітектура успішно збережена.","Інформація",JOptionPane.INFORMATION_MESSAGE);
        } else {
            //TODO ВТорое окно
            /*Label message = new Label("Cay's message");
            Node  source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            //stage.setScene(new Scene(message));*/
            JOptionPane.showMessageDialog(null, "Архітектура не збереження зверныться до Адмыныстратора чи програміста.\n"+result.getComment(), "Попередження", JOptionPane.WARNING_MESSAGE);
        }
    }
}