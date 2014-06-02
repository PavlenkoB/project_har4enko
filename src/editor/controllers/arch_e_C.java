package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import editor.classes.DerbyDBManager;
import editor.services.draw_uml;
import editor.services.functions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */

public class arch_e_C implements Initializable {

    public TextArea TA_arch_description;
    public TextField TF_arch_id_DB;
    public TextField TF_arch_name_DB;
    public ListView LV_archs_DB;
    public TextArea TA_arch_relations;
    public Pane P_arch_struct;
    public ImageView IV_arch_imageview;
    public Pane P_IV;
    public ScrollPane SP_P_IV;
    @FXML
    private Image arch_image;

    DerbyDBManager derby_DB;

    Architecture arch_tmp, arch_old = new Architecture();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FontUIResource f = new FontUIResource(new Font("Verdana", 0, 22));
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
//TODO Del
        derby_DB = new DerbyDBManager("DB/paterns_DB");
        //list_load_DB();/**/
    }


    public void load_this_arch_DB(ActionEvent actionEvent) {//ЗАгрузить архитектуру с базы
        //Читае Идентиф. Параметра
        arch_tmp = functions.arch_load_from_DB(functions.get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString()), derby_DB);
        arch_old = functions.arch_load_from_DB(functions.get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString()), derby_DB);
        TA_arch_relations.setText(arch_tmp.getUsecase());
        TA_arch_description.setText(arch_tmp.getDescription());
        draw_arch_struct();
    }

    public void edit_arch(ActionEvent actionEvent) {//Редактировать патерн
        TF_arch_id_DB.setEditable(false);
        LV_archs_DB.setDisable(true);
        select_to_save_DB();
        load_this_arch_DB(null);

    }

    public void save_this_arch_DB(ActionEvent actionEvent) {//добавить патерн в базу
        if (TF_arch_id_DB.getText().length() == 0) {
            String query = "INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES ('" + TF_arch_name_DB.getText() + "','" + TA_arch_relations.getText() + "','" + TA_arch_description.getText() + "')";
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String query = "UPDATE ARCHITECTURE " +
                    "SET NAME='" + TF_arch_name_DB.getText() + "',USECASE='" + TA_arch_relations.getText() + "',DESCRIPTION='" + TA_arch_description.getText() + "' WHERE ID=" + functions.get_ID(LV_archs_DB.getSelectionModel().getSelectedItem().toString());
            ResultSet q_result;
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        list_load_DB();
        TF_arch_id_DB.setEditable(true);
        LV_archs_DB.setDisable(false);
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
                System.out.print("Создаю таблицу)");
                //если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                try {
                    String query = "CREATE TABLE ARCHITECTURE (\n" +
                            "  ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY\n" +
                            "        (START WITH 1, INCREMENT BY 1),\n" +
                            "  NAME VARCHAR(255) NOT NULL,\n" +
                            "    DESCRIPTION CLOB(1073741823),\n" +
                            "    USECASE CLOB(1073741823),\n" +
                            "    PREVIEW LONG VARCHAR FOR BIT DATA\n" +
                            "  )";
                    derby_DB.executeUpdate(query);
                    rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE");
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
    }

    public void draw_arch_struct() {//відобразити структуру архітектури
        P_arch_struct.getChildren().clear();
        Integer pos_x = 0, pos_y = 0, s_x1 = 30, s_y1 = 30, s_x2 = 40, s_y2 = 30;
        Button tmp_btn;
        Label tmp_label;
        //pos_x += s_x1;
        //pos_y += s_y1;
        for (int s_lay = 0; s_lay < arch_tmp.getLayers().size(); s_lay++) {
            //Редагування
            tmp_btn = new Button("\u270E");
            tmp_btn.setPrefWidth(s_x2);
            tmp_btn.setPrefHeight(s_y2);
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
            tmp_btn = new Button("\u2718");
            tmp_btn.setPrefWidth(s_x2);
            tmp_btn.setPrefHeight(s_y2);
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
            for (int s_mod = 0; s_mod < arch_tmp.getLayers().get(s_lay).getModules().size(); s_mod++) {//вивід модулів
                /*Кнопка редагування*/
                tmp_btn = new Button("\u270E");
                tmp_btn.setPrefWidth(s_x2);
                tmp_btn.setPrefHeight(s_y2);
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

                tmp_btn = new Button("\u2718");
                tmp_btn.setPrefWidth(s_x2);
                tmp_btn.setPrefHeight(s_y2);
                tmp_btn.setLayoutX(pos_x + s_x2);
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
                tmp_label.setLayoutX(pos_x + s_x2 + s_x2);
                tmp_label.setLayoutY(pos_y);
                P_arch_struct.getChildren().add(tmp_label);
                pos_y += s_y2 - s_y1;//різниця між висотой між слоями і розміром кнопки
                pos_y += s_y1 + 5;//Сдвиг вниз
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
        arch_image = draw_uml.draw_class(functions.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);
    }

    public void arch_uml_text_draw(ActionEvent actionEvent) {

    }

    public void save_this_arch_to_DB(ActionEvent actionEvent) {
        arch_tmp.setUsecase(TA_arch_relations.getText());
        arch_tmp.setDescription(TA_arch_description.getText());
        arch_tmp.setId(Integer.parseInt(TF_arch_id_DB.getText()));
        try {
            functions.arch_save_to_DB(arch_tmp, derby_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}