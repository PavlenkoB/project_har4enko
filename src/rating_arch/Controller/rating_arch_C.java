package rating_arch.Controller;

import Classes.Architecture;
import Classes.Task;
import editor.classes.DerbyDBManager;
import editor.services.arch_work;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class rating_arch_C implements Initializable {
    public AnchorPane Rating_arch_1;
    public ChoiceBox task_list;
    public TextArea task_description;
    public Button cancelButton;
    public Task task_choise;
    public ArrayList<Architecture> architecture_done_choise = new ArrayList<>();
    public Architecture architecture_done_choise_type;
    public ArrayList<ArrayList<Integer>> marks = new ArrayList<>();
    public ChoiceBox mark_crit;
    public AnchorPane mark;
    public AnchorPane Rating_arch_2;


    DerbyDBManager derby_DB = new DerbyDBManager("DB/paterns_DB");

    //Windows close dialog
    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/Close.fxml"));
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

    public void disconnect_DB(ActionEvent actionEvent) {
        if (derby_DB != null) {
            derby_DB.disconectDB();
            derby_DB = null;
        }
        ObservableList<String> items = FXCollections.observableArrayList();
    }
    //Windows close dialog

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Rating_arch_1.setVisible(true);
            Start_rating();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Start_rating() {
        Rating_arch_1.setVisible(true);
        Rating_arch_2.setVisible(false);
        ResultSet rs = null;
        try {
            try {
                //derby_DB
                rs = derby_DB.executeQuery("SELECT * FROM TASK");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<String> items = FXCollections.observableArrayList();

            while (rs.next()) {
                //System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
            }
            task_list.setItems(items);
            task_list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                    task_description_view(new_value);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        try {
            rs_task = derby_DB.executeQuery("SELECT * FROM TASK WHERE ID=" + functions.get_ID((String) task_list.getItems().get(new_value.intValue())));
            rs_task.next();
            task_description.clear();
            task_description.setText(rs_task.getString("DESCRIPTION"));
            task_description.setEditable(false);
        } catch (SQLException e) {
        }
        ;
    }

    public void back_to_mode_sel(ActionEvent actionEvent) {
    }

    public void choice_task(ActionEvent actionEvent) {
        Rating_arch_1.setVisible(false);
        Rating_arch_2.setVisible(true);
        ResultSet rs = null;
        task_choise = new Task();
        architecture_done_choise_type = new Architecture();

        try {
            rs = derby_DB.executeQuery("SELECT * FROM TASK WHERE ID=" + functions.get_ID(task_list.getSelectionModel().getSelectedItem().toString()));
            rs.next();
            task_choise.setId(rs.getInt("ID"));
            task_choise.setName(rs.getString("NAME"));
            task_choise.setDescription(rs.getString("DESCRIPTION"));

            rs = null;
            rs = derby_DB.executeQuery("SELECT * FROM ARCH_DONE WHERE TASK_ID=" + task_choise.getId());
            while (rs.next()) {
                architecture_done_choise.add(new Architecture(rs.getInt("ARCH_ID"), "", rs.getInt("ID"), task_choise.getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        architecture_done_choise_type = arch_work.arch_load_from_DB(architecture_done_choise.get(0).getId(), derby_DB);

        for (int i = 0; i < architecture_done_choise.size(); i++) {
            architecture_done_choise.get(i).setLayers(architecture_done_choise_type.getLayers());
            architecture_done_choise.get(i).setName(architecture_done_choise_type.getName());
            try {
                rs = derby_DB.executeQuery("SELECT * FROM LAY_DONE WHERE ARCH_DONE_ID=" + architecture_done_choise.get(i).getId_done());
                while (rs.next()) {
                    for (int j = 0; j < architecture_done_choise.get(i).getLayers().size(); j++) {
                        if (rs.getInt("LAY_ID") == architecture_done_choise.get(i).getLayers().get(j).getId()) {
                            architecture_done_choise.get(i).getLayers().get(j).setId_done(rs.getInt("ID"));
                        }
                    }
                }
                for (int j = 0; j < architecture_done_choise.get(i).getLayers().size(); j++) {
                    rs = null;
                    rs = derby_DB.executeQuery("SELECT * FROM MODULE_DONE WHERE LAY_DONE_ID=" + architecture_done_choise.get(i).getLayers().get(j).getId_done());
                    while (rs.next()) {
                        for (int k = 0; k < architecture_done_choise.get(i).getLayers().get(j).getModules().size(); k++) {
                            if (rs.getInt("MOD_ID") == architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getId()) {
                                architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).setId_done(rs.getInt("ID"));
                                for (int p = 0; p < architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_paterns().size(); p++) {
                                    if (architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_paterns().get(p).getId() == rs.getInt("PATTERN_ID")) {
                                        architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).setSelected_patern(architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_paterns().get(p));
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.print("lol");
        }
    }

    public void next_twise(ActionEvent actionEvent) {
    }

    public void mark_1(ActionEvent actionEvent) {
    }

    public void mark_2(ActionEvent actionEvent) {
    }

    public void mark_3(ActionEvent actionEvent) {
    }

    public void mark_4(ActionEvent actionEvent) {
    }

    public void mark_5(ActionEvent actionEvent) {
    }

    public void mark_6(ActionEvent actionEvent) {
    }

    public void mark_7(ActionEvent actionEvent) {
    }

    public void mark_8(ActionEvent actionEvent) {
    }

    public void mark_9(ActionEvent actionEvent) {
    }
}


