package src.controllers;

import Classes.Criterion;
import editor.services.functions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import src.functions.EditingCell;
import editor.classes.DerbyDBManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import src.functions.OperateFunc;
import src.functions.Property;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class CriterionController implements Initializable {
    private static OperateFunc operateFunc = new OperateFunc();
    public AnchorPane anchorCriterionViewerTaskChoice;
    public ChoiceBox taskListChoiceBox;
    public TextArea taskDescriptionTextField;

    public AnchorPane anchorCriterionViewerCriterionMatrix;
    public AnchorPane criteronMatrix;

    private boolean flag_repos = false,     //  Флаг на выбраную и считаную базу патернов
            flag_mark = false;              //  Флаг на выбраную и считаную базу оценок

    DerbyDBManager derby_DB; //= new DerbyDBManager("DB/paterns_DB");
    DerbyDBManager mark_db; // = new DerbyDBManager("DB/Marks");

    String pattern_db_str;      //  Путь к базе патернов    -   относительный
    String mark_db_str;         //  Путь к базе оценок

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

    /**
     * Під'єднання до БД
     * derby_DB         -   підключення добази репозитарію арххітектур
     *
     * @param actionEvent
     */
    public void connect_DB_repository(ActionEvent actionEvent) {
        try {
            if (derby_DB != null) {
                disconnect_DB(derby_DB);
            }
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
        try {
            taskChoicer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connect_DB_mark(ActionEvent actionEvent) {
        try {
            if (mark_db != null) {
                disconnect_DB(mark_db);
            }

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

            }
        } catch (Exception e) {
            e.printStackTrace();
            mark_db = null;
        }
        try {
            operateFunc.loadDataMark(mark_db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setVisible(AnchorPane anchorPane) {
        anchorCriterionViewerCriterionMatrix.setVisible(false);
        anchorCriterionViewerTaskChoice.setVisible(false);

        anchorPane.setVisible(true);
    }


    public void set_wieght(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Exit(ActionEvent actionEvent) {
    }

    public void GoBack_main(ActionEvent actionEvent) {

    }

    private void criterionChoicer() {
        setVisible(anchorCriterionViewerCriterionMatrix);
        Criterion criterion;
        Label criterionLabel = new Label();
        Label criterionMark = new Label();
        int xPos1 = 40,
                xPos2 = 250,
                yPos = 15;

        criterionLabel.setText("Критерій");
        criterionLabel.setLayoutY(yPos);
        criterionLabel.setLayoutX(xPos1);
        criterionLabel.setFont(Font.font(15));
        criterionMark.setText("Вагове значення");
        criterionMark.setLayoutY(yPos);
        criterionMark.setLayoutX(xPos2);
        criterionMark.setFont(Font.font(15));

        criteronMatrix.getChildren().clear();
        criteronMatrix.getChildren().add(criterionLabel);
        criteronMatrix.getChildren().add(criterionMark);

        for (Criterion criterion1 : Criterion.values()) {
            yPos += 35;
            criterionLabel = new Label();
            criterionLabel.setText(criterion1.getCriterion());
            criterionLabel.setLayoutY(yPos);
            criterionLabel.setLayoutX(xPos1);
            criterionLabel.setFont(Font.font(12));
            TextField critMark = new TextField();
            critMark.setLayoutY(yPos);
            critMark.setLayoutX(xPos2);

            criteronMatrix.getChildren().add(criterionLabel);
            criteronMatrix.getChildren().add(critMark);
        }
    }

    private void taskChoicer() throws SQLException {
        setVisible(anchorCriterionViewerTaskChoice);
        ResultSet rs;
        //derby_DB
        rs = derby_DB.executeQuery("SELECT * FROM TASK");

        ObservableList<String> items = FXCollections.observableArrayList();

        while (rs.next()) {
            //System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
            items.add(rs.getString("ID") + "|" + rs.getString("NAME"));
        }
        taskListChoiceBox.setItems(items);
        taskListChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                task_description_view(new_value);
            }
        });
    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        taskDescriptionTextField.clear();
        try {
            rs_task = derby_DB.executeQuery("SELECT * FROM TASK WHERE ID=" + functions.get_ID(
                    (String) taskListChoiceBox.getItems().get(new_value.intValue())));
            rs_task.next();
            taskDescriptionTextField.clear();
            taskDescriptionTextField.setText(rs_task.getString("DESCRIPTION"));
            taskDescriptionTextField.setEditable(false);
        } catch (SQLException e) {
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

    public void backButtonTaskVeiwer(ActionEvent actionEvent) {
    }

    public void choiceButtonTaskVeiwer(ActionEvent actionEvent) {
        criterionChoicer();
    }

    public void backButtonCriterinMatrix(ActionEvent actionEvent) {
    }

    public void choiceButtonCriterinMatrix(ActionEvent actionEvent) {

    }
}
