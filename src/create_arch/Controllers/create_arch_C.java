package create_arch.Controllers;

import editor.services.draw_uml;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
import net.sourceforge.plantuml.project.Item;
import rating_arch.DB_manager;

import java.io.*;
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
    public MenuItem close;
    public VBox background;
    public ListView Arch_list;
    public TextArea Description;
    public ImageView Usecase_view;
    public Button arch_create_next_1;
    public Button Save_arch;
    public Button Arch_create_next_2;
    public Pane Arch_choise_1;
    public Pane Arch_choise_2;
    public Pane back_gr_grid;
    public Pane back_grid_vis;
    public Pane Arch_choise_3;
    @FXML
    private Image class_image;

    public static Architecture arc_choise = new Architecture();
    ArrayList<Label> layer_names = new ArrayList<>();
    ArrayList<javafx.scene.control.Label> module_names = new ArrayList<>();
    ArrayList<ChoiceBox> selected_paterns = new ArrayList<>();
    //public static Stage Primary_arch_create;
    ArrayList<Module> module_done = new ArrayList<>();
    ArrayList<Module> modules_done = new ArrayList<>();
    ArrayList<Layer> layers_done = new ArrayList<>();
    ArrayList<Architecture> architectures_done = new ArrayList<>();


    DB_manager derby_DB = new DB_manager("DB/paterns_DB");

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
            Arch_choise_1.setVisible(true);
            set_usecase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set_usecase() throws IOException, SQLException {
        Arch_choise_1.setVisible(true);
        Arch_choise_2.setVisible(false);
        Arch_choise_3.setVisible(false);
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
            //e.printStackTrace();
        }
    }

    public void canceler(ActionEvent actionEvent) {
    }

    public void select_to_display() {
        arc_choise=null;
        arc_choise = new Architecture();
        if (derby_DB != null) {
            Number num_choise_arch = Arch_list.getSelectionModel().selectedIndexProperty().getValue();
            ResultSet rs_arch;
            try {
                rs_arch = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + functions.get_ID((String) Arch_list.getItems().get(num_choise_arch.intValue())));
                rs_arch.next();
                arc_choise = new Architecture(rs_arch.getInt("ID"), rs_arch.getString("NAME"), rs_arch.getString("DESCRIPTION"));
            } catch (SQLException e) {
            }
            ;
            Description.setText(arc_choise.description);
            //Action_draw_class();
            class_image = draw_uml.draw_class(arc_choise.getUsecase());
            Usecase_view.setFitHeight(class_image.getRequestedHeight());
            Usecase_view.setFitWidth(class_image.getRequestedWidth());
            Usecase_view.setImage(class_image);
            Usecase_view.setImage(class_image);
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
        Arch_choise_1.setVisible(false);
        Arch_choise_2.setVisible(true);
        Arch_choise_3.setVisible(false);
        GridPane gridpane_lay = new GridPane();
        ArrayList<GridPane> gridPane_mod = new ArrayList<>();
        gridpane_lay.setHgap(2);
        gridpane_lay.setVgap(20);
        ResultSet rs_lay, rs_mod, rs_pat;
        int s_lay = 0, s_mod = 0;
        Label tmp_lable = new Label();
        try {
            rs_lay = derby_DB.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + arc_choise.getId());
            while (rs_lay.next()) {
                arc_choise.layers.add(new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                tmp_lable = new Label(rs_lay.getString("NAME"));
                GridPane.setHalignment(tmp_lable, HPos.CENTER);
                tmp_lable.setMinWidth(200);
                gridpane_lay.add(tmp_lable, 0, s_lay);
                rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                s_mod = 0;
                gridPane_mod.add(new GridPane());
                gridPane_mod.get(s_lay).getChildren().clear();
                gridPane_mod.get(s_lay).setHgap(2);
                gridPane_mod.get(s_lay).setVgap(20);
                while (rs_mod.next()) {
                    arc_choise.layers.get(s_lay).modules.add(new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    tmp_lable = new Label(rs_mod.getString("NAME"));
                    gridPane_mod.get(s_lay).setHalignment(tmp_lable, HPos.LEFT);
                    tmp_lable.setMinWidth(200);
                    gridPane_mod.get(s_lay).add(tmp_lable, 0, s_mod);
                    selected_paterns.add(s_mod, new ChoiceBox());
                    ObservableList<String> items = FXCollections.observableArrayList();
                    rs_pat = derby_DB.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        arc_choise.layers.get(s_lay).modules.get(s_mod).avilable_paterns.add(new Pattern(rs_pat.getInt("ID"), rs_pat.getInt("MOD_ID"), rs_pat.getString("NAME"), rs_pat.getString("DESCRIPTION"), rs_pat.getString("VALUE")));
                        items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                    }
                    selected_paterns.get(s_mod).setItems(items);
                    selected_paterns.get(s_mod).setPrefWidth(200);
                    GridPane.setHalignment(selected_paterns.get(s_mod), HPos.RIGHT);
                    gridPane_mod.get(s_lay).add(selected_paterns.get(s_mod), 1, s_mod);
                    s_mod++;
                }
                gridPane_mod.get(s_lay).setGridLinesVisible(true);
                GridPane.setHalignment(gridPane_mod.get(s_lay), HPos.RIGHT);
                gridpane_lay.add(gridPane_mod.get(s_lay), 1, s_lay);
                s_lay++;
            }
        } catch (SQLException e) {
        }
        gridpane_lay.setGridLinesVisible(true);
        gridpane_lay.setPadding(new Insets(20, 5, 20, 5));
        back_gr_grid.getChildren().add(gridpane_lay);
    }

    public void arch_create_next_2(ActionEvent actionEvent) {
        Arch_choise_1.setVisible(false);
        Arch_choise_2.setVisible(false);
        Arch_choise_3.setVisible(true);
        ResultSet rs = null;
        module_done.clear();
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
                module_done.get(i).avilable_paterns.add(paterns);
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
                for (int j = 0; j < arc_choise.layers.size(); j++) {
                    if (arc_choise.layers.get(j).getId() == layer.getId()) {
                        for (int k = 0; k < arc_choise.layers.get(j).modules.size(); k++) {
                            if (arc_choise.layers.get(j).modules.get(k).getId() == modules.getId()) {
                                module_done.get(i).avilable_paterns.addAll(arc_choise.layers.get(j).modules.get(k).avilable_paterns);
                            }
                        }
                    }
                }
                module_done.get(i).setId(modules.getId());
                module_done.get(i).setLay_id(modules.getLay_id());
                module_done.get(i).setName(modules.getName());
            }
        }

        int num_mod_done = 0;
        modules_done.clear();
        for (int i = 0; i < module_done.size(); i++) {
            for (int j = 0; j < module_done.get(i).avilable_paterns.size(); j++) {
                modules_done.add(new Module());
                modules_done.get(num_mod_done).setId(module_done.get(i).getId());
                modules_done.get(num_mod_done).setName(module_done.get(i).getName());
                modules_done.get(num_mod_done).setLay_id(module_done.get(i).getLay_id());
                modules_done.get(num_mod_done).selected_patern = module_done.get(i).avilable_paterns.get(j);
                num_mod_done++;
            }
        }

        GridPane gridpane_lay = new GridPane();
        ArrayList<GridPane> gridPane_mod = new ArrayList<>();
        ArrayList<ArrayList<GridPane>> gridPanes_pat = new ArrayList<>();
        Label tmp_lable = new Label();
        gridpane_lay.setHgap(2);
        gridpane_lay.setVgap(arc_choise.layers.size());
        for (int i=0; i<arc_choise.layers.size();i++){
            tmp_lable = new Label(arc_choise.layers.get(i).getName());
            tmp_lable.setMinWidth(150);
            gridpane_lay.add(tmp_lable, 0, i);
            gridPane_mod.add(new GridPane());
            gridPane_mod.get(i).getChildren().clear();
            gridPane_mod.get(i).setHgap(2);
            gridPane_mod.get(i).setVgap(arc_choise.layers.get(i).modules.size());
            gridPanes_pat.add(new ArrayList());
            for (int j=0; j<arc_choise.layers.get(i).modules.size();j++){
                tmp_lable = new Label(arc_choise.layers.get(i).modules.get(j).getName());
                tmp_lable.setMinWidth(150);
                gridPane_mod.get(i).add(tmp_lable, 0, j);
                gridPanes_pat.get(i).add(new GridPane());
                gridPanes_pat.get(i).get(j).getChildren().clear();
                gridPanes_pat.get(i).get(j).setHgap(2);
                gridPanes_pat.get(i).get(j).setVgap(arc_choise.layers.get(i).modules.get(j).avilable_paterns.size());
                int com=0;
                for (int k=0; k<module_done.size();k++){
                    if (module_done.get(k).getId()==arc_choise.layers.get(i).modules.get(j).getId()){
                        for (int m=0;m<module_done.get(k).avilable_paterns.size();m++){
                            tmp_lable = new Label(module_done.get(k).avilable_paterns.get(m).getName());
                            tmp_lable.setMinWidth(150);
                            gridPanes_pat.get(i).get(j).add(tmp_lable, 0, com);
                            tmp_lable = new Label(module_done.get(k).avilable_paterns.get(m).getDescription());
                            tmp_lable.setMinWidth(150);
                            gridPanes_pat.get(i).get(j).add(tmp_lable,1,com);
                            com++;
                        }
                    }
                }
                gridPane_mod.get(i).setGridLinesVisible(true);
                gridPane_mod.get(i).setPadding(new Insets(20, 5, 20, 5));
                gridPane_mod.get(i).add(gridPanes_pat.get(i).get(j),1,j);
            }
            gridpane_lay.add(gridPane_mod.get(i),1,i);
        }

        int num_lay_done = 0;
        for (int i =0; i<arc_choise.layers.size(); i++){
            for (int j=0; j<module_done.size();j++){
                if (modules_done.get(j).getLay_id()==arc_choise.layers.get(i).getId()){

                }
            }
        }
        gridpane_lay.setGridLinesVisible(true);
        gridpane_lay.setPadding(new Insets(20, 5, 20, 5));
        back_grid_vis.getChildren().add(gridpane_lay);
    }

    public void Save_arch(ActionEvent actionEvent) {


    }
}
