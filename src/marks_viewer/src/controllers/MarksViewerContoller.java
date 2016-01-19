package src.controllers;

import Classes.Architecture;
import Classes.Session;
import Classes.Task;
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
import org.apache.log4j.Logger;
import src.function.DbWorker;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 * Просмоторщик результатов оценок
 *
 * @author Alx Shcherbak
 * @see javafx.fxml.Initializable
 */
public class MarksViewerContoller implements Initializable {
    public AnchorPane marks_viewer_anchor_0;
    public AnchorPane session_choise_anchor;
    public ChoiceBox session_list_choisebox;
    public TextArea task_description;
    public TextField Criteriy_name;
    public AnchorPane mark_view_matrix;
    public AnchorPane marks_matrix;
    public TextField dateTextField;
    public TextField Note_field;
    public Button cancelButton;

    private static Logger logger = Logger.getLogger(MarksViewerContoller.class);

    private List<Task> tasks = new ArrayList<>();          //  Массив заданий
    private List<Session> sessions = new ArrayList<>();    //  Массив сессий
    private Session session_choice = new Session();             //  Вибрана сессия для просмотра оценок с массива sessions
    private Architecture architecture_done_choice_type;         //  Тип выбраной архитектуры

    /**
     *
     */
    protected DbWorker dbWorker = DbWorker.getInstance();

    /**
     * Метод закрытия окна программы, через вызовов диалогового окна
     *
     * @param actionEvent -   Нажатие на кноку "Вихід"
     * @throws IOException
     */
    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/src/view_fxml/Close.fxml"));
            stage.setTitle("Завершити програму");
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
    public void connectRepositoryDB(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД архітектур");
        db_dir.showDialog(null, "Обрати");

        dbWorker.connectionToArchDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        tasks = dbWorker.getTaskList();
        choiceSession();
    }

    /**
     *
     * @param actionEvent
     */
    public void connect_DB_mark(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД оцінок");
        db_dir.showDialog(null, "Обрати");

        dbWorker.connectionToMarkDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        sessions = dbWorker.getSessionList();
        choiceSession();
    }

    /**
     *
     */
    protected void visibleFalseToAllAnchors() {
        marks_viewer_anchor_0.setVisible(false);
        mark_view_matrix.setVisible(false);
    }

    /**
     *
     * @return
     */
    private boolean isCloseWindows() {
        return mark_view_matrix == null || marks_viewer_anchor_0 == null;
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!isCloseWindows()) {
            visibleFalseToAllAnchors();
            marks_viewer_anchor_0.setVisible(true);
        }
    }

    /**
     *
     */
    private void choiceSession() {
        if (dbWorker.readyToWork()) {
            for (int i = 0; i < sessions.size(); i++) {
                for (int j = 0; j < tasks.size(); j++) {
                    if (sessions.get(i).getTaskId() == tasks.get(j).getId()) {
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
    }

    /**
     *
     * @param new_value
     */
    private void task_description_view(Number new_value) {
        task_description.clear();
        Note_field.clear();
        dateTextField.clear();
        Criteriy_name.clear();
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId() == functions.get_ID((String) session_list_choisebox.getItems().get(new_value.intValue()))) {
                Note_field.setText(sessions.get(i).getNote());
                Note_field.setEditable(false);
                task_description.setText(sessions.get(i).getTask().getDescription());
                task_description.setEditable(false);
                SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                dateTextField.setText(format1.format(sessions.get(i).getDate()));
                Criteriy_name.setText(sessions.get(i).getCriterion().name());
                Criteriy_name.setEditable(false);
            }
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void choice_session(final ActionEvent actionEvent) {
        visibleFalseToAllAnchors();
        marks_matrix.getChildren().clear();
        mark_view_matrix.setVisible(true);

        session_choice.setId(functions.get_ID((String) session_list_choisebox.getSelectionModel().getSelectedItem().toString()));
        for (int i = 0; i < sessions.size(); i++) {
            if (session_choice.getId() == sessions.get(i).getId()) {
                session_choice = sessions.get(i);
                architecture_done_choice_type = dbWorker.getArchitectureType(session_choice.getTask().getArchitectures().get(0));

            }
        }

        for (int i = 0; i < session_choice.getTask().getArchitectures().size(); i++) {
            session_choice.getTask().getArchitectures().get(i).setId(architecture_done_choice_type.getId());
            session_choice.getTask().getArchitectures().get(i).setDescription(architecture_done_choice_type.getDescription());
            session_choice.getTask().getArchitectures().get(i).setName(architecture_done_choice_type.getName());
            for (int j = 0; j < session_choice.getTask().getArchitectures().get(i).getLayers().size(); j++) {
                for (int h = 0; h < architecture_done_choice_type.getLayers().size(); h++) {
                    if (session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getId() == architecture_done_choice_type.getLayers().get(h).getId()) {
                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).setName(architecture_done_choice_type.getLayers().get(h).getName());
                        session_choice.getTask().getArchitectures().get(i).getLayers().get(j).setDescription(architecture_done_choice_type.getLayers().get(h).getDescription());
                        for (int p = 0; p < session_choice.getTask().getArchitectures().get(i).getLayers().get(j).getModules().size(); p++) {
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
        label_task_id_name.setLayoutY(40);
        label_task_id_name.setFont(Font.font(16));
        marks_matrix.getChildren().add(label_task_id_name);

        Label label_session_id = new Label();
        label_session_id.setText("Сесія : " + session_choice.getId());
        label_session_id.setLayoutX(50);
        label_session_id.setLayoutY(20);
        label_session_id.setFont(Font.font(16));
        marks_matrix.getChildren().add(label_session_id);

        Label criteriy = new Label();
        criteriy.setText("Критерій : " + session_choice.getCriterion().getCriterion());
        criteriy.setLayoutX(400);
        criteriy.setLayoutY(40);
        criteriy.setFont(Font.font(16));
        marks_matrix.getChildren().add(criteriy);

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Label dateLabel = new Label();
        dateLabel.setText("Дата : " + format1.format(session_choice.getDate()));
        dateLabel.setLayoutX(150);
        dateLabel.setLayoutY(20);
        dateLabel.setFont(Font.font(16));
        marks_matrix.getChildren().add(dateLabel);

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
        gridPane_mark.add(arch_label, 0, 0);

        for (int i = 0; i < session_choice.getTask().getArchitectures().size(); i++) {
            archery_open_button_hor.add(new Button("arch: " + (i + 1)));
            archery_open_button_ver.add(new Button("arch: " + (i + 1)));
            gridPane_mark.add(archery_open_button_hor.get(archery_open_button_hor.size() - 1), i + 1, 0);
            gridPane_mark.add(archery_open_button_ver.get(archery_open_button_ver.size() - 1), 0, i + 1);
        }
        ArrayList<Label> labels_marks = new ArrayList<>();
        for (int i = 0; i < session_choice.getMarks().size(); i++) {
            labels_marks.add(new Label(session_choice.getMarks().get(i).getMark().toString()));
            gridPane_mark.add(labels_marks.get(labels_marks.size() - 1), (session_choice.getMarks().get(i).getNumArch1()
                    - session_choice.getMarks().get(0).getNumArch0() + 1), (session_choice.getMarks().get(i).getNumArch0() - session_choice.getMarks().get(0).getNumArch0() + 1));
        }


        /**
         *
         */
        class EventHandlerViewPreviewImpl implements EventHandler<ActionEvent> {
            final int finalI;

            public EventHandlerViewPreviewImpl(int finalI) {
                this.finalI = finalI;
            }

            @Override
            public void handle(javafx.event.ActionEvent e) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/view_fxml/preview.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                try {
                    stage.setScene(new Scene((Pane) loader.load()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Preview controller = loader.<Preview>getController();
                controller.initData(session_choice.getTask().getArchitectures().get(finalI));
                stage.setTitle("Візуалізація архітектури " + (finalI + 1));
                stage.show();
                choice_session(actionEvent);
            }
        }

        for (int i = 0; i < archery_open_button_hor.size(); i++) {
            archery_open_button_hor.get(i).setOnAction(new EventHandlerViewPreviewImpl(i));
        }
        for (int i = 0; i < archery_open_button_ver.size(); i++) {
            archery_open_button_ver.get(i).setOnAction(new EventHandlerViewPreviewImpl(i));
        }

        gridPane_mark.setLayoutY(60);
        //gridPane_mark.setGridLinesVisible(true);
        gridPane_mark.setLayoutX(20);
        marks_matrix.getChildren().add(gridPane_mark);


    }

    /**
     *
     * @param actionEvent
     */
    public void Session_choise(ActionEvent actionEvent) {
        marks_viewer_anchor_0.setVisible(true);
        mark_view_matrix.setVisible(false);
    }

    /**
     *
     * @param actionEvent
     */
    public void goBackMain(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    /**
     *
     * @param actionEvent
     */
    public void exit(ActionEvent actionEvent) {
        dbWorker.disconnectAll();
        try {
            wait(500l);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.exit(1);
    }
}
