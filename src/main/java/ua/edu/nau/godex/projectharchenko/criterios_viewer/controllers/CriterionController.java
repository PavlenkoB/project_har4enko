package ua.edu.nau.godex.projectharchenko.criterios_viewer.controllers;

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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import ua.edu.nau.godex.projectharchenko.classes.Task;
import ua.edu.nau.godex.projectharchenko.criterios_viewer.functions.OperateFunc;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.RepEditorFunctions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class CriterionController implements Initializable {

    protected static ua.edu.nau.godex.projectharchenko.criterios_viewer.functions.CVDbWorker CVDbWorker = ua.edu.nau.godex.projectharchenko.criterios_viewer.functions.CVDbWorker.getInstance();
    protected static OperateFunc operateFunc = OperateFunc.getInstance();
    private static Logger logger = Logger.getLogger(CriterionController.class.getClass());
    public AnchorPane anchorCriterionViewerTaskChoice;
    public AnchorPane anchorCriterionViewerCriterionMatrix;
    public ChoiceBox taskListChoiceBox;
    public TextArea taskDescriptionTextField;
    public AnchorPane criterionMatrix;
    public ScrollPane criterionMatrixScrollPane;
    public AnchorPane anchorCriterionViewerArchMarksByCriterionMatrix;
    public AnchorPane anchorCriterionViewerComplexMarkViewer;
    public AnchorPane archMarksByCriterionMatrix;
    public AnchorPane complexMarkViewer;

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
            root = FXMLLoader.load(getClass().getResource("/views/mode_selection/Close.fxml"));
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

        if (CVDbWorker.readyToWork()) {
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
                if (task.getId().equals(RepEditorFunctions.get_ID((String) taskListChoiceBox.getItems().get(new_value.intValue())))) {
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
        anchorCriterionViewerArchMarksByCriterionMatrix.setVisible(false);
        anchorCriterionViewerComplexMarkViewer.setVisible(false);
    }

    public void connect_DB_repository(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД архітектур");
        db_dir.showDialog(null, "Обрати");

        CVDbWorker.connectionToArchDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        operateFunc.setTaskList(CVDbWorker.getTaskList());
        startRating();
    }

    public void connect_DB_mark(ActionEvent actionEvent) {
        JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
        db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        db_dir.setAcceptAllFileFilterUsed(false);
        db_dir.setDialogTitle("Виберіть папку з БД оцінок");
        db_dir.showDialog(null, "Обрати");

        CVDbWorker.connectionToMarkDb(db_dir.getSelectedFile().getAbsolutePath().toString());
        //operateFunc.setSessionsList(RADbWorker.getSessionList());
        startRating();
    }

    public void choiceButtonTaskViewer(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerCriterionMatrix.setVisible(true);

        if (operateFunc.getTasks() != null) {
            for (Task task : operateFunc.getTasks()) {
                if (task.getId().equals(RepEditorFunctions.get_ID(taskListChoiceBox.getSelectionModel().getSelectedItem().toString()))) {
                    operateFunc.setTaskChoice(task);
                    break;
                }
            }
        }
        operateFunc.setSessionsList(CVDbWorker.getSessionListByTask(operateFunc.getTaskChoice()));
        GridPane gridPaneCriterion = SubController.gridPaneCriterionMatrixRating();

        criterionMatrix.getChildren().clear();
        criterionMatrix.getChildren().add(gridPaneCriterion);
    }

    public void backButtonCriterionMatrix(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerTaskChoice.setVisible(true);
    }

    public void choiceButtonCriterionMatrix(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerArchMarksByCriterionMatrix.setVisible(true);

        GridPane gridPaneArchitectureCriterion = SubController.gridPaneArchitectureCriterion();
        archMarksByCriterionMatrix.getChildren().clear();
        archMarksByCriterionMatrix.getChildren().add(gridPaneArchitectureCriterion);
    }

    public void backButtonArchMarksByCriterionMatrix(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerCriterionMatrix.setVisible(true);
    }

    public void choiceButtonArchMarksByCriterionMatrix(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerComplexMarkViewer.setVisible(true);
        operateFunc.calculateComplexMarks();

        GridPane gridPane = SubController.gridPaneArchitectureComplexMark();
        complexMarkViewer.getChildren().clear();
        complexMarkViewer.getChildren().add(gridPane);
    }

    public void backButtonComplexMarkViewer(ActionEvent actionEvent) {
        setAllAnchorsVisibleFalse();
        anchorCriterionViewerArchMarksByCriterionMatrix.setVisible(true);
    }
}
