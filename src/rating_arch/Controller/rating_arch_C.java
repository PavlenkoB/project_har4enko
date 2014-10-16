package rating_arch.Controller;

import Classes.Architecture;
import Classes.Mark;
import Classes.Task;
import editor.classes.DerbyDBManager;
import editor.services.arch_work;
import editor.services.functions;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static editor.services.arch_work.arch_image_gen_with_patterns;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class rating_arch_C implements Initializable {
    /**
     * task_choise                  -   Задача що оцінюється, має зв'язок з архітектурою
     * architecture_done_choise     -   Масив архітектур згенерованих архітектором до завдання
     * architecture_done_choise_type-   Тип архітектури до завдання
     * marks                        -   Введені оцінки при попарному оцінюванні
     * mark_crit                    -   Критерій оцінювання
     * arch_mark_combine            -   комбінація оцінуваних архітектур
     * arch_1_image, arch_2_image   -   Поточна візуалізація
     * redo_im_1, redo_im_2         -   Візуалізація наступної пари архітектур
     * <p/>
     * Rating_arch_1                -   Вибір завдання та критерію
     * Rating_arch_2                -   Попарне оцінювання
     * Rating_arch_3                -   Матриця оцінок
     */

    public AnchorPane Rating_arch_1;
    public ChoiceBox task_list;
    public TextArea task_description;
    public Button cancelButton;
    public Task task_choise;
    public ArrayList<Architecture> architecture_done_choise = new ArrayList<>();
    public Architecture architecture_done_choise_type;
    public ArrayList<Mark> marks = new ArrayList<>();
    public ChoiceBox mark_crit;
    public AnchorPane mark;
    public AnchorPane Rating_arch_2;
    public ImageView arch_1_im;
    public ImageView arch_2_im;
    public int[] arch_mark_combine = new int[2];
    public Image arch_1_image, arch_2_image,
            redo_im_1, redo_im_2;
    public AnchorPane text_view;
    public AnchorPane ankor_im_1;
    public AnchorPane ankor_im_2;
    public AnchorPane Rating_arch_3;
    public ImageView IV_test;
    public AnchorPane title_arch2;
    public AnchorPane title_arch1;
    public Button save_marks_but;
    public AnchorPane root;
    public TextField crit;
    public Button Next_twise;
    ArrayList<javafx.scene.control.TextField> textField_marks = new ArrayList<>();


    DerbyDBManager derby_DB;// = new DerbyDBManager("DB/paterns_DB");
    DerbyDBManager mark_db = new DerbyDBManager("DB/Marks");
    String pattern_db_str;
    String mark_db_str;

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
    //Windows close dialog

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Rating_arch_2.setVisible(false);
        Rating_arch_3.setVisible(false);
        try {
            Rating_arch_1.setVisible(true);
            Start_rating();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> crit = FXCollections.observableArrayList();
        crit.clear();
        crit.addAll("Надійність", "Ефективність", "Швидкодія");
        mark_crit.setItems(crit);
    }

    public void Start_rating() {
        //disconnect_DB(mark_db);
        derby_DB = new DerbyDBManager(pattern_db_str);
        Rating_arch_1.setVisible(true);
        Rating_arch_2.setVisible(false);
        Rating_arch_3.setVisible(false);
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
        //ObservableList<String> mark_crit = FXCollections.observableArrayList();
        //mark_crit.addAll("Швидкодія", "Безпека", "Надійність");
        // mark_crit.addAll(mark_crit);

    }

    private void task_description_view(Number new_value) {
        ResultSet rs_task;
        task_description.clear();
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
        String markl = mark_crit.getSelectionModel().selectedItemProperty().getValue().toString();
        crit.clear();
        crit.setText(markl);
        Rating_arch_1.setVisible(false);
        Rating_arch_2.setVisible(true);
        Rating_arch_3.setVisible(false);
        marks.clear();
        ResultSet rs = null;
        task_choise = new Task();
        architecture_done_choise_type = new Architecture();
        architecture_done_choise.clear();

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
            int task_id = architecture_done_choise.get(i).getTask_id(),
                    id_done = architecture_done_choise.get(i).getId_done();

            try {
                architecture_done_choise.set(i, architecture_done_choise_type.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            architecture_done_choise.get(i).setId_done(id_done);
            architecture_done_choise.get(i).setTask_id(task_id);

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
                                for (int p = 0; p < architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_patterns().size(); p++) {
                                    if (architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_patterns().get(p).getId() == rs.getInt("PATTERN_ID")) {
                                        architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).setSelected_pattern(architecture_done_choise.get(i).getLayers().get(j).getModules().get(k).getAvilable_patterns().get(p));
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        arch_mark_combine[0] = 0;
        if (architecture_done_choise.size() > 1) {
            arch_mark_combine[1] = 1;
        } else {
            arch_mark_combine[1] = 0;
        }

        arch_1_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[0]));
        arch_2_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[1]));
        draw_arch_im_text();
/*
        double zoom = 0.8;
        arch_1_im.setFitHeight(arch_1_image.getRequestedHeight() * zoom);
        arch_1_im.setFitWidth(arch_1_image.getRequestedWidth() * zoom);
        arch_2_im.setFitHeight(arch_2_image.getRequestedHeight() * zoom);
        arch_2_im.setFitWidth(arch_2_image.getRequestedWidth() * zoom);
        arch_1_im.setImage(arch_1_image);
        arch_2_im.setImage(arch_2_image);
        */

        System.out.print("lol");
    }

    public void draw_arch_im_text() {

        //Визов потоку генерації візуалізацій наступної пари архітектур
        tread_go();

        //ankor_im_1.getChildren().clear();
        //ankor_im_2.getChildren().clear();
        //ankor_im_1.getChildren().add(arch_1_im);
        //ankor_im_2.getChildren().add(arch_2_im);
        text_view.getChildren().clear();


/*
        arch_1_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[0]));
        arch_2_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[1]));
*/
        double zoom = 0.8;
        arch_1_im.setFitHeight(arch_1_image.getRequestedHeight() * zoom);
        arch_1_im.setFitWidth(arch_1_image.getRequestedWidth() * zoom);
        arch_2_im.setFitHeight(arch_2_image.getRequestedHeight() * zoom);
        arch_2_im.setFitWidth(arch_2_image.getRequestedWidth() * zoom);

        arch_1_im.setImage(arch_1_image);
        arch_2_im.setImage(arch_2_image);
        //IV_test.setImage(arch_1_image);

        Label label_ar_1 = new Label();
        Label label_ar_2 = new Label();

        label_ar_1.setText("Архітектура A" + (arch_mark_combine[0] + 1));
        label_ar_1.setLayoutY(0);
        label_ar_1.setLayoutX(0);
        label_ar_1.setFont(Font.font(15));
        label_ar_2.setText("Архітектура A" + (arch_mark_combine[1] + 1));
        label_ar_2.setLayoutY(0);
        label_ar_2.setLayoutX(0);
        label_ar_2.setFont(Font.font(15));

        title_arch1.getChildren().clear();
        title_arch2.getChildren().clear();
        title_arch1.getChildren().add(label_ar_1);
        title_arch2.getChildren().add(label_ar_2);


        int vsize = 0,
                hsize = 0;

        hsize = 4;
        for (int i = 0; i < architecture_done_choise_type.getLayers().size(); i++) {
            vsize++;
            vsize += architecture_done_choise_type.getLayers().get(i).getModules().size();
        }

        vsize += 2; //для описової частини

        GridPane gridPane_arch = new GridPane();
        gridPane_arch.getChildren().clear();
        gridPane_arch.setHgap(hsize);
        gridPane_arch.setVgap(vsize);
        gridPane_arch.setPadding(new Insets(10, 10, 10, 10));
        gridPane_arch.setBorder(Border.EMPTY);
        //gridPane_arch.setGridLinesVisible(true);

        Label label_arch = new Label();
        label_arch.setText(architecture_done_choise_type.getName());
        label_arch.setFont(Font.font(16));


        Label label_ar_3 = new Label();
        Label label_ar_4 = new Label();

        label_ar_3.setText("Архітектура A" + (arch_mark_combine[0] + 1));
        label_ar_3.setLayoutY(0);
        label_ar_3.setLayoutX(0);
        label_ar_3.setFont(Font.font(15));
        label_ar_4.setText("Архітектура A" + (arch_mark_combine[1] + 1));
        label_ar_4.setLayoutY(0);
        label_ar_4.setLayoutX(0);
        label_ar_4.setFont(Font.font(15));

        Label label_op_1 = new Label("Шар");
        label_op_1.setFont(Font.font(15));
        Label label_op_2 = new Label("Модуль");
        label_op_2.setFont(Font.font(15));
        Label label_op_3 = new Label("Патерн");
        label_op_3.setFont(Font.font(15));
        Label label_op_4 = new Label("Патерн");
        label_op_4.setFont(Font.font(15));

        gridPane_arch.add(label_arch, 0, 0);
        gridPane_arch.add(label_ar_3, 2, 0);
        gridPane_arch.add(label_ar_4, 3, 0);

        gridPane_arch.add(label_op_1, 0, 1);
        gridPane_arch.add(label_op_2, 1, 1);
        gridPane_arch.add(label_op_3, 2, 1);
        gridPane_arch.add(label_op_4, 3, 1);

        ArrayList<Label> label_1 = new ArrayList<>(),
                label_2 = new ArrayList<>(),
                label_0 = new ArrayList<>();
        label_0.clear();
        label_1.clear();
        label_2.clear();

        int vpos = 2;
        for (int i = 0; i < architecture_done_choise_type.getLayers().size(); i++) {
            label_0.add(new Label());
            label_0.get(label_0.size() - 1).setText(architecture_done_choise_type.getLayers().get(i).getName());
            label_0.get(label_0.size() - 1).setFont(Font.font(14));
            gridPane_arch.add(label_0.get(label_0.size() - 1), 0, vpos);
            vpos++;
            for (int j = 0; j < architecture_done_choise_type.getLayers().get(i).getModules().size(); j++) {
                label_0.add(new Label());
                label_0.get(label_0.size() - 1).setText(architecture_done_choise_type.getLayers().get(i).getModules().get(j).getName());
                label_0.get(label_0.size() - 1).setFont(Font.font(12));
                gridPane_arch.add(label_0.get(label_0.size() - 1), 1, vpos);

                label_1.add(new Label());
                label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getModules().get(j).getSelected_pattern().getName());
                label_1.get(label_1.size() - 1).setFont(Font.font(12));

                label_2.add(new Label());
                label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getModules().get(j).getSelected_pattern().getName());
                label_2.get(label_2.size() - 1).setFont(Font.font(12));

                if (!label_1.get(label_1.size() - 1).getText().toString().equals(label_2.get(label_2.size() - 1).getText().toString())) {
                    label_1.get(label_1.size() - 1).setTextFill(Color.web("#F80000"));
                    label_2.get(label_2.size() - 1).setTextFill(Color.web("#00F800"));
                }
                gridPane_arch.add(label_1.get(label_1.size() - 1), 2, vpos);
                gridPane_arch.add(label_2.get(label_2.size() - 1), 3, vpos);
                vpos++;
            }
        }


        text_view.getChildren().add(gridPane_arch);
/*

        int xpos = 10;
        label_1.clear();
        label_2.clear();

        label_1.add(new Label());
        label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getName());
        label_1.get(label_1.size() - 1).setLayoutY(vpos);
        vpos += 15;
        label_1.get(label_1.size() - 1).setLayoutX(xpos);
        for (int i = 0; i < architecture_done_choise.get(arch_mark_combine[0]).getLayers().size(); i++) {
            label_1.add(new Label());
            label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getName());
            label_1.get(label_1.size() - 1).setLayoutY(vpos);
            vpos += 15;
            label_1.get(label_1.size() - 1).setLayoutX(xpos + 25);
            for (int j = 0; j < architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getModules().size(); j++) {
                label_1.add(new Label());
                label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getModules().get(j).getName());
                label_1.get(label_1.size() - 1).setLayoutY(vpos);
                vpos += 15;
                label_1.get(label_1.size() - 1).setLayoutX(xpos + 50);
                label_1.add(new Label());
                label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getModules().get(j).getSelected_pattern().getName());
                label_1.get(label_1.size() - 1).setLayoutY(vpos);
                vpos += 15;
                label_1.get(label_1.size() - 1).setLayoutX(xpos + 75);
            }
        }
        vpos = 15;
        label_2.add(new Label());
        label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getName());
        label_2.get(label_2.size() - 1).setLayoutY(vpos);
        vpos += 15;
        label_2.get(label_2.size() - 1).setLayoutX(xpos);
        for (int i = 0; i < architecture_done_choise.get(arch_mark_combine[1]).getLayers().size(); i++) {
            label_2.add(new Label());
            label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getName());
            label_2.get(label_2.size() - 1).setLayoutY(vpos);
            vpos += 15;
            label_2.get(label_2.size() - 1).setLayoutX(xpos + 25);
            for (int j = 0; j < architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getModules().size(); j++) {
                label_2.add(new Label());
                label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getModules().get(j).getName());
                label_2.get(label_2.size() - 1).setLayoutY(vpos);
                vpos += 15;
                label_2.get(label_2.size() - 1).setLayoutX(xpos + 50);
                label_2.add(new Label());
                label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getModules().get(j).getSelected_pattern().getName());
                label_2.get(label_2.size() - 1).setLayoutY(vpos);
                vpos += 15;
                label_2.get(label_2.size() - 1).setLayoutX(xpos + 75);
            }
        }*/
    }

    public void setArch_mark_combine_combine_next() {
        arch_1_image = redo_im_1;
        arch_2_image = redo_im_2;

        if (arch_mark_combine[1] < (architecture_done_choise.size() - 1)) {
            arch_mark_combine[1]++;
        } else if ((arch_mark_combine[1] == (architecture_done_choise.size() - 1)) & (arch_mark_combine[0] < (architecture_done_choise.size() - 2))) {
            arch_mark_combine[0]++;
            arch_mark_combine[1] = arch_mark_combine[0] + 1;
        } else if (arch_mark_combine[0] == (architecture_done_choise.size() - 2)) {
            System.out.print("Оцінка завершина");
            mark_done();
        } else {
            System.out.print("Помилка");
        }
    }

    public void next_twise(ActionEvent actionEvent) {
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_1(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 1));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_2(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 2));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_3(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 3));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_4(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 4));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_5(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 5));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_6(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 6));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_7(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 7));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_8(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 8));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_9(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 9));
        setArch_mark_combine_combine_next();
        draw_arch_im_text();
    }

    public void mark_done() {
        Rating_arch_1.setVisible(false);
        Rating_arch_2.setVisible(false);
        Rating_arch_3.setVisible(true);


        /**
         * Вивід матриці оцінок у грід-панелі
         * textField_marks      - масив текстових полів з оцінками
         * gridPane_mark        - грід-панель відображення оцінок
         */
        int hsize = architecture_done_choise.size() + 1;
        int vsize = architecture_done_choise.size() + 1;

        GridPane gridPane_mark = new GridPane();
        gridPane_mark.getChildren().clear();
        gridPane_mark.setHgap(hsize);
        gridPane_mark.setVgap(vsize);
        gridPane_mark.setPadding(new Insets(10, 10, 10, 10));
        gridPane_mark.setBorder(Border.EMPTY);
        //gridPane_mark.setGridLinesVisible(true);


        Label tmp_label = new Label("Архітектура");
        gridPane_mark.add(tmp_label, 0, 0);
        for (int i = 1; i < (architecture_done_choise.size() + 1); i++) {
            tmp_label = new Label("A" + i);
            gridPane_mark.add(tmp_label, i, 0);
        }
        tmp_label = null;
        for (int i = 1; i < (architecture_done_choise.size() + 1); i++) {
            tmp_label = new Label("A" + i);
            gridPane_mark.add(tmp_label, 0, i);
        }

        Label diagon = new Label();
        diagon.setText("1");
        textField_marks.clear();

        for (int i = 0; i < architecture_done_choise.size(); i++) {
            marks.add(new Mark(i, i, 1));
        }

        for (int i = 0; i < marks.size(); i++) {
            textField_marks.add(new javafx.scene.control.TextField());
            textField_marks.get(textField_marks.size() - 1).setText(marks.get(i).getMark().toString());
            textField_marks.get(textField_marks.size() - 1).setMaxWidth(45);
            gridPane_mark.add(textField_marks.get(textField_marks.size() - 1), marks.get(i).getNum_arch_1() + 1, marks.get(i).getNum_arch_0() + 1);
            /**
             * Обробка діагоналі оцінок
             */
            if (marks.get(i).getNum_arch_0() == marks.get(i).getNum_arch_1()) {
                textField_marks.get(textField_marks.size() - 1).setText("1");
            }
        }


        Rating_arch_3.getChildren().add(gridPane_mark);

    }

    /**
     * Під'єднання до БД
     * derby_DB         -   підключення добази репозитарію арххітектур
     *
     * @param actionEvent
     */
    public void connect_DB(ActionEvent actionEvent) {
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
            Start_rating();
        } catch (Exception e) {
            e.printStackTrace();
            derby_DB = null;
        }
    }

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

    /**
     * Зчитування оцінок з матриці, організація збереження їх у базу
     * В структурі масиву текстових полів textField_marks - спочатку йдуть елементи з оцінками різнойменніх
     * архітектур, остані (architecture_done_choise.size() - 1) елементів є оцнками діагоналі.
     * arch_row         -   горизонтальна скланова ( стрічка)
     * arch_col         -   вертикальна складова (колонка)
     * markArrayList    -   масив переструктурованих (змінених) оцінок, що в подальшому зберігаються в базу
     *
     * @param actionEvent
     */
    public void Save_marks(ActionEvent actionEvent) {

        String buffer = null;
        ArrayList<Mark> markArrayList = new ArrayList<>();
        markArrayList.clear();
        int arch_row = 0, arch_col = 1, buff = 1;
        for (int i = 0; i < textField_marks.size(); i++) {
            buffer = textField_marks.get(i).getText().toString();
            markArrayList.add(new Mark(arch_row, arch_col, Integer.parseInt(buffer)));
            if (arch_col >= architecture_done_choise.size() - 1) {
                arch_row++;
                arch_col = arch_row;
            }
            arch_col++;
            if ((arch_col >= architecture_done_choise.size() - 1) & (arch_row >= architecture_done_choise.size() - 1)) {
                break;
            }
        }
        for (int i = 0; i < architecture_done_choise.size(); i++) {
            markArrayList.add(new Mark(i, i, 1));
        }


        try {
            // disconnect_DB(derby_DB);
            creat_mark_DB();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            session_save_to_db(task_choise.getId(), mark_db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int session_id = functions.last_id_from_table_DB("SESSION", mark_db);

        for (int i = 0; i < markArrayList.size(); i++) {
            try {
                marks_save_to_DB(markArrayList.get(i), architecture_done_choise.get(markArrayList.get(i).getNum_arch_0()).getId_done(), architecture_done_choise.get(markArrayList.get(i).getNum_arch_1()).getId_done(), session_id, mark_db);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Object[] options = {"Вибір завдання",
                "Вихід"};
        int n = JOptionPane.showOptionDialog(null,
                "Збереження оцінок проведено успішно.",
                "Повернутися до вибору завдання?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            Start_rating();
        } else if (n == 1) {
            Stage win = new Stage();
            win = (Stage) root.getScene().getWindow();
            disconnect_DB(mark_db);
            disconnect_DB(derby_DB);
            win.close();
        } else {
            /*Stage win = new Stage();
            win = (Stage) root.getScene().getWindow();
            disconnect_DB(mark_db);
            disconnect_DB(derby_DB);
            win.close();*/

        }
    }

    /**
     * @throws IOException
     */
    public void creat_mark_DB() throws IOException { //Создать БД
        File db_dir = new File("DB/Marks");

        //Если требуемого файла не существует.
        if (!db_dir.exists()) {
            //Создаем его.
            db_dir.createNewFile();
        }

        if (db_dir != null) {
            mark_db = new DerbyDBManager(db_dir);

            System.out.print("Создаю таблиці)");
            try {
                File in_dir = new File(getClass().getClassLoader().getResource("editor/sql/create_marks_DB").getFile());
                //ResourceAsStream("/editor/sql/creat_DB");

                File[] fList;

                fList = in_dir.listFiles();

                for (int i = 0; i < fList.length; i++) {
                    //Нужны только папки в место isFile() пишим isDirectory()
                    if (fList[i].isFile()) {

                        String filename = fList[i].getName();
                        int dotPos = filename.lastIndexOf(".");
                        String ext = filename.substring(dotPos);
                        if (ext.equals(".sql")) {
                            derby_DB.executeUpdate_from_file(fList[i]);
                        }
                    }

                }

                System.out.print("Создал таблиці)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //TODO создание
        }
    }

    public static boolean session_save_to_db(int task_id, DerbyDBManager mark_db_conn) throws SQLException {
        boolean result = false;
        ResultSet rs_tmp;
        System.out.printf("INSERT INTO SESSION (TASK_ID) VALUES (" + task_id + ")\n");
        mark_db_conn.executeUpdate("INSERT INTO SESSION (TASK_ID) VALUES (" + task_id + ")");

        System.out.printf("session save successful");
        return result;
    }

    public static boolean marks_save_to_DB(Mark mark, int arch_1_id, int arch_2_id, int session_id, DerbyDBManager mark_db_conn) throws SQLException {//Зберегти архітектуру в БД
        boolean result = false;
        ResultSet rs_tmp;
        //Добавить в базу
        mark_db_conn.executeUpdate("INSERT INTO MARK (SESSION_ID,ARCH_1_ID,ARCH_2_ID,MARK) VALUES (" + session_id + "," + arch_1_id + "," + arch_2_id + "," + mark.getMark() + ")");


        System.out.printf("mark save successful");
        return result;
    }

    private void tread_go() {
        Thread myThread = new Thread(MyThread);
        myThread.setPriority(5);
        myThread.setDaemon(true);
        myThread.start();
        /*myThread = new Thread(task);
        myThread.setDaemon(true);
        myThread.start();*/
    }

    //Поток генерації наступної  візуалізації архітектур
    protected Thread MyThread = new Thread(new Runnable() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (arch_mark_combine[0] != architecture_done_choise.size() - 2)
                        redo_im_1 = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[0] + 1));
                    System.out.println("redo" + arch_mark_combine[0]);
                    if (arch_mark_combine[1] != architecture_done_choise.size() - 1)
                        redo_im_2 = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[1] + 1));
                    System.out.println("redo" + arch_mark_combine[1]);
                }
            });
        }
    });

    /*private Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (arch_mark_combine[0] != architecture_done_choise.size()-2)
                        redo_im_1 = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[0]+1));
                    if (arch_mark_combine[1] != architecture_done_choise.size()-1)
                        redo_im_2 = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[1]+1));
                }
            });
        }
    });*/
}


