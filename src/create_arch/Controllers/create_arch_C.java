package create_arch.Controllers;

import editor.services.draw_uml;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import rating_arch.DB_manager;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */

/**
 * Created by Alex on 10.05.2014.
 */
public class create_arch_C implements Initializable {
    public MenuItem close;
    public VBox background;
    public ListView Arch_list;
    public TextArea Description;
    public ImageView Usecase_view;
    public Button arch_create_next_1;
    public Button arch_create_next_2;
    public Pane back_gr_grid;
    @FXML
    private Image class_image;

    public static Architecture arc_choise = new Architecture();
    public static Architecture[] archery;
    public static Layer[] layers;
    public static Module[][] modules;
    public static Pattern[][][] patterns;
    public static Pattern[][] pat_choise;


    DB_manager derby_DB = new DB_manager("paterns_DB");

    //Windows close dialog
    public Button cancelButton;
    public Button okButton;

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

    public void initialize(URL url, ResourceBundle rb) {
        try {
            set_usecase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set_usecase() throws IOException, SQLException {
        archery = usecase();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < archery.length; i++) {
            items.add(archery[i].getName());
        }
        Arch_list.setItems(items);
    }

    public Architecture[] usecase() throws IOException, SQLException {
        String query = "SELECT * FROM ARCHITECTURE";
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        while (buf_q_result.next()) {
            res_count++;
        }
        Architecture[] usecase = new Architecture[res_count];
        res_count = 0;
        while (q_result.next()) {
            usecase[res_count] = new Architecture();
            usecase[res_count].setId(q_result.getInt("ID"));
            usecase[res_count].setDescription(q_result.getString("Description"));
            usecase[res_count].setName(q_result.getString("NAME"));
            usecase[res_count].setUsecase(q_result.getString("USECASE"));
           /*
            System.out.println("ID: " + usecase[res_count].getId());
            System.out.println("Description: " + usecase[res_count].getDescription());
            System.out.println("NAME: " + usecase[res_count].getName());
            */
            res_count++;
        }

        return (usecase);
    }

    public Layer[] layer(int arch_use) throws IOException, SQLException {
        String query = "SELECT * FROM LAYER WHERE LAYER.ARCH_ID = ";
        query += arch_use;
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        while (buf_q_result.next()) {
            res_count++;
        }
        Layer[] layers = new Layer[res_count];
        res_count = 0;
        while (q_result.next()) {
            layers[res_count].setId(q_result.getInt("ID"));
            layers[res_count].setDescription(q_result.getString("Description"));
            layers[res_count].setName(q_result.getString("NAME"));
            layers[res_count].setArch_id(q_result.getInt("ARCH_ID"));
            res_count++;
        }
        return (layers);
    }

    public Module[] module(int lay_id) throws IOException, SQLException {
        String query = "SELECT * FROM MODULE WHERE MODULE.LAY_ID = ";
        query += lay_id;
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        while (buf_q_result.next()) {
            res_count++;
        }
        Module[] modules = new Module[res_count];
        res_count = 0;
        while (q_result.next()) {
            modules[res_count].setId(q_result.getInt("ID"));
            modules[res_count].setDescription(q_result.getString("Description"));
            modules[res_count].setName(q_result.getString("NAME"));
            modules[res_count].setLay_id(q_result.getInt("ARCH_ID"));
            res_count++;
        }
        return (modules);
    }

    public Pattern[] pattern(int mod_id) throws IOException, SQLException {
        String query = "SELECT * FROM PATERNS WHERE PATERNS.MOD_ID = ";
        query += mod_id;
        ResultSet q_result = null;
        q_result = derby_DB.executeQuery(query);
        ResultSet buf_q_result = derby_DB.executeQuery(query);
        int res_count = 0;
        while (buf_q_result.next()) {
            res_count++;
        }
        Pattern[] patterns = new Pattern[res_count];
        res_count = 0;
        while (q_result.next()) {
            patterns[res_count].setId(q_result.getInt("ID"));
            patterns[res_count].setDescription(q_result.getString("Description"));
            patterns[res_count].setName(q_result.getString("NAME"));
            patterns[res_count].setMod_id(q_result.getInt("MOD_ID"));
            patterns[res_count].setTable(q_result.getString("VALUE"));
            res_count++;
        }
        return (patterns);
    }


    public void canceler(ActionEvent actionEvent) {
    }

    public void select_to_display() {
        if (derby_DB != null) {
            String name_list = Arch_list.getSelectionModel().getSelectedItem().toString();
            for (int i = 0; i < archery.length; i++) {
                if (name_list.equals(archery[i].name)) {
                    arc_choise.setId(archery[i].getId());
                    Description.setText(archery[i].description);
                    //Action_draw_class();
                    class_image = draw_uml.draw_class(archery[i].getUsecase());
                    Usecase_view.setFitHeight(class_image.getRequestedHeight());
                    Usecase_view.setFitWidth(class_image.getRequestedWidth());
                    Usecase_view.setImage(class_image);
                    Usecase_view.setImage(class_image);
                }
            }
        }
    }

    /*Действия*/
    @FXML//Отрисовка класса
    public void Action_draw_class() throws IOException, InterruptedException {
        class_image = draw_uml.draw_class("Class1 ..> class2");
        Usecase_view.setFitHeight(class_image.getRequestedHeight());
        Usecase_view.setFitWidth(class_image.getRequestedWidth());
        Usecase_view.setImage(class_image);
        Usecase_view.setImage(class_image);
    }

    public void arch_create_next_1(ActionEvent actionEvent) throws IOException, SQLException {
        Stage Primary_arch_create = (Stage) arch_create_next_1.getScene().getWindow();
        try {
            Parent roots;
            roots = FXMLLoader.load(getClass().getResource("/create_arch/Interface/Create_new_arch_2.fxml"));
            Primary_arch_create.setTitle("Вибір патернів");
            Primary_arch_create.setScene(new Scene(roots, 800, 600));
            Primary_arch_create.setResizable(false);
            Primary_arch_create.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        layers = layer(arc_choise.getId());
        modules = new Module[layers.length][];
        int mod_max = 0;
        for (int i = 0; i > layers.length; i++) {
            modules[i] = module(layers[i].getId());
            if (mod_max < i) {
                mod_max = i;
            }
        }
        int pat_max = 0;
        patterns = new Pattern[layers.length][mod_max][];
        for (int i = 0; i > layers.length; i++) {
            for (int s4 = 0; s4 > modules[i].length; s4++) {
                patterns[i][s4] = pattern(modules[i][s4].getId());
                if (pat_max < i) {
                    pat_max = i;
                }
            }
        }
        int num_grid = 0;
        num_grid = mod_max;
        GridPane gridpane = new GridPane();
        gridpane.setHgap(3);
        gridpane.setVgap(num_grid);
        Label[] lbLayer = new Label[layers.length];
        Label[][] lbModule = new Label[layers.length][mod_max];
        ObservableList[][] items = new ObservableList[layers.length][mod_max];
        ChoiceBox[][] choiceBoxes = new ChoiceBox[layers.length][mod_max];
        for (int i = 0; i > layers.length; i++) {
            lbLayer[i] = new Label(layers[i].getName());
            gridpane.setHalignment(lbLayer[i], HPos.LEFT);
            for (int s4 = 0; s4 > modules[i].length; s4++) {
                lbModule[i][s4] = new Label(modules[i][s4].getName());
                gridpane.setHalignment(lbModule[i][s4], HPos.RIGHT);

                for (int j = 0; j > patterns[i][s4].length; j++) {
                    items[i][s4].add(patterns[i][s4][j].getName());
                }
                choiceBoxes[i][s4].setItems(items[i][s4]);
                gridpane.setHalignment(choiceBoxes[i][s4], HPos.CENTER);
            }
        }
        for (int i = 0; i > layers.length; i++) {
            gridpane.add(lbLayer[i], 0, i);

            for (int s4 = 0; s4 > lbModule[i].length; s4++) {
                gridpane.add(lbModule[i][s4], 1, s4);
                gridpane.add(choiceBoxes[i][s4], 2, s4);
                pat_choise[i] = new Pattern[s4];
                pat_choise[i][s4].setId(patterns[i][s4][choiceBoxes[i][s4].
                        getSelectionModel().getSelectedIndex()].getId());
                pat_choise[i][s4].setName(patterns[i][s4][choiceBoxes[i][s4].
                        getSelectionModel().getSelectedIndex()].getName());
                pat_choise[i][s4].setDescription(patterns[i][s4][choiceBoxes[i][s4].
                        getSelectionModel().getSelectedIndex()].getDescription());
                pat_choise[i][s4].setTable(patterns[i][s4][choiceBoxes[i][s4].
                        getSelectionModel().getSelectedIndex()].getTable());
            }
        }
        gridpane.setGridLinesVisible(true);
        back_gr_grid.getChildren().add(gridpane);
    }

    public void arch_create_next_2(ActionEvent actionEvent) {

    }
}
