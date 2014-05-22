package editor.controllers;

import editor.classes.*;
import editor.services.draw_uml;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 21.05.2014.
 */

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
    Architecture_up arch_struct=new Architecture_up();

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

    public void arch_struct_load(final Number number) {
        layer_names.clear();
        module_names.clear();
        selected_paterns.clear();
        arch_struct=new Architecture_up();
        Label tmp_lable=new Label();

        ResultSet rs_arch, rs_lay, rs_mod, rs_pat = null;
        int pos_x = 0, pos_y = 0, s_lay = 0, s_mod = 0, s_pat = 0;
        P_arch_ctruct.getChildren().clear();
        try {
            rs_arch=derby_DB.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + functions.get_ID((String) CB_archs.getItems().get(number.intValue())));
            rs_arch.next();
            arch_struct=new Architecture_up(rs_arch.getInt("ID"),rs_arch.getString("NAME"),rs_arch.getString("DESCRIPTION"));
            pos_x += Integer.parseInt(TF_X1.getText());//Начальный сдвиг
            //Выбрать все Слои даной архитектуры
            rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + functions.get_ID((String) CB_archs.getItems().get(number.intValue())));
            while (rs_lay.next()) {
                arch_struct.arch_layers.add(new Layer_up(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                tmp_lable= new Label(rs_lay.getString("NAME"));
                pos_y += Integer.parseInt(TF_Y1.getText());
                tmp_lable.setLayoutX(pos_x);
                tmp_lable.setLayoutY(pos_y);
                P_arch_ctruct.getChildren().add(tmp_lable);
                rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                pos_x += Integer.parseInt(TF_X2.getText());//Сдвиг+
                while (rs_mod.next()) {
                    arch_struct.arch_layers.get(s_lay).modules.add(new Module_up(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    rs_pat = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    pos_y += Integer.parseInt(TF_Y2.getText());
                    selected_paterns.add(s_pat, new ChoiceBox());
                    ObservableList<String> items = FXCollections.observableArrayList();
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        arch_struct.arch_layers.get(s_lay).modules.get(s_mod).avilable_paterns.add(new Pattern_up(rs_pat.getInt("ID"),rs_pat.getInt("MOD_ID"),rs_pat.getString("NAME"),rs_pat.getString("DESCRIPTION"),rs_pat.getString("VALUE")));
                        items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                    }
                    selected_paterns.get(s_pat).setItems(items);
                    selected_paterns.get(s_pat).setPrefWidth(Integer.parseInt(TF_X2.getText()));
                    selected_paterns.get(s_pat).setLayoutX(pos_x - Integer.parseInt(TF_X2.getText()));
                    selected_paterns.get(s_pat).setLayoutY(pos_y);
                    final int ss_lay=s_lay,ss_mod=s_mod;
                    selected_paterns.get(s_pat).getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                            //final Integer num=number;
                            arch_struct.arch_layers.get(ss_lay).modules.get(ss_mod).selected_patern=arch_struct.arch_layers.get(ss_lay).modules.get(ss_mod).avilable_paterns.get(new_value.intValue());
                        }
                    });
                    P_arch_ctruct.getChildren().add(selected_paterns.get(s_pat));
                    s_pat++;
                    ///////////////
                    tmp_lable= new Label(rs_mod.getString("NAME"));
                    tmp_lable.setLayoutX(pos_x);
                    tmp_lable.setLayoutY(pos_y);
                    P_arch_ctruct.getChildren().add(tmp_lable);
                    pos_y += Integer.parseInt(TF_Y2.getText());
                    s_mod++;
                }
                pos_x -= Integer.parseInt(TF_X2.getText());//Сдвиг-
                s_lay++;
            }
            P_arch_ctruct.setPrefHeight(pos_y);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Arch load end");
    }

    public void to_text_arch() {
        //TODO оно неправлено работает(нужно создать спец клас(Ы) под свои нужды и с нужным функцыоналом)
        TA_class_text.setText(functions.arch_uml_text_gen(arch_struct));
    }

    public void drawing_arch() {
        javafx.scene.image.Image res_img = draw_uml.draw_class(TA_class_text.getText());
        IV_res_img.setFitHeight(res_img.getRequestedHeight());
        IV_res_img.setFitWidth(res_img.getRequestedWidth());
        IV_res_img.setImage(res_img);
    }

}
