package src.controllers;

import Classes.Architecture;
import Classes.Criterion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;
import src.functions.CriterionMark;
import src.functions.DBWorker;
import src.functions.OperateFunc;

import java.io.IOException;
import java.util.*;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class SubController {

    private static Logger logger = Logger.getLogger(SubController.class.getClass());
    protected static DBWorker dbWorker = DBWorker.getInstance();
    protected static OperateFunc operateFunc = OperateFunc.getInstance();


    public static Deque<TextField> textFieldsOfCriterionMarksList = new LinkedList<>();


    public static GridPane gridPaneCriterionMatrixRating() {
        GridPane gridPaneCriterion = new GridPane();

        int hsize = Criterion.size() + 1;
        int vsize = Criterion.size() + 1;

        gridPaneCriterion.getChildren().clear();
        gridPaneCriterion.setHgap(hsize);
        gridPaneCriterion.setVgap(vsize);
        gridPaneCriterion.setPadding(new Insets(10, 10, 10, 10));
        gridPaneCriterion.setBorder(Border.EMPTY);
        //gridPaneCriterion.setGridLinesVisible(true);


        Label tmp_label = new Label(String.format("%-20s", "Критерій"));
        gridPaneCriterion.add(tmp_label, 0, 0);


        int i = 1;
        for (Criterion criterion : Criterion.values()) {
            tmp_label = new Label(String.format("%-20s", criterion.getCriterion()));
            gridPaneCriterion.add(tmp_label, i, 0);

            tmp_label = new Label(String.format("%-20s", criterion.getCriterion()));
            gridPaneCriterion.add(tmp_label, 0, i++);
        }

        for (i = 1; i < Criterion.size() + 1; i++) {
            textFieldsOfCriterionMarksList.add(new TextField("1"));
            textFieldsOfCriterionMarksList.getLast().setDisable(true);
            gridPaneCriterion.add(textFieldsOfCriterionMarksList.getLast(), i, i);
            for (int j = i - 1; j > 0; j--) {
                textFieldsOfCriterionMarksList.add(new TextField("1"));
                gridPaneCriterion.add(textFieldsOfCriterionMarksList.getLast(), i, j);
            }
        }

        return gridPaneCriterion;
    }

    public static List<CriterionMark> criterionMarksListFromTextFieldsMatrixList() {
        List<CriterionMark> criterionMarkList = new ArrayList<>();
        Deque<TextField> textFieldDeque = new LinkedList<>();
        /**
         * Deque of textFields copying
         */
        for (TextField textField : textFieldsOfCriterionMarksList){
            textFieldDeque.add(textField);
        }

        try {
            for (int i = 0; i < Criterion.size(); i++) {
                criterionMarkList.add(new CriterionMark(Criterion.values()[i], Criterion.values()[i],
                        Integer.valueOf(textFieldDeque.removeFirst().getText())));
                for (int j = i - 1; j >= 0; j--) {
                    criterionMarkList.add(new CriterionMark(Criterion.values()[i], Criterion.values()[j],
                            Integer.parseInt(textFieldDeque.removeFirst().getText())));

                }
            }
        } catch (NumberFormatException e) {
            logger.error(": criterion Marks getting Error / " + e.getMessage() + " / " + e.getStackTrace());
        }
        return criterionMarkList;
    }

    public static GridPane gridPaneArchitectureCriterion() {
        GridPane gridPane = new GridPane();

        int hsize = operateFunc.getTaskChoice().getArchitectures().size() + 1;
        int vsize = Criterion.size() + 1;

        Deque<Button> archeryOpenButtonHor = new LinkedList<>();

        gridPane.getChildren().clear();
        gridPane.setHgap(hsize);
        gridPane.setVgap(vsize);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setBorder(Border.EMPTY);

        Label tmpLabel = new Label(String.format("%-30s", "Критерій/Архітектура"));
        gridPane.add(tmpLabel, 0, 0);

        int i = 1;
        for (Criterion criterion : Criterion.values()) {
            tmpLabel = new Label(String.format("%-20s", criterion.getCriterion()));
            gridPane.add(tmpLabel, 0, i++);
        }

        i = 1;
        for (Architecture architecture : operateFunc.getTaskChoice().getArchitectures()) {
            archeryOpenButtonHor.add(new Button("arch: " + i));
            gridPane.add(archeryOpenButtonHor.getLast(), i, 0);
            archeryOpenButtonHor.getLast().setOnAction(new EventHandlerViewPreviewImpl(architecture, i));

            int j = 1;
            for (Criterion criterion : Criterion.values()) {
                TextField textField = new TextField(String.format("%.2f",
                        operateFunc.getMarkByArchitectureCriterion(architecture, criterion)));
                gridPane.add(textField, i, j++);
            }
            i++;
        }

        return gridPane;
    }

    public static GridPane gridPaneArchitectureComplexMark() {
        GridPane gridPane = new GridPane();

        int hsize = operateFunc.getTaskChoice().getArchitectures().size() + 1;
        int vsize = 2;

        Deque<Button> archeryOpenButtonHor = new LinkedList<>();

        gridPane.getChildren().clear();
        gridPane.setHgap(hsize);
        gridPane.setVgap(vsize);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setBorder(Border.EMPTY);

        Label tmpLabel = new Label(String.format("%-30s", "Критерій/Архітектура"));
        gridPane.add(tmpLabel, 0, 0);


        tmpLabel = new Label(String.format("%-20s", "Complex"));
        gridPane.add(tmpLabel, 0, 1);

        int i = 1;
        for (Architecture architecture : operateFunc.getTaskChoice().getArchitectures()) {
            archeryOpenButtonHor.add(new Button("arch: " + i));
            gridPane.add(archeryOpenButtonHor.getLast(), i, 0);
            archeryOpenButtonHor.getLast().setOnAction(new EventHandlerViewPreviewImpl(architecture, i));

            TextField textField = new TextField(String.format("%.2f",
                    operateFunc.getComplexMarkByArchitecture(architecture)));
            gridPane.add(textField, i++, 1);
        }

        return gridPane;
    }

    /**
     *
     */
    static class EventHandlerViewPreviewImpl implements EventHandler<ActionEvent> {
        final Architecture architecture;
        final int finalI;

        public EventHandlerViewPreviewImpl(Architecture architecture, int finalI) {
            this.architecture = architecture;
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
            controller.initData(architecture);
            stage.setTitle("Візуалізація архітектури " + (finalI));
            stage.show();
        }
    }
}
