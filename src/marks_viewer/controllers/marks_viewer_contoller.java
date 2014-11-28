package marks_viewer.controllers;

import Classes.*;
import create_arch.Controllers.preview_create_arch_C;
import editor.classes.DerbyDBManager;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.util.calendar.BaseCalendar;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public AnchorPane mark_view_matrix;
    public AnchorPane marks_matrix;

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();
    private Session session_choice = new Session();
    private Architecture architecture_done_choice_type;

    private boolean flag_repos = false,
            flag_mark = false;

    DerbyDBManager derby_DB; //= new DerbyDBManager("DB/paterns_DB");
    DerbyDBManager mark_db; // = new DerbyDBManager("DB/Marks");

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
            //Choice_session();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }
        ResultSet rs_rep = null,
                rs_arch = null,
                rs_lay = null,
                rs_mod = null,
                rs_pat = null;
        if (flag_repos) {
            try {
                //derby_DB
                rs_rep = derby_DB.executeQuery("SELECT * FROM TASK");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                while (rs_rep.next()) {
                    ArrayList<Architecture> architecture_done = new ArrayList<>();
                    rs_arch = null;
                    rs_arch = derby_DB.executeQuery("SELECT * FROM ARCH_DONE WHERE TASK_ID=" + rs_rep.getInt("ID"));
                    while (rs_arch.next()) {
                        ArrayList<Layer> layers = new ArrayList<>();
                        rs_lay = null;
                        rs_lay = derby_DB.executeQuery("SELECT * FROM LAY_DONE WHERE ARCH_DONE_ID=" + rs_arch.getInt("ID"));
                        while (rs_lay.next()) {
                            ArrayList<Module> modules = new ArrayList<>();
                            rs_mod = null;
                            rs_mod = derby_DB.executeQuery("SELECT * FROM MODULE_DONE WHERE LAY_DONE_ID=" + rs_lay.getInt("LAY_ID"));
                            while (rs_mod.next()) {
                                modules.add(new Module(rs_mod.getInt("MOD_ID"), rs_lay.getInt("LAY_ID"), "", "", rs_mod.getInt("ID")));
                                modules.get(modules.size() - 1).setSelected_pattern(Pattern.patternLoadFromDB(rs_mod.getInt("PATTERN_ID"), derby_DB));
                            }
                            layers.add(new Layer(rs_lay.getInt("LAY_ID"), rs_lay.getInt("ARCH_DONE_ID"), "", "", rs_lay.getInt("ID"), modules));
                        }
                        architecture_done.add(new Architecture(rs_arch.getInt("ARCH_ID"), "", layers, "", rs_arch.getInt("ID"), rs_rep.getInt("ID")));
                    }
                    tasks.add(new Task(rs_rep.getInt("ID"), rs_rep.getString("NAME"), rs_rep.getString("DESCRIPTION"), architecture_done));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Choice_session();
        }
    }

    public void connect_DB_mark(ActionEvent actionEvent) {
        try {
            disconnect_DB(mark_db);
            JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
            db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            db_dir.setAcceptAllFileFilterUsed(false);
            db_dir.setDialogTitle("Виберіть папку з БД оцінок");
            db_dir.showDialog(null, "Обрати");
            // существет ли база(создана ли)

            mark_db_str = db_dir.getSelectedFile().getAbsolutePath().toString();
            mark_db = new DerbyDBManager(mark_db_str);
            flag_mark = true;
            if (flag_mark) {
                ResultSet rs_sess = null;
                try {
                    //derby_DB
                    rs_sess = mark_db.executeQuery("SELECT * FROM SESSION");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (rs_sess.next()) {
                    ArrayList<Mark> marks = new ArrayList<>();
                    ResultSet rs_mark = null;
                    rs_mark = mark_db.executeQuery("SELECT * FROM MARK WHERE SESSION_ID =" + rs_sess.getInt("ID"));
                    while (rs_mark.next()) {
                        marks.add(new Mark(rs_mark.getInt("ID"), rs_mark.getInt("ARCH_1_ID"), rs_mark.getInt("ARCH_2_ID"), rs_mark.getInt("MARK")));
                    }
                    sessions.add(new Session(rs_sess.getInt("ID"), rs_sess.getInt("TASK_ID"), marks));
                }
                Choice_session();
            }
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
            if (database != null) {
                if (database.getCon() != null) {
                    if (!database.getCon().isClosed()) {
                        database.disconectDB();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        marks_viewer_anchor_0.setVisible(true);
        mark_view_matrix.setVisible(false);

        ////////////////////date
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Date d = new Date();
        System.out.println(format1.format(d)); //25.02.2013 09:03
        float df = d.getTime();
        d = new Date((long)df);
        System.out.println("float " + format1.format(d)); //25.02.2013 09:03
        long dl = d.getTime();
        d = new Date(dl);
        System.out.println(dl);
        System.out.println("long " + format1.format(d)); //25.02.2013 09:03

}

    private void Choice_session() {
        int task_id;
        int criter_id;
        if (flag_repos & flag_mark) {
            for (int i = 0; i < sessions.size(); i++) {
                for (int j = 0; j < tasks.size(); j++) {
                    if (sessions.get(i).getTask_id() == tasks.get(j).getId()) {
                        sessions.get(i).setTask(tasks.get(j));
                    }
                }
            }

            ObservableList<String> items = FXCollections.observableArrayList();
            for (int i = 0; i < sessions.size(); i++) {
                items.add(sessions.get(i).getId() + "|" + sessions.get(i).getTask().getName());
            }
            session_list_choisebox.setItems(items);
            session_list_choisebox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                    task_description_view(new_value);
                }
            });
        }
        System.out.println("Choice_session");
    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        task_description.clear();
        task_description.clear();
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId() == functions.get_ID((String) session_list_choisebox.getItems().get(new_value.intValue()))) {
                task_description.setText(sessions.get(i).getTask().getDescription());
                task_description.setEditable(false);
            }
        }
        ;
    }

    public void choice_session(final ActionEvent actionEvent) {
        marks_viewer_anchor_0.setVisible(false);
        mark_view_matrix.setVisible(true);

        session_choice.setId(functions.get_ID((String) session_list_choisebox.getSelectionModel().getSelectedItem().toString()));
        for (int i = 0; i < sessions.size(); i++) {
            if (session_choice.getId() == sessions.get(i).getId()) {
                session_choice = sessions.get(i);
                //new Session(sessions.get(i).getId(), sessions.get(i).getTask(), sessions.get(i).getCriteriy(), sessions.get(i).getTask_id(), sessions.get(i).getMarks());
                derby_DB = new DerbyDBManager(pattern_db_str);
                architecture_done_choice_type = Architecture.arch_load_from_DB(session_choice.getTask().getArchitectures().get(0).getId(), derby_DB);
            }
        }

        for (int i = 0; i<session_choice.getTask().getArchitectures().size();i++){
            session_choice.getTask().getArchitectures().get(i).setId(architecture_done_choice_type.getId());
            session_choice.getTask().getArchitectures().get(i).setDescription(architecture_done_choice_type.getDescription());
            session_choice.getTask().getArchitectures().get(i).setName(architecture_done_choice_type.getName());
            for (int j =0; j<session_choice.getTask().getArchitectures().get(i).getLayers().size();j++){
                for (int h=0; h<architecture_done_choice_type.getLayers().size();h++) {
                    if (session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getId() == architecture_done_choice_type.getLayers().get(h).getId()) {
                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).setName(architecture_done_choice_type.getLayers().get(h).getName());
                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).setDescription(architecture_done_choice_type.getLayers().get(h).getDescription());
                        for (int p =0 ;p<session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getModules().size();p++) {
                            for (int ly = 0; ly < architecture_done_choice_type.getLayers().size(); ly++) {
                                for (int l = 0; l < architecture_done_choice_type.getLayers().get(ly).getModules().size(); l++) {
                                    if (session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getModules().get(p).getId() == architecture_done_choice_type.getLayers().get(ly).getModules().get(l).getId()) {
                                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getModules().get(p).setName(architecture_done_choice_type.getLayers().get(ly).getModules().get(l).getName());
                                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getModules().get(p).setDescription(architecture_done_choice_type.getLayers().get(ly).getModules().get(l).getDescription());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        int hsize = session_choice.getTask().getArchitectures().size() + 1;
        int vsize = session_choice.getTask().getArchitectures().size() + 1;

        Label label_task_id_name = new Label();
        label_task_id_name.setText("Завдання : " + session_choice.getTask().getId().toString() + "|" + session_choice.getTask().getName());
        label_task_id_name.setLayoutX(50);
        label_task_id_name.setLayoutY(20);
        label_task_id_name.setFont(Font.font(16));
        marks_matrix.getChildren().add(label_task_id_name);

        Label label_session_id = new Label();
        label_session_id.setText("Сесія : " + session_choice.getId());
        label_session_id.setLayoutX(220);
        label_session_id.setLayoutY(20);
        label_session_id.setFont(Font.font(16));
        marks_matrix.getChildren().add(label_session_id);

        Label criteriy = new Label();
        criteriy.setText("Критерій : ");//+ session_choice.getCriteriy().getName());
        criteriy.setLayoutX(350);
        criteriy.setLayoutY(20);
        criteriy.setFont(Font.font(16));
        marks_matrix.getChildren().add(criteriy);

        ArrayList<Button> archery_open_button_ver = new ArrayList<>();
        ArrayList<Button> archery_open_button_hor = new ArrayList<>();

        GridPane gridPane_mark = new GridPane();
        gridPane_mark.getChildren().clear();
        gridPane_mark.setHgap(hsize);
        gridPane_mark.setVgap(vsize);
        gridPane_mark.setPadding(new Insets(10, 10, 10, 10));
        gridPane_mark.setBorder(Border.EMPTY);

        Label arch_label = new Label();
        arch_label.setText("Архітектура");
        gridPane_mark.add(arch_label,0,0);

        for (int i = 0; i < session_choice.getTask().getArchitectures().size(); i++) {
            archery_open_button_hor.add(new Button("arch: " + (i+1)));
            archery_open_button_ver.add(new Button("arch: " + (i+1)));
            gridPane_mark.add(archery_open_button_hor.get(archery_open_button_hor.size()-1),0,i+1);
            gridPane_mark.add(archery_open_button_ver.get(archery_open_button_ver.size()-1),i+1,0);
        }
        ArrayList<Label> labels_marks = new ArrayList<>();
        for (int i=0; i<session_choice.getMarks().size();i++){
            labels_marks.add(new Label(session_choice.getMarks().get(i).getMark().toString()));
            gridPane_mark.add(labels_marks.get(labels_marks.size()-1),session_choice.getMarks().get(i).getNum_arch_1(),session_choice.getMarks().get(i).getNum_arch_0());
        }
        for (int i =0; i<archery_open_button_hor.size();i++) {
            final int finalI = i;
            archery_open_button_hor.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    Stage preview_view = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/marks_viewer/view_fxml/preview.fxml"));

                    Stage stage = new Stage(StageStyle.DECORATED);
                    try {
                        stage.setScene(new Scene((Pane) loader.load()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    preview controller = loader.<preview>getController();
                    ;
                    controller.initData(session_choice.getTask().getArchitectures().get(finalI));
                    stage.setTitle("Візуалізація рхітектури " + finalI);
                    stage.show();
                    choice_session(actionEvent);
                }
            });
        }

        gridPane_mark.setLayoutY(40);
        gridPane_mark.setLayoutX(20);
        marks_matrix.getChildren().add(gridPane_mark);



    }
}
