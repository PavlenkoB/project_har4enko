package ua.edu.nau.godex.projectharchenko.repository_editor.controllers;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the repository_editor.
 */
/*
import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import repository_editor.classes.*;
import repository_editor.interfaces.Configuration;
import repository_editor.services.*;*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import ua.edu.nau.godex.projectharchenko.classes.Architecture;
import ua.edu.nau.godex.projectharchenko.classes.Layer;
import ua.edu.nau.godex.projectharchenko.classes.Module;
import ua.edu.nau.godex.projectharchenko.classes.Pattern;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.*;
import ua.edu.nau.godex.projectharchenko.repository_editor.interfaces.Configuration;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class main_C extends JPanel implements Initializable, Configuration {

    private static Logger logger = Logger.getLogger(main_C.class.getClass());

    @FXML
    public Label selected_DB;
    public Button B_connect;
    public Button B_create;
    /*Кнопки*/
    public Button B_disconnect;
    public Pane B_G_editors;
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
    public Parent root;                                     //головный контейнер выкна
    public TextArea TA_full_arch_description;           //повний опис архітектури
    Stage thisstage;
    DerbyDBManager derby_DB;    //клас роботі з базою
    Architecture arch_tmp, arch_old = new Architecture();//Архітектури
    @FXML
    private Image arch_image;
    private String secretkey = "";//Секретній ключ для шифровки дешифровки

    public void initData(Module module, DerbyDBManager derby_con) {
        derby_DB = derby_con;
        if (derby_DB != null) {
            MM_1_3_disconnect.setDisable(false);
        }


        thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/res/img/uml_icon.png"));
        thisstage.setTitle(RB.getString("управління_репозиторієм_патернів_редактор_архітектур"));
        thisstage.setMinWidth(900);//Минимальная шырина
        thisstage.setMinHeight(700);//Минимальная высота окна
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"),
                        RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"))) {//да
                } else {//нет
                    we.consume();
                }/**/
                //we.consume();
            }
        });
    }

    public void initData() {
        System.out.println("Init");
        thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/res/img/uml_icon.png"));
        thisstage.setTitle(RB.getString("управління_репозиторієм_патернів_редактор_архітектур"));
        thisstage.setMinWidth(900);//Минимальная шырина
        thisstage.setMinHeight(700);//Минимальная высота окна
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"),
                        RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"))) {//да
                } else {//нет
                    we.consume();
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize start");
        //arch.class
        //TODO log_in();
        //при двойном клике грузить архитекутуру
        LV_archs_DB.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1 && derby_DB != null) {
                    load_this_arch_DB(null);
                }
            }
        });

        //Скопіювати файл змін
        if (new File("README.md").exists()) {
            if (new File("src/README.md").exists())
                new File("/README.md").delete();
            try {
                FileUtils.copyFileUsingStream(new File("README.md"), new File("src/README.md"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//TODO Del

        try {
            System.out.println("initialize 1");
            derby_DB = new DerbyDBManager("DB/paterns_DB");
            list_load_DB();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }/**/

        if (derby_DB != null) {
            MM_1_1_connect.setDisable(true);
            MM_1_3_disconnect.setDisable(false);
        }
    }

    public void connect_DB(ActionEvent actionEvent) {
        try {
            if (derby_DB != null) {
                disconnect_DB(null);
            }
            // существет ли база(создана ли)
            DirectoryChooser db_dir_FC = new DirectoryChooser();
            db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
            db_dir_FC.setTitle(RB.getString("вкажіть_шлях_до_папки_з_бд"));
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
                selected_DB.setText("<" + RB.getString("не_обрана") + ">");
                //TODO доступность кнопок
                if (derby_DB.getCon().isClosed() || derby_DB == null) {
                    MM_1_1_connect.setDisable(false);
                    MM_1_3_disconnect.setDisable(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creat_DB(ActionEvent actionEvent) { //Создать БД
        if (derby_DB != null) {
            disconnect_DB(null);
        }
        // существет ли база(создана ли)
        DirectoryChooser db_dir_FC = new DirectoryChooser();
        db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
        db_dir_FC.setTitle(RB.getString("вкажіть_шлях_до_папки_для_новоі_бд"));
        File db_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
        if (db_dir != null) {
            derby_DB = new DerbyDBManager(db_dir);
            System.out.print("Створюю таблиці");
            try {
                File in_dir = new File(getClass().getClassLoader().getResource("sql/create_DB").getFile());
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
                System.out.print("Створив таблиці");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void close_mw(ActionEvent actionEvent) {
        thisstage.close();
    }

    public void show_help(ActionEvent actionEvent) {// Отобразить помощь
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("res/PlantUML.pdf");
                if (!myFile.exists()) {
                    myFile = new File(getClass().getResource("/res/PlantUML.pdf").getFile());
                }
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                ex.printStackTrace();
                // no application registered for PDFs
            }
        }
    }

    public void show_about(ActionEvent actionEvent) {
        try {
            Parent Parent = FXMLLoader.load(getClass().getResource("/views/repository_editor/about.fxml"));
            Stage Stage = new Stage();
            Stage.initModality(Modality.NONE);
            Stage.setTitle(RB.getString("загальні.допомога"));
            Stage.setScene(new Scene(Parent));
            Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Створити резервну копію бази до якої зараз підключений користувач
     *
     * @param actionEvent
     * @throws IOException
     */
    public void create_backup(ActionEvent actionEvent) throws Throwable {
        if (derby_DB != null) {
            if (derby_DB.getDbName() != null) {
                DirectoryChooser db_dir_FC = new DirectoryChooser();
                db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
                db_dir_FC.setTitle("Виберіть місце куди зберегти архів...");
                File zip_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
                if (zip_dir != null) {
                    File mydir = new File(derby_DB.getDbName());
                    File myfile = new File(zip_dir.getAbsoluteFile() + "\\" + mydir.getName() + "_" + new SimpleDateFormat("dd.MM.yyyy_HH_mm_ss").format(new Date()) + ".zip");
                    zip.zip_dir(mydir, myfile);
                    //TODO ввід пароля
                    security.encrypt_file(secretkey, new FileInputStream(myfile), new FileOutputStream(new File(myfile.getAbsoluteFile() + ".enc")));
                    myfile.delete();
                    System.out.println(mydir.toURI().relativize(myfile.toURI()).getPath());
                    Modals.showInfoApplicationModal(RB.getString("загальні.інформація"), mydir.toURI().relativize(myfile.toURI()).getPath());
                }
            }
        }
    }

    /**
     * РОзархівувати базу з архіву
     *
     * @throws IOException
     */
    public void unpack_backup() throws Throwable {
        System.out.println("unpack_backup start");
        FileChooser FC_zip = new FileChooser();
        FC_zip.setInitialDirectory(new File(System.getProperty("user.dir")));
        FC_zip.setTitle(RB.getString("загальні.Виберіть") + " " + RB.getString("загальні.архів") + "...");
        FC_zip.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Зашифрований" + " " + RB.getString("загальні.архів"), "*.zip.enc"),
                new FileChooser.ExtensionFilter("Zip", "*.zip")
        );
        //TODO Ввід пароля

        File zip_file = FC_zip.showOpenDialog(functions.get_stage_by_element(TA_arch_description));
        File decrypted = null;
        if (zip_file != null && zip_file.exists()) {
            if (FileUtils.getExtension(zip_file.getName().toString()).equals("enc")) {
                File original = zip_file;
                decrypted = new File(zip_file.getName() + ".zip");
                security.decrypt_file(secretkey, new FileInputStream(original), new FileOutputStream(decrypted));
                zip_file = decrypted;
            }
            DirectoryChooser db_dir_FC = new DirectoryChooser();
            db_dir_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
            db_dir_FC.setTitle("Виберіть місце куди розархівувати архів...");
            File db_dir = db_dir_FC.showDialog(functions.get_stage_by_element(TA_arch_description));
            if (db_dir != null || zip_file != null) {
                zip.zip_unpack(zip_file.getAbsolutePath().toString(), db_dir.getAbsolutePath().toString());
                decrypted.delete();
            }
        } else {
            System.out.println("File not selected");
        }
        System.out.println("unpack_backup end");
    }


    /**
     * Создать архитектуру
     *
     * @param actionEvent
     */
    public void createArch(ActionEvent actionEvent) {
        JDialog jDialog = new JDialog();
        jDialog.setAlwaysOnTop(true);
        String name = Modals.showInputDialog(RB.getString("загальні.Архітектура"), RB.getString("загальні.введіть_назву"), null);
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

    /**
     * ЗАгрузить архитектуру с базы
     * Читае Идентиф. Параметра
     * @param actionEvent
     */
    public void load_this_arch_DB(ActionEvent actionEvent) {
        System.out.println("load_this_arch_DB");
        arch_tmp = archWork.arch_load_from_DB(((idLable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getDbId(), derby_DB);
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
        IV_arch_imageview.setFitHeight(arch_image.getRequestedHeight());
        IV_arch_imageview.setFitWidth(arch_image.getRequestedWidth());
        SP_P_IV.setPrefHeight(arch_image.getHeight());
        //SP_P_IV.setPrefWidth(arch_image.getWidth());
        IV_arch_imageview.setImage(arch_image);
    }


    /**
     * удалить з базы по ID
     *
     * @param actionEvent
     */
    public void delete_arch_DB(ActionEvent actionEvent) {
        System.out.println("delete_arch_DB");
        Object[] options = {RB.getString("загальні.так"),
                RB.getString("загальні.ні")};
        int n = JOptionPane.showOptionDialog(null,
                "Ви впевнені, що бажаете видалити?",
                RB.getString("загальні.увага"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            String query = "DELETE FROM ARCHITECTURE WHERE ID=" + ((idLable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getDbId();
            try {
                derby_DB.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list_load_DB();
        }
    }

    /**
     * Загрузка з базы
     */
    public void list_load_DB() {
        System.out.println("list_load_DB");
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE ORDER BY NAME ASC");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<idLable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                idLable tmp_lable = new idLable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            LV_archs_DB.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();

        }/**/
    }

    public void select_to_save_DB() {//скопировать имя патерна для сохранения
        if (derby_DB != null) {
            TF_arch_name_DB.setText(((idLable) LV_archs_DB.getSelectionModel().getSelectedItems().get(0)).getText());
        }
    }

    public void draw_arch_struct() {//відобразити структуру архітектури
        P_arch_struct.getChildren().clear();
        Integer pos_x = 0, pos_y = 0, s_x1 = 30, s_y1 = 30, s_x2 = 80, s_y2 = 30;
        Button tmp_btn;
        Label tmp_label;
        String full_arch_description = new String(arch_tmp.getDescription());
        //pos_x += s_x1;
        //pos_y += s_y1;
        for (int s_lay = 0; s_lay < arch_tmp.getLayers().size(); s_lay++) {
            //Редагування
            tmp_btn = new Button(RB.getString("загальні.Редагувати"));
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
            tmp_btn = new Button(RB.getString("загальні.Видалити"));
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
            full_arch_description += "\n" + arch_tmp.getLayers().get(s_lay).getDescription();
            tmp_label = new Label(RB.getString("загальні.Шар") + " " + arch_tmp.getLayers().get(s_lay).getName());
            tmp_label.setTooltip(new Tooltip(arch_tmp.getLayers().get(s_lay).getDescription()));
            tmp_label.setLayoutX(pos_x + s_x2 + s_x2);
            tmp_label.setLayoutY(pos_y);
            P_arch_struct.getChildren().add(tmp_label);
            pos_y += s_y1;
            pos_x += s_x1;
            //Модулі
            for (int s_mod = 0; s_mod < arch_tmp.getLayers().get(s_lay).getModules().size(); s_mod++) {//вивід модулів
                /*Кнопка Патернів*/
                tmp_btn = new Button(RB.getString("загальні.Патерни") + "(" + +arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getAvilablePatterns().size() + ")...");
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
                tmp_btn = new Button(RB.getString("загальні.Редагувати"));
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

                tmp_btn = new Button(RB.getString("загальні.Видалити"));
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
                full_arch_description += "\n" + arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getDescription();
                tmp_label = new Label(RB.getString("загальні.Модуль") + " " + arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getName());
                tmp_label.setTooltip(new Tooltip(arch_tmp.getLayers().get(s_lay).getModules().get(s_mod).getDescription()));
                pos_x += s_x2;
                tmp_label.setLayoutX(pos_x);
                tmp_label.setLayoutY(pos_y);
                P_arch_struct.getChildren().add(tmp_label);
                pos_y += s_y2 - s_y1;//різниця між висотой між слоями і розміром кнопки
                pos_y += s_y1 + 5;//Сдвиг вниз
                pos_x = s_x1;
            }
            tmp_btn = new Button(RB.getString("загальні.Додати") + " " + RB.getString("загальні.модуль"));
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
        tmp_btn = new Button(RB.getString("загальні.Додати") + " " + RB.getString("загальні.шар"));
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
        TA_full_arch_description.setText(full_arch_description);

        //P_arch_struct.setPrefHeight(pos_y);
    }


    public void add_custom_layer_to_arch(Architecture arch_in) {//Додати шар в архітектуру
        Layer layer = new Layer();

        String name = Modals.showInputDialog(RB.getString("загальні.шар"), RB.getString("загальні.введіть_назву"), null);

        if (name != null && !name.equals("")) {
            String description = Modals.showInputDialog(RB.getString("загальні.шар"), RB.getString("загальні.введіть_опис"), null);
            layer.setName(name);
            layer.setDescription(description);
            arch_in.getLayers().add(layer);
            arch_tmp = arch_in;
        }
        draw_arch_struct();
    }

    public void add_custom_mod_to_layer(Architecture arch_in, Integer lay_nom) {//додати модуль в шар
        Module module = new Module();
        String name = Modals.showInputDialog(RB.getString("загальні.модуль"), RB.getString("загальні.введіть_назву"), null);
        if (name != null && !name.equals("")) {//перевірка на пустий Введення
            String description = Modals.showInputDialog(RB.getString("загальні.модуль"), RB.getString("загальні.введіть_опис"), null);
            module.setName(name);
            module.setDescription(description);
            arch_in.getLayers().get(lay_nom).getModules().add(module);
            arch_tmp = arch_in;
        }
        draw_arch_struct();
    }

    public void del_mod(Integer lay_nom, Integer mod_nom) {
        if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"), RB.getString("загальні.ви_впевнені_що_бажаете_видалити?") + " " + RB.getString("загальні.Модуль"))) {
            arch_tmp.getLayers().get(lay_nom.intValue()).getModules().remove(mod_nom.intValue());
            draw_arch_struct();
        }
    }

    public void del_lay(Integer lay_nom) {
        if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"), RB.getString("загальні.ви_впевнені_що_бажаете_видалити?") + " " + RB.getString("загальні.Шар"))) {
            arch_tmp.getLayers().remove(lay_nom.intValue());
            draw_arch_struct();
        }
    }

    public void edit_lay(Integer lay_nom) {
        String name = Modals.showInputDialog(RB.getString("загальні.Шар"), RB.getString("загальні.введіть_назву"), arch_tmp.getLayers().get(lay_nom).getName());
        if (name != null && !name.equals("")) {
            arch_tmp.getLayers().get(lay_nom).setName(name);
            arch_tmp.getLayers().get(lay_nom).setDescription(
                    Modals.showInputDialog(RB.getString("загальні.Шар"), RB.getString("загальні.введіть_опис"), arch_tmp.getLayers().get(lay_nom).getDescription())
            );
        }
        draw_arch_struct();
    }

    public void edit_mod(Integer lay_nom, Integer mod_nom) {

        String name = Modals.showInputDialog(RB.getString("загальні.Модуль"), RB.getString("загальні.введіть_назву"), arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).getName());

        if (name != null && !name.equals("")) {
            arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).setName(name);
            arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).setDescription(
                    Modals.showInputDialog(RB.getString("загальні.Модуль"), RB.getString("загальні.введіть_опис"), arch_tmp.getLayers().get(lay_nom).getModules().get(mod_nom).getDescription())
            );
        }
        System.out.println(name);
        draw_arch_struct();
    }


    public void edit_mod_patterns(final int layer, final int module) {//Редагувати патрни шару
        try {
            arch_old = arch_tmp.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        if (Modals.showYNDialog(RB.getString("загальні.увага"), "Зберегти зміни в архітектурі") == Modals.Response.YES) {
            archWork.arch_save_to_DB(arch_old, derby_DB);
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/repository_editor/views/paterns_editor.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        paterns_editor_C controller = loader.<paterns_editor_C>getController();
        controller.initData(arch_old.getLayers().get(layer).getModules().get(module), derby_DB);
        stage.setTitle("Редагування патернів \"" + arch_old.getLayers().get(layer).getModules().get(module).getName() + "\" \"" + arch_old.getLayers().get(layer).getName() + "\" \"" + arch_old.getName() + "\"");
        stage.showAndWait();
        draw_arch_struct();
    }


    public void arch_uml_gen(ActionEvent actionEvent) {
        //arch_image = draw_uml.draw_class(functions.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));

        arch_image = drawUml.draw_class(archWork.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/repository_editor/views/image_preview.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.initModality(Modality.NONE);
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        image_preview_C controller = loader.<image_preview_C>getController();
        controller.initData(arch_image, arch_old.getName());

        stage.show();
    }

    public void arch_uml_text_draw(ActionEvent actionEvent) {
    }

    public void save_this_arch_to_DB(ActionEvent actionEvent) {
        //TODO решить как лутьше
        arch_image = drawUml.draw_class(archWork.arch_uml_text_gen(arch_tmp) + new String(TA_arch_relations.getText()));
        arch_tmp.setName(TF_arch_name_DB.getText());
        arch_tmp.setPreview(arch_image);
        arch_tmp.setUsecase(TA_arch_relations.getText());
        arch_tmp.setDescription(TA_arch_description.getText());
        resultInfo result = archWork.arch_save_to_DB(arch_tmp, derby_DB);
        if (result.getStatus() == true) {
            Modals.showInfoApplicationModal(RB.getString("загальні.інформація"), "Архітектура успішно збережена.");
        } else {
            Modals.showInfoApplicationModal(RB.getString("загальні.попередження"), "Архітектура не збереження зверныться до Адмыныстратора чи програміста.\n" + result.getComment());

        }
        list_load_DB();
    }

    public void open_patrern_manager(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/repository_editor/views/pattern_manager.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        patterns_manager_C controller = loader.<patterns_manager_C>getController();
        controller.initData(derby_DB);
        stage.setTitle("Менеджер патернів ");
        stage.showAndWait();
    }

    public void export_all_to_docx(ActionEvent actionEvent) {
//        root.setDisable(true);

        FileChooser docx_FC = new FileChooser();
        docx_FC.setInitialDirectory(new File(System.getProperty("user.dir")));
        docx_FC.setTitle("Вкажіть куди імпортувати...");
        docx_FC.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Word 2007", "*.docx")
        );
        CustomXWPFDocument document;
        FileOutputStream fos;
        String id;
        BufferedImage bi;
        XWPFDocument docx;
        XWPFParagraph tmpParagraph;
        XWPFRun tmpRun;
        Architecture architecture;
        File docx_f = docx_FC.showSaveDialog(thisstage);//файл док
        File imgFile = new File("tmp.png");//изображение
        String imgfile = "tmp.png";
        File outputfile = new File(imgfile);
        try {

            docx = new XWPFDocument();
            docx.write(new FileOutputStream(docx_f));

/*
            docx = new XWPFDocument(new FileInputStream(docx_f));
            XWPFHeaderFooterPolicy policy = docx.getHeaderFooterPolicy();
            if (policy == null) {
                //docx = new XWPFDocument();
                CTP ctp = CTP.Factory.newInstance();
                CTR ctr = ctp.addNewR();
                CTRPr rpr = ctr.addNewRPr();
                CTText textt = ctr.addNewT();
                textt.setStringValue(" Page PAGE \\* MERGEFORMAT");
                XWPFParagraph codePara = new XWPFParagraph(ctp, docx);
                XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
                newparagraphs[0] = codePara;
                CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
                XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docx, sectPr);
                headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, newparagraphs);
            } else {
                // Already has a header, change it
            }
            docx.write(new FileOutputStream(docx_f));
            /**/


            //импорт глобальных паттернов
            ArrayList<Pattern> globalPatterns = new ArrayList<>();
            ResultSet resultSet = null;
            Pattern tmpPattern;
            try {
                try {
                    //derby_DB
                    resultSet = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE TYPE='GLOBAL'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ObservableList<idLable> items = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    tmpPattern = Pattern.patternLoadFromDB(resultSet.getInt("ID"), derby_DB);
                    if (!tmpPattern.getName().startsWith("*")) {//Помечен как не доделан
                        globalPatterns.add(tmpPattern);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }/**/

            logger.info("Glabals paterns load from DB end");
            docx = new XWPFDocument(new FileInputStream(docx_f));
            tmpParagraph = docx.createParagraph();
            tmpRun = tmpParagraph.createRun();
            tmpRun.setText("Глобальні патерні старт");
            docx.write(new FileOutputStream(docx_f));

            for (Pattern pattern : globalPatterns) {
                logger.info("write pattern - " + pattern.getName());
                docx = new XWPFDocument(new FileInputStream(docx_f));
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                tmpRun.setBold(true);
                tmpRun.setText("Назва");
                /* Назва */
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                tmpRun.setText(pattern.getName());
                /* Опис */
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                tmpRun.setBold(true);
                tmpRun.setText("Опис");
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                tmpRun.setText(pattern.getDescription());

                docx.write(new FileOutputStream(docx_f));

                bi = ImageConverter.FXImgtoBufferedImage(pattern.getPreview());
                new FileOutputStream(outputfile).close();
                ImageIO.write(bi, "png", outputfile);

                document = new CustomXWPFDocument(new FileInputStream(docx_f));

                id = document.addPictureData(new FileInputStream(outputfile), Document.PICTURE_TYPE_PNG);
                Integer width = ((Double) pattern.getPreview().getWidth()).intValue();//ширина картинки що потрібно вставити
                Integer height = ((Double) pattern.getPreview().getHeight()).intValue();//висота картинки що потрібно вставити
                Integer max_height = 830;//максимальна висота
                if (height > max_height) {
                    width = width * max_height / height;
                    height = height * max_height / height;
                } else {
                }
                document.createPicture(id, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), width, height);//((Double) architecture.getPreview().getHeight()).intValue());
                fos = new FileOutputStream(docx_f);
                document.write(fos);
                fos.flush();
                fos.close();

            }
            logger.info("patterns import end");
            /**/

            for (int arch_nom = 0; arch_nom < LV_archs_DB.getItems().size(); arch_nom++) {

                docx = new XWPFDocument(new FileInputStream(docx_f));
                tmpParagraph = docx.createParagraph();
                tmpRun = tmpParagraph.createRun();
                architecture = archWork.arch_load_from_DB(((idLable) LV_archs_DB.getItems().get(arch_nom)).getDbId(), derby_DB);
                tmpRun.setText("(" + RB.getString("загальні.Архітектура") + ")" + architecture.getName());
                docx.write(new FileOutputStream(docx_f));

                bi = ImageConverter.FXImgtoBufferedImage(architecture.getPreview());
                new FileOutputStream(outputfile).close();
                ImageIO.write(bi, "png", outputfile);

                document = new CustomXWPFDocument(new FileInputStream(docx_f));
                fos = new FileOutputStream(docx_f);
                id = document.addPictureData(new FileInputStream(outputfile), Document.PICTURE_TYPE_PNG);
                Integer width = ((Double) architecture.getPreview().getWidth()).intValue();//ширина картинки що потрібно вставити
                Integer height = ((Double) architecture.getPreview().getHeight()).intValue();//висота картинки що потрібно вставити
                Integer max_height = 830;//максимальна висота
                if (height > max_height) {
                    width = width * max_height / height;
                    height = height * max_height / height;
                } else {
                }

                document.createPicture(id, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), width, height);//((Double) architecture.getPreview().getHeight()).intValue());
                document.write(fos);
                fos.flush();
                fos.close();
                for (int layer = 0; layer < architecture.getLayers().size(); layer++) {
                    docx = new XWPFDocument(new FileInputStream(docx_f));
                    tmpParagraph = docx.createParagraph();
                    tmpRun = tmpParagraph.createRun();
                    tmpRun.setText("--(" + "Шар" + ")" + architecture.getLayers().get(layer).getName());
                    docx.write(new FileOutputStream(docx_f));
                    for (int module = 0; module < architecture.getLayers().get(layer).getModules().size(); module++) {
                        new FileInputStream(outputfile).close();
                        tmpRun.addBreak();
                        tmpRun.setText("------(" + RB.getString("загальні.Модуль") + ")" + architecture.getLayers().get(layer).getModules().get(module).getName());
                        docx.write(new FileOutputStream(docx_f));
                        for (int avilable_pattern = 0; avilable_pattern < architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().size(); avilable_pattern++) {
                            docx = new XWPFDocument(new FileInputStream(docx_f));
                            tmpParagraph = docx.createParagraph();
                            tmpRun = tmpParagraph.createRun();
                            //tmpRun.setText("---------(Патерн)" + architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getName());
                            docx.write(new FileOutputStream(docx_f));
                            if (architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview() == null) {//если превю не существует создать
                                architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).setPreview(
                                        functions.draw_class_image(architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getUmlText()));//создать превю
                                Pattern.pattern_save_to_DB(architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern), derby_DB);//сохарнить в базу патерн с превюшкой
                                bi = ImageConverter.FXImgtoBufferedImage(architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview());

                            } else {
                                bi = ImageConverter.FXImgtoBufferedImage(architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview());
                            }
                            try {
                                new FileOutputStream(outputfile).close();
                                ImageIO.write(bi, "png", outputfile);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            document = new CustomXWPFDocument(new FileInputStream(docx_f));
                            fos = new FileOutputStream(docx_f);
                            id = document.addPictureData(new FileInputStream(outputfile), Document.PICTURE_TYPE_PNG);

                            width = ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview().getWidth()).intValue();//ширина картинки що потрібно вставити
                            height = ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview().getHeight()).intValue();//висота картинки що потрібно вставити

                            if (height > max_height) {
                                width = width * max_height / height;
                                height = height * max_height / height;
                            } else {
                            }
                            document.createPicture("---------(" + RB.getString("загальні.Патерн") + ")" + architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getName(), id, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview().getWidth()).intValue(), ((Double) architecture.getLayers().get(layer).getModules().get(module).getAvilablePatterns().get(avilable_pattern).getPreview().getHeight()).intValue());
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
        logger.info("Export end");
        Modals.showInfoApplicationModal(RB.getString("загальні.інформація"), "Експорт завершено");
        root.setDisable(false);
    }
}