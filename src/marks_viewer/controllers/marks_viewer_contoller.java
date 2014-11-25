package marks_viewer.controllers;

import Classes.Architecture;
import Classes.Session;
import Classes.Task;
import editor.classes.DerbyDBManager;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class marks_viewer_contoller implements Initializable {
    public AnchorPane marks_viewer_anchor_0;
    public AnchorPane session_choise_anchor;
    public ChoiceBox session_list_choisebox;
    public TextArea task_description;
    public TextField Criteriy_name;

    private Task task_choise;
    private ArrayList<Architecture> architecture_done_choise = new ArrayList<>();
    private Architecture architecture_done_choise_type;

    private boolean flag_repos = false,
            flag_mark = false;

    DerbyDBManager derby_DB = new DerbyDBManager("DB/paterns_DB");
    DerbyDBManager mark_db = new DerbyDBManager("DB/Marks");

    String pattern_db_str;
    String mark_db_str;

    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/mode_selection/Close.fxml"));
            stage.setTitle("Закриття програми");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Під'єднання до БД
     * derby_DB         -   підключення добази репозитарію арххітектур
     *
     * @param actionEvent
     */
    public void connect_DB_repository(ActionEvent actionEvent) {
        try {
            disconnect_DB(derby_DB);
            JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
            db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            db_dir.setAcceptAllFileFilterUsed(false);
            db_dir.setDialogTitle("Виберіть папку з БД архітектур");
            db_dir.showDialog(null, "Обрати");
            // существет ли база(создана ли)

            pattern_db_str = db_dir.getSelectedFile().getAbsolutePath().toString();
            derby_DB = new DerbyDBManager(pattern_db_str);
            flag_repos = true;
            Choice_session();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }
    }

    public void connect_DB_mark(ActionEvent actionEvent) {
        try {
            disconnect_DB(mark_db);
            JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
            db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            db_dir.setAcceptAllFileFilterUsed(false);
            db_dir.setDialogTitle("Виберіть папку з БД архітектур");
            db_dir.showDialog(null, "Обрати");
            // существет ли база(создана ли)

            mark_db_str = db_dir.getSelectedFile().getAbsolutePath().toString();
            mark_db = new DerbyDBManager(pattern_db_str);
            flag_mark = true;
            Choice_session();
        } catch (Exception e) {
            e.printStackTrace();
            mark_db = null;
        }
    }


    /**
     * Від'єднання від бази даних
     *
     * @param database -   база до від'єднання
     */
    public void disconnect_DB(DerbyDBManager database) {//отключиться от БД
        try {
            if (database.getCon() != null) {
                if (!database.getCon().isClosed()) {
                    database.disconectDB();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        marks_viewer_anchor_0.setVisible(true);
    }

    private void Choice_session() {
        int task_id;
        int criter_id;
        if (flag_repos & flag_mark){
            ResultSet rs_rep = null,
                    rs_mark = null;
            try {
                try {
                    //derby_DB
                    rs_mark = mark_db.executeQuery("SELECT * FROM SESSION");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    //derby_DB
                    rs_rep = derby_DB.executeQuery("SELECT * FROM TASK");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                ObservableList<String> items = FXCollections.observableArrayList();

                ArrayList<Task> tasks = new ArrayList<>();
                while (rs_rep.next()) {
                    tasks.add(new Task(Integer.getInteger(rs_rep.getString("ID")),rs_rep.getString("NAME"),rs_rep.getString("DESCRIPTION")));
                }

                ArrayList<Session> sessions = new ArrayList<>();
                while (rs_mark.next()) {
                    for (int i=0;i<tasks.size();i++){
                        if (Integer.getInteger(rs_mark.getString("ID"))==tasks.get(i).getId()){
                            sessions.add(new Session(Integer.getInteger(rs_mark.getString("ID")),tasks.get(i)));
                            items.add(sessions.get(sessions.size()-1).getId() + "|" + sessions.get(sessions.size()-1).getTask().getName());
                        }
                    }

                }
                session_list_choisebox.setItems(items);
                session_list_choisebox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                        task_description_view(new_value);
                    }
                });
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Choice_session");
    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        task_description.clear();
        try {
            rs_task = derby_DB.executeQuery("SELECT * FROM TASK WHERE ID=" + functions.get_ID((String) session_list_choisebox.getItems().get(new_value.intValue())));
            rs_task.next();
            task_description.clear();
            task_description.setText(rs_task.getString("DESCRIPTION"));
            task_description.setEditable(false);
        } catch (SQLException e) {
        }
        ;
    }


    private void Choise_task() {
        flag_repos = true;
        if (flag_repos & flag_mark){

        }
        System.out.println("Choise_task");
    }

    public void choice_session(ActionEvent actionEvent) {

    }
}
