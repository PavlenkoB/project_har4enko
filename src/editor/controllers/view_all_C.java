package editor.controllers;

import editor.classes.DerbyDBManager;
import editor.services.draw_uml;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 21.05.2014.
 */
class Arch{

        }
public class view_all_C implements Initializable {
    public ChoiceBox CB_archs;
    public ScrollPane SP_arch_ctruct;
    public Pane P_arch_ctruct;
    public TextField TF_Y1;
    public TextField TF_X1;
    public TextField TF_X2;
    public TextField TF_Y2;
    public TextArea TA_class_text;
    public ImageView IV_res_img;

    ArrayList<javafx.scene.control.Label> layer_names = new ArrayList<>();
    ArrayList<javafx.scene.control.Label> module_names = new ArrayList<>();
    ArrayList<ChoiceBox> selected_paterns = new ArrayList<>();

    DerbyDBManager derby_DB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO Del
        derby_DB = new DerbyDBManager("DB/paterns_DB");
        //list_load_DB();
        arch_load();/**/

    }

    public void arch_load() {//загрузить архитектуру
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
                //System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            CB_archs.setItems(items);
            CB_archs.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                    arch_struct_load(new_value);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void arch_struct_load(Number number) {
        layer_names.clear();
        module_names.clear();
        selected_paterns.clear();
        ResultSet rs_lay, rs_mod, rs_pat = null;
        int pos_x = 0, pos_y = 0, s_lay = 0, s_mod = 0, s_pat = 0;
        P_arch_ctruct.getChildren().clear();
        try {
            pos_x += Integer.parseInt(TF_X1.getText());//Начальный сдвиг
            //Выбрать все Слои даной архитектуры
            rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + functions.get_ID((String) CB_archs.getItems().get(number.intValue())));
            while (rs_lay.next()) {
                System.out.println(rs_lay.getInt("ID") + "|" + rs_lay.getString("NAME"));
                layer_names.add(s_lay, new Label(rs_lay.getString("NAME")));
                pos_y += Integer.parseInt(TF_Y1.getText());
                layer_names.get(s_lay).setLayoutX(pos_x);
                layer_names.get(s_lay).setLayoutY(pos_y);
                P_arch_ctruct.getChildren().add(layer_names.get(s_lay++));
                rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                pos_x += Integer.parseInt(TF_X2.getText());//Сдвиг+
                while (rs_mod.next()) {
                    rs_pat = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    pos_y += Integer.parseInt(TF_Y2.getText());
                    selected_paterns.add(s_pat, new ChoiceBox());
                    ObservableList<String> items = FXCollections.observableArrayList();
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        System.out.println(rs_pat.getInt("ID") + "|" + rs_pat.getString("NAME"));
                        items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                    }
                    selected_paterns.get(s_pat).setItems(items);
                    selected_paterns.get(s_pat).setPrefWidth(Integer.parseInt(TF_X2.getText()));
                    selected_paterns.get(s_pat).setLayoutX(pos_x - Integer.parseInt(TF_X2.getText()));
                    selected_paterns.get(s_pat).setLayoutY(pos_y);
                    P_arch_ctruct.getChildren().add(selected_paterns.get(s_pat++));
                    ///////////////
                    System.out.println(rs_mod.getInt("ID") + "|" + rs_mod.getString("NAME"));
                    module_names.add(s_mod, new Label(rs_mod.getString("NAME")));
                    module_names.get(s_mod).setLayoutX(pos_x);
                    module_names.get(s_mod).setLayoutY(pos_y);
                    P_arch_ctruct.getChildren().add(module_names.get(s_mod++));
                    pos_y += Integer.parseInt(TF_Y2.getText());
                }
                pos_x -= Integer.parseInt(TF_X2.getText());//Сдвиг-
            }
            P_arch_ctruct.setPrefHeight(pos_y);
        } catch (SQLException e) {
            //e.printStackTrace();
        }

    }

    public void to_text_arch() {
        //TODO оно неправлено работает(нужно создать спец клас(Ы) под свои нужды и с нужным функцыоналом)
        String class_text = new String();
        class_text += "package \"" + functions.get_NAME(CB_archs.getSelectionModel().getSelectedItem().toString()) + "\"{\n";
        for (int s_lay = 0; s_lay < layer_names.size(); s_lay++) {
            class_text += "\tpackage \"" + layer_names.get(s_lay).getText() + "\"{\n";
            for (int s_mod = 0; s_mod < module_names.size(); s_mod++) {
                class_text += "\tpackage \"" + module_names.get(s_mod).getText() + "\"{\n";
                if (selected_paterns.get(s_mod).getSelectionModel().getSelectedItem() != null) {
                    ResultSet rs = null;
                    try {
                        //derby_DB
                        rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE ID=" + functions.get_ID(selected_paterns.get(s_mod).getSelectionModel().getSelectedItem().toString()));
                        rs.next();
                        class_text += rs.getString("VALUE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    class_text += "\t\tNull" + s_lay + s_mod + " ..> NU_net" + s_lay + s_mod;
                }
                class_text += "\n}\n";
            }
            class_text += "}\n";
        }
        class_text += "}";
        TA_class_text.setText(class_text);
    }

    public void drawing_arch() {
        javafx.scene.image.Image res_img = draw_uml.draw_class(TA_class_text.getText());
        IV_res_img.setFitHeight(res_img.getRequestedHeight());
        IV_res_img.setFitWidth(res_img.getRequestedWidth());
        IV_res_img.setImage(res_img);
    }

}
