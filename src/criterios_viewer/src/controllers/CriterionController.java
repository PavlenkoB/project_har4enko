package src.controllers;

import Classes.Task;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import src.functions.DBWorker;
import src.functions.OperateFunc;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class CriterionController implements Initializable {

    private static Logger logger = Logger.getLogger(CriterionController.class.getClass());
    protected static DBWorker dbWorker = DBWorker.getInstance();
    protected static OperateFunc operateFunc = OperateFunc.getInstance();


    public AnchorPane anchorCriterionViewerTaskChoice;
    public AnchorPane anchorCriterionViewerCriterionMatrix;
    public ChoiceBox taskListChoiceBox;
    public TextArea taskDescriptionTextField;
    public AnchorPane criterionMatrix;

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
            root = FXMLLoader.load(getClass().getResource("/mode_selection/Close.fxml"));
            stage.setTitle("Завершити програму");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void startRating() {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerTaskChoice.setVisible(true);

        if (dbWorker.readyToWork()) {
            ObservableList<String> items = FXCollections.observableArrayList();
            if (operateFunc.getTasks() != null) {
                for (Task task : operateFunc.getTasks()) {
                    items.add(task.getId() + "|" + task.getName());
                }
            }

            taskListChoiceBox.setItems(items);
            taskListChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                    taskDescriptionView(new_value);
                }
            });
        }
    }

    protected void taskDescriptionView(Number new_value) {
        taskDescriptionTextField.clear();
        if (operateFunc.getTasks() != null) {
            for (Task task : operateFunc.getTasks()) {
                if (task.getId().equals(functions.get_ID((String) taskListChoiceBox.getItems().get(new_value.intValue())))) {
                    taskDescriptionTextField.setEditable(true);
                    taskDescriptionTextField.setText(task.getDescription());
                    taskDescriptionTextField.setEditable(false);
                    break;
                }
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!isCloseWindows()) {
            setAllAnchorsVisibleFalse();
            startRating();
        }
    }

    protected boolean isCloseWindows() {
        return anchorCriterionViewerCriterionMatrix == null || anchorCriterionViewerTaskChoice == null;
    }

    protected void setAllAnchorsVisibleFalse() {
        anchorCriterionViewerCriterionMatrix.setVisible(false);
        anchorCriterionViewerTaskChoice.setVisible(false);
    }

    public void connect_DB_repository(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД архітектур");
        db_dir.showDialog(null, "Обрати");

        dbWorker.connectionToArchDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        operateFunc.setTaskList(dbWorker.getTaskList());
        startRating();
    }

    public void connect_DB_mark(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД оцінок");
        db_dir.showDialog(null, "Обрати");

        dbWorker.connectionToMarkDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        operateFunc.setSessionsList(dbWorker.getSessionList());
        startRating();
    }

    public void backButtonTaskViewer(ActionEvent actionEvent) {
    }

    public void choiceButtonTaskViewer(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerCriterionMatrix.setVisible(true);

        if (operateFunc.getTasks() != null) {
            for (Task task : operateFunc.getTasks()) {
                if (task.getId().equals(functions.get_ID(taskListChoiceBox.getSelectionModel().getSelectedItem().toString()))) {
                    operateFunc.setTaskChoice(task);
                    break;
                }
            }
        }

        GridPane gridPaneCriterion = SubController.gridPaneCriterionMatrixRating();

        criterionMatrix.getChildren().clear();
        criterionMatrix.getChildren().add(gridPaneCriterion);
    }

    public void backButtonCriterionMatrix(ActionEvent actionEvent) {
    }

    public void choiceButtonCriterionMatrix(ActionEvent actionEvent) {
        List<CriterionMark> criterionMarkList = SubController.criterionMarksListFromTextFieldsMatrixList();

        GridPane gridPaneArchitectureCriterion = SubController.gridPaneArchitectureCriterion();
    }
}
