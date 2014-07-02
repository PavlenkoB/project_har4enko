package create_arch.Controllers;

import Classes.*;
import editor.classes.DerbyDBManager;
import editor.services.arch_work;
import editor.services.functions;
import editor.services.gen_arch_done;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */

/**
 * Created by Alex on 10.05.2014.
 */
public class create_arch_C implements Initializable {
    public static Architecture arc_choise = new Architecture();
    public MenuItem close;                      // пункт меню вихід
    public ListView Arch_list;                  // Список архітектур для вибору
    public TextArea Description;                // Поле опису вибраної архітектури
    public ImageView Usecase_view;              // Поле візуалізації вибраної архітектури
    public Button arch_create_next_1;
    public AnchorPane Arch_choise_1;
    public AnchorPane Arch_choise_2;
    public AnchorPane back_gr_grid;
    public AnchorPane back_grid_vis;
    public AnchorPane Arch_choise_3;
    public Button cancelButton;
    public Button okButton;
    public AnchorPane Task_save;
    public TextField task_name;
    public TextField task_description;
    public Button Save_all_done;
    public Button Save_all;
    ArrayList<Label> layer_names = new ArrayList<>();
    ArrayList<javafx.scene.control.Label> module_names = new ArrayList<>();
    //ArrayList<ChoiceBox> selected_paterns = new ArrayList<>();
    ArrayList<SplitMenuButton> sel_pat_splitmenu = new ArrayList<>();
    //public static Stage Primary_arch_create;
    ArrayList<Module> module_done = new ArrayList<>();
    ArrayList<Module> modules_done = new ArrayList<>();
    ArrayList<Layer> layers_done = new ArrayList<>();
    ArrayList<Architecture> architectures_done = new ArrayList<>();

    DerbyDBManager derby_DB;// = new DerbyDBManager("DB/paterns_DB");
    Task task = new Task();
    @FXML
    private Image class_image;


    //Windows close dialog
    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/create_arch/Interface/Close.fxml"));
            stage.setTitle("Закриття програми");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Exit(ActionEvent actionEvent) {
        disconnect_DB(null);
        System.exit(1);
    }

    public void GoBack_main(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    //Windows close dialog

    public void disconnect_DB(ActionEvent actionEvent) {
        if (derby_DB != null) {
            derby_DB.disconectDB();
            derby_DB = null;
        }
        ObservableList<String> items = FXCollections.observableArrayList();
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
            set_usecase();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }
    }


    public void initialize(URL url, ResourceBundle rb) {
        try {
            Arch_choise_1.setVisible(true);
            Arch_choise_2.setVisible(false);
            Arch_choise_3.setVisible(false);
            Task_save.setVisible(false);
            set_usecase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set_usecase() throws IOException, SQLException {
        Arch_choise_1.setVisible(true);
        Arch_choise_2.setVisible(false);
        Arch_choise_3.setVisible(false);
        Task_save.setVisible(false);
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
            Arch_list.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void canceler(ActionEvent actionEvent) {
    }

    public void select_to_display() {
        arc_choise = null;
        arc_choise = new Architecture();
        //arc_choise.getLayers().clear();
        if (derby_DB != null) {
            Number num_choise_arch = Arch_list.getSelectionModel().selectedIndexProperty().getValue();
            ResultSet rs_arch;
            arc_choise = arch_work.arch_load_from_DB(functions.get_ID((String) Arch_list.getItems().get(num_choise_arch.intValue())), derby_DB);

            Description.setText(arc_choise.getDescription());
            class_image = arc_choise.getPreview();
            Usecase_view.setFitHeight(class_image.getRequestedHeight());
            Usecase_view.setFitWidth(class_image.getRequestedWidth());
            Usecase_view.setImage(class_image);
            Usecase_view.setImage(class_image);
        }
    }

    public void arch_create_next_1(ActionEvent actionEvent) throws IOException, SQLException {
        Arch_choise_1.setVisible(false);
        Arch_choise_2.setVisible(true);
        Arch_choise_3.setVisible(false);
        Task_save.setVisible(false);
        arc_choise.getLayers().clear();
        //selected_paterns.clear();
        sel_pat_splitmenu.clear();
        GridPane gridpane_lay = new GridPane();
        ArrayList<GridPane> gridPane_mod = new ArrayList<>();
        gridPane_mod.clear();
        gridpane_lay.setHgap(2);
        gridpane_lay.setVgap(20);
        gridpane_lay.setPadding(new Insets(5, 5, 5, 5));
        ResultSet rs_lay, rs_mod, rs_pat;
        int s_lay = 0, s_mod = 0;
        Label tmp_lable = new Label();
        try {
            rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + arc_choise.getId());
            while (rs_lay.next()) {
                arc_choise.getLayers().add(new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                tmp_lable = new Label(rs_lay.getString("NAME"));
                tmp_lable.setAlignment(Pos.CENTER);
                tmp_lable.setFont(Font.font(15));
                tmp_lable.setMinWidth(200);
                gridpane_lay.setHalignment(tmp_lable, HPos.CENTER);
                gridpane_lay.setValignment(tmp_lable, VPos.CENTER);
                gridpane_lay.add(tmp_lable, 0, s_lay + 1);
                rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                s_mod = 0;
                gridPane_mod.add(new GridPane());
                gridPane_mod.get(s_lay).getChildren().removeAll();
                gridPane_mod.get(s_lay).setHgap(2);
                gridPane_mod.get(s_lay).setVgap(20);
                //arc_choise.getLayers().get(arc_choise.getLayers().lastIndexOf(arc_choise.getLayers())).getModules().clear();
                while (rs_mod.next()) {
                    arc_choise.getLayers().get(s_lay).getModules().add(new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    tmp_lable = new Label(rs_mod.getString("NAME"));
                    tmp_lable.setAlignment(Pos.CENTER);
                    tmp_lable.setFont(Font.font(14));
                    tmp_lable.setMinWidth(300);
                    gridPane_mod.get(s_lay).setHalignment(tmp_lable, HPos.CENTER);
                    gridPane_mod.get(s_lay).setValignment(tmp_lable, VPos.CENTER);
                    gridPane_mod.get(s_lay).add(tmp_lable, 0, s_mod);
                    //selected_paterns.add(s_mod, new ChoiceBox());
                    sel_pat_splitmenu.add(s_mod, new SplitMenuButton());
                    //ObservableList<String> items = FXCollections.observableArrayList();
                    ObservableList<CheckMenuItem> mitems = FXCollections.observableArrayList();
                    rs_pat = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        arc_choise.getLayers().get(s_lay).getModules().get(s_mod).getAvilable_paterns().add(new Pattern(rs_pat.getInt("ID"), rs_pat.getInt("MOD_ID"), rs_pat.getString("NAME"), rs_pat.getString("DESCRIPTION"), rs_pat.getString("VALUE")));
                        //items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                        mitems.add(new CheckMenuItem(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME")));
                    }
                    mitems.add(new CheckMenuItem("Обрати усі"));
                    mitems.get(mitems.size() - 1).isSelected();
                    //selected_paterns.get(s_mod).setItems(items);
                    sel_pat_splitmenu.get(s_mod).setText("Виберіть патерни");
                    sel_pat_splitmenu.get(s_mod).getItems().addAll(mitems);
                    sel_pat_splitmenu.get(s_mod).setMinWidth(300);
                    sel_pat_splitmenu.get(s_mod).setMaxWidth(300);
                    //selected_paterns.get(s_mod).setMinWidth(300);
                    //selected_paterns.get(s_mod).setMaxWidth(300);
                    gridPane_mod.get(s_lay).setHalignment(sel_pat_splitmenu.get(s_mod), HPos.CENTER);
                    gridPane_mod.get(s_lay).add(sel_pat_splitmenu.get(s_mod), 1, s_mod);
                    //gridPane_mod.get(s_lay).setHalignment(selected_paterns.get(s_mod), HPos.CENTER);
                    //gridPane_mod.get(s_lay).add(selected_paterns.get(s_mod), 1, s_mod);
                    s_mod++;
                }
                //gridPane_mod.get(s_lay).setGridLinesVisible(true);
                gridpane_lay.add(gridPane_mod.get(s_lay), 1, s_lay + 1);
                s_lay++;
            }
        } catch (SQLException e) {
        }

        //Назва шару - вивід
        tmp_lable = new Label("Шар");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        gridpane_lay.setHalignment(tmp_lable, HPos.CENTER);
        gridpane_lay.setValignment(tmp_lable, VPos.CENTER);
        gridpane_lay.add(tmp_lable, 0, 0);

        GridPane gridPane_mod_Title = new GridPane();
        gridPane_mod_Title.getChildren().clear();
        gridPane_mod_Title.setHgap(2);
        gridPane_mod_Title.setVgap(1);

        tmp_lable = new Label("Модуль");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        tmp_lable.setMinWidth(300);
        gridPane_mod_Title.setHalignment(tmp_lable, HPos.CENTER);
        gridPane_mod_Title.setValignment(tmp_lable, VPos.CENTER);
        gridPane_mod_Title.add(tmp_lable, 0, 0);

        tmp_lable = new Label("Паттерн");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        tmp_lable.setMinWidth(300);
        gridPane_mod_Title.setHalignment(tmp_lable, HPos.CENTER);
        gridPane_mod_Title.setValignment(tmp_lable, VPos.CENTER);
        gridPane_mod_Title.add(tmp_lable, 1, 0);

        gridpane_lay.add(gridPane_mod_Title, 1, 0);


        //gridpane_lay.setGridLinesVisible(true);
        AnchorPane.setLeftAnchor(gridpane_lay, (double) 10);
        AnchorPane.setRightAnchor(gridpane_lay, (double) 10);
        gridpane_lay.setMaxWidth(Region.USE_COMPUTED_SIZE);
        back_gr_grid.getChildren().removeAll();
        back_gr_grid.getChildren().clear();
        back_gr_grid.getChildren().add(gridpane_lay);
    }

    public void arch_create_next_2(ActionEvent actionEvent) {
        Arch_choise_1.setVisible(false);
        Arch_choise_2.setVisible(false);
        Arch_choise_3.setVisible(true);
        Task_save.setVisible(false);
        ResultSet rs = null;
        module_done.clear();

        sel_pat_splitmenu.size();

        for (int i = 0; i < sel_pat_splitmenu.size(); i++) {
            rs = null;
            Pattern paterns = new Pattern();
            Module modules = new Module();
            module_done.add(new Module());
            boolean all = false;

            for (int j = 0; j < sel_pat_splitmenu.get(i).getItems().size(); j++) {
                if (((CheckMenuItem) sel_pat_splitmenu.get(i).getItems().get(j)).selectedProperty().getValue() & (sel_pat_splitmenu.get(i).getItems().get(j)).getText().equals("Обрати усі")) {
                    all = true;
                }
            }


            if (all) {
                Layer layer = new Layer();
                ResultSet rs_mod = null, rs_lay = null;
                try {
                    rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE ID=" + functions.get_ID(((CheckMenuItem) sel_pat_splitmenu.get(i).getItems().get(0)).getText().toString()));
                    rs.next();
                    rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE ID=" + rs.getInt("MOD_ID"));
                    rs_mod.next();
                    modules = new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION"));
                    rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ID=" + modules.getLay_id());
                    rs_lay.next();
                    layer = new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                for (int l = 0; l < arc_choise.getLayers().size(); l++) {
                    if (arc_choise.getLayers().get(l).getId() == layer.getId()) {
                        for (int k = 0; k < arc_choise.getLayers().get(l).getModules().size(); k++) {
                            if (arc_choise.getLayers().get(l).getModules().get(k).getId() == modules.getId()) {
                                module_done.get(i).getAvilable_paterns().addAll(arc_choise.getLayers().get(l).getModules().get(k).getAvilable_paterns());
                            }
                        }
                    }
                }
                module_done.get(i).setId(modules.getId());
                module_done.get(i).setLay_id(modules.getLay_id());
                module_done.get(i).setName(modules.getName());
            } else {
                for (int j = 0; j < sel_pat_splitmenu.get(i).getItems().size(); j++) {
                    if (((CheckMenuItem) sel_pat_splitmenu.get(i).getItems().get(j)).selectedProperty().getValue() & !sel_pat_splitmenu.get(i).getItems().get(j).getText().equals("Обрати усі")) {
                        ResultSet rs_mod = null;
                        try {
                            rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE ID=" + functions.get_ID(((CheckMenuItem) sel_pat_splitmenu.get(i).getItems().get(j)).getText().toString()));
                            rs.next();
                            paterns = new Pattern(rs.getInt("ID"), rs.getInt("MOD_ID"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("VALUE"));
                            rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE ID=" + rs.getInt("MOD_ID"));
                            rs_mod.next();
                            modules = new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION"));

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        module_done.get(i).getAvilable_paterns().add(paterns);
                        module_done.get(i).setId(modules.getId());
                        module_done.get(i).setLay_id(modules.getLay_id());
                        module_done.get(i).setName(modules.getName());
                    }
                }
            }
        }

/**
 for (int i = 0; i < selected_paterns.size(); i++) {
 rs = null;
 Pattern paterns = new Pattern();
 Module modules = new Module();
 module_done.add(new Module());
 if (selected_paterns.get(i).getSelectionModel().getSelectedItem() != null) {
 ResultSet rs_mod = null;
 try {
 rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE ID=" + functions.get_ID(selected_paterns.get(i).getSelectionModel().getSelectedItem().toString()));
 rs.next();
 paterns = new Pattern(rs.getInt("ID"), rs.getInt("MOD_ID"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("VALUE"));
 rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE ID=" + rs.getInt("MOD_ID"));
 rs_mod.next();
 modules = new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION"));

 } catch (SQLException e) {
 e.printStackTrace();
 }
 module_done.get(i).getAvilable_paterns().add(paterns);
 module_done.get(i).setId(modules.getId());
 module_done.get(i).setLay_id(modules.getLay_id());
 module_done.get(i).setName(modules.getName());
 } else {
 Layer layer = new Layer();
 ResultSet rs_mod = null, rs_lay = null;
 try {
 rs = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE ID=" + functions.get_ID(selected_paterns.get(i).getItems().get(0).toString()));
 rs.next();
 rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE ID=" + rs.getInt("MOD_ID"));
 rs_mod.next();
 modules = new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION"));
 rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ID=" + modules.getLay_id());
 rs_lay.next();
 layer = new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION"));
 } catch (SQLException e) {
 e.printStackTrace();
 }
 for (int j = 0; j < arc_choise.getLayers().size(); j++) {
 if (arc_choise.getLayers().get(j).getId() == layer.getId()) {
 for (int k = 0; k < arc_choise.getLayers().get(j).getModules().size(); k++) {
 if (arc_choise.getLayers().get(j).getModules().get(k).getId() == modules.getId()) {
 module_done.get(i).getAvilable_paterns().addAll(arc_choise.getLayers().get(j).getModules().get(k).getAvilable_paterns());
 }
 }
 }
 }
 module_done.get(i).setId(modules.getId());
 module_done.get(i).setLay_id(modules.getLay_id());
 module_done.get(i).setName(modules.getName());
 }
 }**/

        int num_mod_done = 0;
        modules_done.clear();
        for (int i = 0; i < module_done.size(); i++) {
            for (int j = 0; j < module_done.get(i).getAvilable_paterns().size(); j++) {
                modules_done.add(new Module());
                modules_done.get(num_mod_done).setId(module_done.get(i).getId());
                modules_done.get(num_mod_done).setName(module_done.get(i).getName());
                modules_done.get(num_mod_done).setLay_id(module_done.get(i).getLay_id());
                modules_done.get(num_mod_done).getAvilable_paterns().add(module_done.get(i).getAvilable_paterns().get(j));
                modules_done.get(num_mod_done).setSelected_patern(module_done.get(i).getAvilable_paterns().get(j));
                num_mod_done++;
            }
        }

        GridPane gridpane_lay = new GridPane();
        gridpane_lay.getChildren().removeAll();
        ArrayList<GridPane> gridPane_mod = new ArrayList<>();
        gridPane_mod.clear();
        ArrayList<ArrayList<GridPane>> gridPanes_pat = new ArrayList<>();
        gridPanes_pat.clear();
        Label tmp_lable = new Label();
        TextArea tmp_text_area = new TextArea();
        gridpane_lay.setHgap(2);
        gridpane_lay.setVgap(arc_choise.getLayers().size());
        for (int i = 0; i < arc_choise.getLayers().size(); i++) {
            tmp_lable = new Label(arc_choise.getLayers().get(i).getName());
            tmp_lable.setAlignment(Pos.CENTER);
            tmp_lable.setFont(Font.font(14));
            tmp_lable.setMinWidth(200);
            tmp_lable.setMaxWidth(200);

            gridpane_lay.add(tmp_lable, 0, i + 1);
            gridPane_mod.add(new GridPane());
            gridPane_mod.get(i).getChildren().removeAll();
            gridPane_mod.get(i).getChildren().clear();
            gridPane_mod.get(i).setHgap(2);
            gridPane_mod.get(i).setVgap(arc_choise.getLayers().get(i).getModules().size());
            gridPanes_pat.add(new ArrayList());
            for (int j = 0; j < arc_choise.getLayers().get(i).getModules().size(); j++) {
                tmp_lable = new Label(arc_choise.getLayers().get(i).getModules().get(j).getName());
                tmp_lable.setAlignment(Pos.CENTER);
                tmp_lable.setFont(Font.font(14));
                tmp_lable.setMinWidth(300);
                tmp_lable.setMaxWidth(300);

                gridPane_mod.get(i).add(tmp_lable, 0, j);
                gridPanes_pat.get(i).add(new GridPane());
                gridPanes_pat.get(i).get(j).getChildren().removeAll();
                gridPanes_pat.get(i).get(j).getChildren().clear();
                gridPanes_pat.get(i).get(j).setHgap(2);
                gridPanes_pat.get(i).get(j).setVgap(arc_choise.getLayers().get(i).getModules().get(j).getAvilable_paterns().size());
                int com = 0;
                for (int k = 0; k < module_done.size(); k++) {
                    if (module_done.get(k).getId() == arc_choise.getLayers().get(i).getModules().get(j).getId()) {
                        for (int m = 0; m < module_done.get(k).getAvilable_paterns().size(); m++) {

                            tmp_text_area = new TextArea(module_done.get(k).getAvilable_paterns().get(m).getDescription());
                            tmp_text_area.setMinWidth(200);
                            tmp_text_area.setMaxHeight(35);
                            tmp_text_area.setPrefWidth(200);
                            tmp_text_area.setPrefHeight(40);
                            tmp_text_area.setEditable(false);

                            tmp_lable = new Label(module_done.get(k).getAvilable_paterns().get(m).getName());
                            tmp_lable.setMinWidth(300);
                            tmp_lable.setMaxWidth(300);
                            gridPanes_pat.get(i).get(j).add(tmp_lable, 0, com);
                            //tmp_lable = new Label(module_done.get(k).getAvilable_paterns().get(m).getDescription());
                            //tmp_lable.setMinWidth(150);
                            gridPanes_pat.get(i).get(j).setAlignment(Pos.CENTER);
                            gridPanes_pat.get(i).get(j).add(tmp_text_area, 1, com);
                            com++;
                        }
                    }
                }
                gridPane_mod.get(i).setGridLinesVisible(true);
                gridPane_mod.get(i).setPadding(new Insets(5, 5, 5, 5));
                gridPane_mod.get(i).add(gridPanes_pat.get(i).get(j), 1, j);
            }
            gridpane_lay.add(gridPane_mod.get(i), 1, i + 1);
        }

        int num_lay_done = 0;
        for (int i = 0; i < arc_choise.getLayers().size(); i++) {
            for (int j = 0; j < module_done.size(); j++) {
                if (modules_done.get(j).getLay_id() == arc_choise.getLayers().get(i).getId()) {

                }
            }
        }

        //Назва шару - вивід
        tmp_lable = new Label("Шар");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        gridpane_lay.setHalignment(tmp_lable, HPos.CENTER);
        gridpane_lay.setValignment(tmp_lable, VPos.CENTER);
        gridpane_lay.add(tmp_lable, 0, 0);

        GridPane gridPane_mod_Title = new GridPane();
        gridPane_mod_Title.getChildren().clear();
        gridPane_mod_Title.setHgap(2);
        gridPane_mod_Title.setVgap(1);

        tmp_lable = new Label("Модуль");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        tmp_lable.setMinWidth(300);
        gridPane_mod_Title.setHalignment(tmp_lable, HPos.CENTER);
        gridPane_mod_Title.setValignment(tmp_lable, VPos.CENTER);
        gridPane_mod_Title.add(tmp_lable, 0, 0);

        tmp_lable = new Label("Паттерн");
        tmp_lable.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tmp_lable.setAlignment(Pos.CENTER);
        tmp_lable.setMinWidth(300);
        gridPane_mod_Title.setHalignment(tmp_lable, HPos.CENTER);
        gridPane_mod_Title.setValignment(tmp_lable, VPos.CENTER);
        gridPane_mod_Title.add(tmp_lable, 1, 0);
        //gridPane_mod_Title.setGridLinesVisible(true);

        gridpane_lay.add(gridPane_mod_Title, 1, 0);


        gridpane_lay.setGridLinesVisible(true);
        gridpane_lay.setPadding(new Insets(5, 5, 5, 5));

        AnchorPane.setLeftAnchor(gridpane_lay, (double) 10);
        AnchorPane.setRightAnchor(gridpane_lay, (double) 10);
        gridpane_lay.setMaxWidth(Region.USE_COMPUTED_SIZE);

        back_grid_vis.getChildren().removeAll();
        back_grid_vis.getChildren().clear();
        back_grid_vis.getChildren().add(gridpane_lay);
    }

    public void Save_arch(ActionEvent actionEvent) {
        Arch_choise_1.setVisible(false);
        Arch_choise_2.setVisible(false);
        Arch_choise_3.setVisible(false);
        Task_save.setVisible(true);

        architectures_done = gen_arch_done.pre_combine(arc_choise, module_done);
        System.out.print("Lol");
        System.out.print(architectures_done.get(0).getId());

    }

    public void Save_architecture_done(ActionEvent actionEvent) {
        architectures_done.clear();
        architectures_done = gen_arch_done.pre_combine(arc_choise, module_done);
        task.setName(task_name.getText());
        task.setDescription(task_description.getText());
        task.setArchitectures(architectures_done);

        boolean res_task = new functions().task_done_save_to_DB(task, derby_DB);
        if (res_task)
            try {
                for (int i = 0; i < architectures_done.size(); i++) {
                    boolean res_arch = new functions().arch_done_save_to_DB(task.getId(), architectures_done.get(i), derby_DB);
                }

                try {
                    Stage stage = new Stage();
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("/create_arch/Interface/Save_done.fxml"));
                    stage.setTitle("Збереження успішне");
                    stage.setScene(new Scene(root, 600, 130));
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public void Save_done_all(ActionEvent actionEvent) {
        disconnect_DB(null);
        System.exit(1);
    }

}
