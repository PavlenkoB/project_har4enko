package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import editor.classes.Modals;
import editor.classes.id_Lable;
import editor.interfaces.Configuration;
import editor.services.draw_uml;
import editor.services.pattern_work;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
public class paterns_editor_C implements Initializable, Configuration {
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
    public TextArea TA_patern_description;
    @FXML
    public ChoiceBox CB_paterns_master;
    @FXML
    public Pattern edited_pattern;
    @FXML
    public Parent root;
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
        list_load_DB(null);
        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        //thisstage.setTitle("Управління репозиторіем патернів: редактор архітектур");
        //thisstage.setMinWidth(900);//Минимальная шырина
        //thisstage.setMinHeight(700);//Минимальная высота окна

        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"), RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"))) {
                } else {
                    we.consume();
                }
            }
        });
    }

    public void initialize(URL url, ResourceBundle rb) {

//при двойном клике грузить патерн
        LV_paterns_DB.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1 && derby_DB != null) {
                    load_this_patern_DB(null);
                }
            }
        });
        //list_load_DB();/**/

    }

    /*Действия*/
    @FXML//Отрисовка класса
    public void Action_draw_class() {
        class_image = draw_uml.draw_class(class_text.getText());
        edited_pattern.setPreview(class_image);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/image_preview.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        image_preview_C controller = loader.<image_preview_C>getController();
        controller.initData(edited_pattern.getPreview(), TF_patern_name_DB.getText());
        //stage.setTitle("" + TF_patern_name_DB.getText());
        stage.show();

//        class_imageview.setFitHeight(class_image.getRequestedHeight());
        //       class_imageview.setFitWidth(class_image.getRequestedWidth());
        //       class_imageview.setImage(class_image);
    }


    // загрузка превю
    public void load_this_patern_DB(ActionEvent actionEvent) {//ЗАгрузить патерн с базы
        //Читае Идентиф. Параметра
        edited_pattern = pattern_work.pattern_load_from_DB(((id_Lable) LV_paterns_DB.getSelectionModel().getSelectedItems().get(0)).getDbid(), derby_DB);
        TA_patern_description.setText(edited_pattern.getDescription());
        class_text.setText(edited_pattern.getUmlText());
        TF_patern_name_DB.setText(edited_pattern.getName());
        class_image = edited_pattern.getPreview();
    }

    // сохранение превю
    public void save_this_patern_DB(ActionEvent actionEvent) {//добавить патерн в базу
        edited_pattern.setModId(edited_module.getId());
        edited_pattern.setName(TF_patern_name_DB.getText());
        edited_pattern.setUmlText(class_text.getText());
        edited_pattern.setDescription(TA_patern_description.getText());
        edited_pattern.setPreview(draw_uml.draw_class(class_text.getText()));
        edited_pattern.setType("");
        edited_pattern.setArch_id(Layer.load_layer_from_DB(edited_module.getLay_id(), derby_DB).getArch_id());
        if (pattern_work.pattern_save_to_DB(edited_pattern, derby_DB).getStatus() == true) {
            JOptionPane.showMessageDialog(null, RB.getString("патерн.збережено"), RB.getString("загальні.інформація"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Помилка збереження зверніться до Адміністратора чи програміста.", RB.getString("загальні.попередження"), JOptionPane.WARNING_MESSAGE);
        }
        list_load_DB(null);
        LV_paterns_DB.setDisable(false);
    }

    public void delete_patern_DB(ActionEvent actionEvent) {//удалить з базы по ID
        Object[] options = {RB.getString("загальні.так"),
                RB.getString("загальні.ні")};
        int n = JOptionPane.showOptionDialog(null,
                RB.getString("загальні.ви_впевнені_що_бажаете_видалити"),
                RB.getString("загальні.увага"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            String query = "DELETE FROM PATERNS WHERE ID=" + ((id_Lable) LV_paterns_DB.getSelectionModel().getSelectedItems().get(0)).getDbid();
            try {
                derby_DB.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list_load_DB(null);
        }
    }

    private void list_load_DB(ActionEvent actionEvent) {//Загрузка з базы
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + edited_module.getId() + " ORDER BY NAME ASC");
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
            ObservableList<id_Lable> items = FXCollections.observableArrayList();

            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            LV_paterns_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            TF_patern_name_DB.setText(((id_Lable) LV_paterns_DB.getSelectionModel().getSelectedItems().get(0)).getText());
        }
        //load_this_patern_DB(null);
    }


    public void show_help(ActionEvent actionEvent) {// Отобразить помощь
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/help.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void show_about(ActionEvent actionEvent) {
        try {
            Parent Parent = FXMLLoader.load(getClass().getResource("/editor/views/about.fxml"));
            Stage Stage = new Stage();
            Stage.setTitle(RB.getString("загальні.допомога"));
            Stage.setScene(new Scene(Parent));
            Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close_mw(ActionEvent actionEvent) {
        Object[] options = {RB.getString("загальні.так"),
                RB.getString("загальні.ні")};
        int n = JOptionPane.showOptionDialog(null,
                RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"),
                RB.getString("загальні.увага"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == 0) {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/main_window_V2.fxml")
            );

            Stage stage = new Stage(StageStyle.DECORATED);
            try {
                stage.setScene(new Scene((Pane) loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            main_C controller = loader.<main_C>getController();
            controller.initData(edited_module, derby_DB);

            stage.show();
            Stage stage_this = (Stage) MB_main_menu.getScene().getWindow();
            // do what you have to do
            stage_this.close();
        } else {
            actionEvent.consume();
        }

    }

    public void edit_patern(ActionEvent actionEvent) {//Редактировать патерн
        LV_paterns_DB.setDisable(true);
        select_to_save_DB();
        load_this_patern_DB(null);

    }

    public void create_pattern(ActionEvent actionEvent) {
        JDialog Jname = new JDialog();
        Jname.setAlwaysOnTop(true);
        String name = (String) JOptionPane.showInputDialog(null, RB.getString("загальні.введіть_назву"), RB.getString("загальні.введення"), JOptionPane.QUESTION_MESSAGE, null, null, "");

        //dialog.get
        if (name != null && !name.equals("")) {
            try {
                ResultSet rs = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ID =" + edited_module.getLay_id() + " ORDER BY NAME ASC");//отримати шар модулю
                rs.next();
                rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID =" + rs.getInt("ARCH_ID") + " ORDER BY NAME ASC");//отримати арзітектуру модуля
                rs.next();
                derby_DB.executeUpdate("INSERT INTO PATERNS (MOD_ID,ARCH_ID,NAME,VALUE,DESCRIPTION) VALUES (" + edited_module.getId() + "," + rs.getInt("ID") + ",'" + name + "','" + " " + "','" + " " + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list_load_DB(null);
        }/**/
    }

    /**
     * Показати скомпільоване превю паттерну
     */
    public void patern_view_prev() {
        class_image = edited_pattern.getPreview();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/image_preview.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        image_preview_C controller = loader.<image_preview_C>getController();
        controller.initData(class_image, TF_patern_name_DB.getText());
        //stage.setTitle("" + TF_patern_name_DB.getText());
        stage.show();
    }


}