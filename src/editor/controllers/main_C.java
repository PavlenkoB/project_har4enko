package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.CustomXWPFDocument;
import editor.classes.DerbyDBManager;
import editor.classes.id_Lable;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * @author godex_000
 */
public class main_C extends JPanel implements Initializable {
    @FXML
    public Label selected_DB;
    public Button B_connect;
    public Button B_create;
    public Button B_disconnect;
    public Pane B_G_editors;
    /*Кнопки*/

    public TextArea TA_arch_description;
    public TextField TF_arch_id_DB;
    public TextField TF_arch_name_DB;
    public ListView LV_archs_DB; //список архітектур в базі
    public TextArea TA_arch_relations;
    public Pane P_arch_struct;
    public ImageView IV_arch_imageview;
    public Pane P_IV;
    public ScrollPane SP_P_IV;
    public MenuItem MM_1_1_connect;
    public MenuItem MM_1_2_create_DB;
    public MenuItem MM_1_3_disconnect;
    public Parent root;
    Stage thisstage;
    DerbyDBManager derby_DB;
    Architecture arch_tmp, arch_old = new Architecture();
    @FXML
    private Image arch_image;

    void initData(Module module, DerbyDBManager derby_con) {
        derby_DB = derby_con;
        if (derby_DB != null) {
            MM_1_1_connect.setDisable(true);
            MM_1_3_disconnect.setDisable(false);
        }
        thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Object[] options = {"Так",
                        "Ні"};
                int n = JOptionPane.showOptionDialog(null,
                        "Ви впевнені що бажаете вийти незбережені зміни буде втрачено?",
                        "Увага",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
                if (n == 0) {//да
                } else {//нет
                    we.consume();
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //при двойном клике грузить архитекутуру
        LV_archs_DB.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1 && derby_DB != null) {
                    load_this_arch_DB(null);
                }
            }
        });


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
            // существет ли база(создана ли)
            DirectoryChooser db_dir_FC = new DirectoryChooser();
            db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
            db_dir_FC.setTitle("Вкажіть шлях до папки з БД");
            File db_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
            if (db_dir != null) {
                derby_DB = new DerbyDBManager(db_dir.getAbsolutePath());

                //derby_DB.setDbName(db_dir.getName());
                selected_DB.setText(db_dir.getName());
                //TODO доступность кнопок
                list_load_DB();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                derby_DB.getCon().close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (derby_DB != null) {
            MM_1_1_connect.setDisable(true);
            MM_1_3_disconnect.setDisable(false);
        }/**/
    }

    public void disconnect_DB(ActionEvent actionEvent) {//отключиться от БД
        try {
            if (derby_DB.getCon() != null) {
                if (!derby_DB.getCon().isClosed()) {
                    derby_DB.disconectDB();
                }


                LV_archs_DB.setItems(null);
                P_arch_struct.getChildren().clear();

                selected_DB.setText("<не обрана>");
                //TODO доступность кнопок
                if (derby_DB.getCon().isClosed()) {
                    MM_1_1_connect.setDisable(false);
                    MM_1_3_disconnect.setDisable(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creat_DB(ActionEvent actionEvent) { //Создать БД
        disconnect_DB(null);
        // существет ли база(создана ли)
        DirectoryChooser db_dir_FC = new DirectoryChooser();
        db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
        db_dir_FC.setTitle("Вкажіть шлях до папки для нової БД");
        File db_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
        if (db_dir != null) {
            derby_DB = new DerbyDBManager(db_dir);

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

                System.out.print("Создал таблиці)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //TODO создание
        }
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

    public void creat_arch(ActionEvent actionEvent) {
        JDialog Jname = new JDialog();
        Jname.setAlwaysOnTop(true);
        String name = (String) JOptionPane.showInputDialog(null, "Введіть назву", "Ввід", JOptionPane.QUESTION_MESSAGE, null, null, "");

        //dialog.get
        if (name != null && !name.equals("")) {
            try {
                derby_DB.executeUpdate("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES ('" + name + "','" + " " + "','" + " " + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list_load_DB();
        }/**/
    }


    public void clear_db(ActionEvent actionEvent) {
        functions.clread_DB(derby_DB);
    }


    public void load_this_arch_DB(ActionEvent actionEvent) {//ЗАгрузить архитектуру с базы
        //Читае Идентиф. Параметра
        arch_tmp = arch_work.arch_load_from_DB(((id_Lable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getDbid(), derby_DB);
        try {
            arch_old = arch_tmp.clone();//сохраним оригинальный вариант архитектуры
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        TF_arch_name_DB.setText(arch_tmp.getName());
        TA_arch_relations.setText(arch_tmp.getUsecase());
        TA_arch_description.setText(arch_tmp.getDescription());
        draw_arch_struct();
        arch_image = arch_tmp.getPreview();
        //TODO перепроверить вывод что бы было удобно
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        //SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);
    }


    public void delete_arch_DB(ActionEvent actionEvent) {//удалить з базы по ID
        Object[] options = {"Так",
                "Ні"};
        int n = JOptionPane.showOptionDialog(null,
                "Ви впевнені що бажаете видалити?",
                "Увага",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            String query = "DELETE FROM ARCHITECTURE WHERE ID=" + ((id_Lable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getDbid();
            try {
                derby_DB.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list_load_DB();
        }
    }

    public void list_load_DB() {//Загрузка з базы
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE ORDER BY NAME ASC");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            LV_archs_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            TF_arch_name_DB.setText(((id_Lable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getText());
        }
        //load_this_arch_DB(null);
//        arch_image = arch_tmp.getPreview();
        //TODO перепроверить вывод что бы было удобно
/*        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        //SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);*/
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
            tmp_btn.getStyleClass().add("lay_edit");

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
            tmp_btn.getStyleClass().add("lay_del");
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
                tmp_btn = new Button("Паттерни(" + arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getAvilable_patterns().size() + ")...");
                //tmp_btn.setPrefWidth(s_x2);
                //tmp_btn.setPrefHeight(s_y2);
                tmp_btn.setLayoutX(pos_x);
                tmp_btn.setLayoutY(pos_y);
                tmp_btn.getStyleClass().add("pat_edit");
                final int finalS_mod4 = s_mod;
                final int finalS_lay5 = s_lay;
                tmp_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        edit_mod_patterns(finalS_lay5, finalS_mod4);
                    }
                });
                P_arch_struct.getChildren().add(tmp_btn);
                /*Кнопка редагування*/
                tmp_btn = new Button("Редагувати");
                tmp_btn.getStyleClass().add("mod_edit");
                //tmp_btn.setPrefWidth(s_x2);
                //tmp_btn.setPrefHeight(s_y2);
                pos_x += s_x2 + 20;
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
                tmp_btn.getStyleClass().add("mod_del");
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
            tmp_btn.getStyleClass().add("mod_add");
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
        tmp_btn.getStyleClass().add("lay_add");
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

    public void edit_mod_patterns(int layer, int module) {//Редагувати патрни шару
        try {
            arch_old = arch_tmp.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        arch_work.arch_save_to_DB(arch_old, derby_DB);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/paterns_editor.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        patern_e_C controller = loader.<patern_e_C>getController();
        controller.initData(arch_old.getLayers().get(layer).getModules().get(module), derby_DB);
        stage.setTitle("Редагування паттернів \"" + arch_old.getLayers().get(layer).getModules().get(module).getName() + "\" архітектури \"" + arch_old.getName() + "\"");
        stage.show();
        Stage stage_c = (Stage) TA_arch_description.getScene().getWindow();
        // do what you have to do
        stage_c.close();

        //return stage;

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

        arch_image = draw_uml.draw_class(arch_work.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        /**/
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        //SP_P_IV.setPrefWidth(arch_image.getWidth());

        IV_arch_imageview.setImage(arch_image);
        arch_view_prev();
    }

    public void arch_view_prev() {
        //arch_image = draw_uml.draw_class(arch_work.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/image_preview.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        image_preview_C controller = loader.<image_preview_C>getController();
        controller.initData(arch_image,arch_old.getName());
        //stage.setTitle("" + arch_old.getName());
        stage.show();
    }

    public void arch_uml_text_draw(ActionEvent actionEvent) {
    }

    public void save_this_arch_to_DB(ActionEvent actionEvent) {
        //TODO решить как лутьше
        arch_image = draw_uml.draw_class(arch_work.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        arch_tmp.setName(TF_arch_name_DB.getText());
        arch_tmp.setPreview(arch_image);
        arch_tmp.setUsecase(TA_arch_relations.getText());
        arch_tmp.setDescription(TA_arch_description.getText());
        result_info result = arch_work.arch_save_to_DB(arch_tmp, derby_DB);
        if (result.getStatus() == true) {
            JOptionPane.showMessageDialog(null, "Архітектура успішно збережена.", "Інформація", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //TODO ВТорое окно
            //Label message = new Label("Cay's message");
            //functions.get_stage_by_element(TA_arch_description).setScene(new Scene(message));
            JOptionPane.showMessageDialog(null, "Архітектура не збереження зверныться до Адмыныстратора чи програміста.\n" + result.getComment(), "Попередження", JOptionPane.WARNING_MESSAGE);
        }
        list_load_DB();
    }

    public void open_patrern_manager(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/pattern_manager.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        patterns_manager_C controller = loader.<patterns_manager_C>getController();
        controller.initData(derby_DB);
        stage.setTitle("Менеджер патернів ");
        stage.show();
        Stage stage_c = (Stage) TA_arch_description.getScene().getWindow();
        // do what you have to do
        stage_c.close();
    }

    public void import_all_to_docx(ActionEvent actionEvent) {

        root.setDisable(true);

        FileChooser docx_FC = new FileChooser();
        docx_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
        docx_FC.setTitle("Вкажіть куди імпортувати...");
        docx_FC.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Word 2007", "*.docx")
        );
        //File db_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
            CustomXWPFDocument document;
            FileOutputStream fos;
            String id;
            BufferedImage bi;
            XWPFDocument docx;
            XWPFParagraph tmpParagraph;
            XWPFRun tmpRun;
            Architecture architecture;
            File docx_f =                  docx_FC.showSaveDialog(thisstage);//файл док
            File imgFile = new File("tmp.png");//изображение
            String imgfile = "tmp.png";
            File outputfile = new File(imgfile);
        try {
            docx = new XWPFDocument();

            docx.write(new FileOutputStream(docx_f));
            for (int arch_nom = 0; arch_nom < LV_archs_DB.getItems().size(); arch_nom++) {

                docx = new XWPFDocument(new FileInputStream(docx_f));
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                architecture = arch_work.arch_load_from_DB(((id_Lable) LV_archs_DB.getItems().get(arch_nom)).getDbid(), derby_DB);
                tmpRun.setText("(Архітектура)" + architecture.getName());
                tmpRun.addBreak();
                docx.write(new FileOutputStream(docx_f));

                bi = ImageConverter.FXImgtoBufferedImage(architecture.getPreview());
                new FileOutputStream(outputfile).close();
                ImageIO.write(bi, "png", outputfile);

                document = new CustomXWPFDocument(new FileInputStream(docx_f));
                fos = new FileOutputStream(docx_f);
                id = document.addPictureData(new FileInputStream(outputfile), Document.PICTURE_TYPE_PNG);
                document.createPicture(id, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), ((Double) architecture.getPreview().getWidth()).intValue(), ((Double) architecture.getPreview().getHeight()).intValue());
                document.write(fos);
                fos.flush();
                fos.close();
                for (int layer = 0; layer < architecture.getLayers().size(); layer++) {
                    docx = new XWPFDocument(new FileInputStream(docx_f));
                    tmpParagraph = docx.createParagraph();
                    tmpRun = tmpParagraph.createRun();
                    tmpRun.setText("--(Шар)" + architecture.getLayers().get(layer).getName());
                    docx.write(new FileOutputStream(docx_f));
                    for (int module = 0; module < architecture.getLayers().get(layer).getModules().size(); module++) {
                        new FileInputStream(outputfile).close();
                        tmpRun.addBreak();
                        tmpRun.setText("------(Модуль)" + architecture.getLayers().get(layer).getModules().get(module).getName());
                        docx.write(new FileOutputStream(docx_f));
                        for (int avilable_pattern = 0; avilable_pattern < architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().size(); avilable_pattern++) {
                            docx = new XWPFDocument(new FileInputStream(docx_f));
                            tmpParagraph = docx.createParagraph();
                            tmpRun = tmpParagraph.createRun();
                            //tmpRun.setText("---------(Патерн)" + architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getName());
                            docx.write(new FileOutputStream(docx_f));
                            if (architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getPreview() == null) {//если превю не существует создать
                                architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).setPreview(
                                        functions.draw_class_image(architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getUml_text()));//создать превю
                                Pattern.pattern_save_to_DB(architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern), derby_DB);//сохарнить в базу патерн с превюшкой
                                bi = ImageConverter.FXImgtoBufferedImage(architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getPreview());

                            } else {
                                bi = ImageConverter.FXImgtoBufferedImage(architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getPreview());
                            }
                            try{
                                new FileOutputStream(outputfile).close();
                                ImageIO.write(bi, "png", outputfile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                            document = new CustomXWPFDocument(new FileInputStream(docx_f));
                            fos = new FileOutputStream(docx_f);
                            id = document.addPictureData(new FileInputStream(outputfile), Document.PICTURE_TYPE_PNG);
                            document.createPicture("---------(Патерн)" +architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getName(),id, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getPreview().getWidth()).intValue(), ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilable_patterns().get(avilable_pattern).getPreview().getHeight()).intValue());
                            document.write(fos);
                            fos.flush();
                            fos.close();

                        }
                    }


                }
                new FileInputStream(outputfile).close();
                docx.write(new FileOutputStream(docx_f));
            }/**/
        } catch (Exception e) {
            try {
                new FileOutputStream(docx_f).close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        outputfile.delete();
        System.out.printf("Import end");
        root.setDisable(false);
    }
}