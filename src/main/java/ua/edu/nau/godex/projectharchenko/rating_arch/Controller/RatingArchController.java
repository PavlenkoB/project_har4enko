package rating_arch.Controller;

import Classes.Architecture;
import Classes.Criterion;
import Classes.Mark;
import Classes.Task;
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
import java.util.List;
import java.util.ResourceBundle;

import static editor.services.archWork.arch_image_gen_with_patterns;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class RatingArchController implements Initializable {
    /**
     * task_choise                  -   Задача що оцінюється, має зв'язок з архітектурою
     * architecture_done_choise     -   Масив архітектур згенерованих архітектором до завдання
     * architecture_done_choise_type-   Тип архітектури до завдання
     * marks                        -   Введені оцінки при попарному оцінюванні
     * mark_crit                    -   Критерій оцінювання
     * arch_mark_combine            -   комбінація оцінуваних архітектур
     * arch_1_image, arch_2_image   -   Поточна візуалізація
     * redo_im_1, redo_im_2         -   Візуалізація наступної пари архітектур
     * <p>
     * Rating_arch_1                -   Вибір завдання та критерію
     * Rating_arch_2                -   Попарне оцінювання
     * Rating_arch_3                -   Матриця оцінок
     */

    public AnchorPane Rating_arch_1;
    public ChoiceBox task_list;
    public TextArea task_description;
    public Button cancelButton;
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
    public AnchorPane mark_panel;
    public TextArea note_field;
    ArrayList<javafx.scene.control.TextField> textField_marks = new ArrayList<>();

    protected DBWorker dbWorker = DBWorker.getInstance();
    protected List<Task> taskList = null;

    protected Task task_choise;
    protected List<Architecture> architecture_done_choise = new ArrayList<>();
    protected Architecture architecture_done_choise_type;
    protected ArrayList<Mark> marks = new ArrayList<>();

//
//    DerbyDBManager derby_DB; // = new DerbyDBManager("DB/paterns_DB");
//    DerbyDBManager mark_db; // = new DerbyDBManager("DB/Marks");
//    String pattern_db_str;
//    String mark_db_str = "DB/Marks";


    protected String crit_choise;

    //Windows close dialog
    public void close(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/rating_arch/Interface/Close.fxml"));
            stage.setTitle("Завершити програму");
            stage.setScene(new Scene(root, 600, 130));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) {
        dbWorker.disconnectAll();
        System.exit(1);
    }

    public void goBackMain(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    //Windows close dialog

    protected boolean isCloseWindows() {
        return Rating_arch_1 == null || Rating_arch_2 == null || Rating_arch_3 == null;
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        if (!isCloseWindows()) {
            visibleFalseToAllAnchors();
            Rating_arch_1.setVisible(true);
            startRating();

            ObservableList<String> crit = FXCollections.observableArrayList();
            crit.clear();
            for (Criterion criterion : Criterion.values()) {
                crit.add(criterion.getCriterion());
            }
            mark_crit.setItems(crit);
        }
    }

    @FXML
    protected void startRating() {
        visibleFalseToAllAnchors();
        Rating_arch_1.setVisible(true);
        taskList = dbWorker.getTasksList();

        ObservableList<String> items = FXCollections.observableArrayList();
        if (taskList != null) {
            for (Task task : taskList) {
                items.add(task.getId() + "|" + task.getName());
            }
        }

        task_list.setItems(items);
        task_list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
                taskDescriptionView(new_value);
            }
        });
    }

    protected void taskDescriptionView(Number new_value) {
        task_description.clear();
        if (taskList != null) {
            for (Task task : taskList) {
                if (task.getId().equals(functions.get_ID((String) task_list.getItems().get(new_value.intValue())))) {
                    task_description.setEditable(true);
                    task_description.setText(task.getDescription());
                    task_description.setEditable(false);
                    break;
                }
            }
        }
    }

    public void backToModeSel(ActionEvent actionEvent) {
    }

    /**
     * Вибір завдання та критерію оцінювання
     *
     * @param actionEvent
     */
    public void choiceTask(ActionEvent actionEvent) {
        crit_choise = mark_crit.getSelectionModel().selectedItemProperty().getValue().toString();
        crit.clear();
        crit.setText(crit_choise);
        visibleFalseToAllAnchors();
        Rating_arch_2.setVisible(true);
        marks.clear();
        ResultSet rs = null;
        task_choise = new Task();
        architecture_done_choise_type = new Architecture();
        architecture_done_choise.clear();

        /*
        * Подгрузка массива заданий с БД
        */
        if (taskList != null) {
            for (Task task : taskList) {
                if (task.getId().equals(functions.get_ID(task_list.getSelectionModel().getSelectedItem().toString()))) {
                    task_choise = task;
                    break;
                }
            }
        }

        architecture_done_choise = dbWorker.getArchitectureListByTaskID(task_choise.getId());
        architecture_done_choise_type = dbWorker.getArchitectureType(architecture_done_choise.get(0));

        arch_mark_combine[0] = 0;
        if (architecture_done_choise.size() > 1) {
            arch_mark_combine[1] = 1;
        } else {
            arch_mark_combine[1] = 0;
        }

        arch_1_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[0]));
        arch_2_image = arch_image_gen_with_patterns(architecture_done_choise.get(arch_mark_combine[1]));
        drawArchImText();
    }

    /**
     * Формування візуалізацій пар архітетур, тектового вигляду та загрузка графічного
     */
    protected void drawArchImText() {

        //Визов потоку генерації візуалізацій наступної пари архітектур
        tread_go();

        text_view.getChildren().clear();

        double zoom = 0.8;
        arch_1_im.setFitHeight(arch_1_image.getRequestedHeight() * zoom);
        arch_1_im.setFitWidth(arch_1_image.getRequestedWidth() * zoom);
        arch_2_im.setFitHeight(arch_2_image.getRequestedHeight() * zoom);
        arch_2_im.setFitWidth(arch_2_image.getRequestedWidth() * zoom);

        arch_1_im.setImage(arch_1_image);
        arch_2_im.setImage(arch_2_image);

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
                label_1.get(label_1.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[0]).getLayers().get(i).getModules().get(j).getSelectedPattern().getName());
                label_1.get(label_1.size() - 1).setFont(Font.font(12));

                label_2.add(new Label());
                label_2.get(label_2.size() - 1).setText(architecture_done_choise.get(arch_mark_combine[1]).getLayers().get(i).getModules().get(j).getSelectedPattern().getName());
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
    }

    /**
     * Ітерування пари відображуваних архітектур
     * Загрузка з потоку зображення наступної і попередньої архітектур
     * Перевірка на закінчення оцінювання - визов відображення матриці
     */
    protected void setArchMarkCombineCombineNext() {
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

    /**
     * Наступна пара архітектур з виставленням оцінки "0" - без оцінки
     *
     * @param actionEvent
     */
    public void nextTwise(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 0));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    /**
     * Наступна пара архітектур з виставленням оцінки "1"
     *
     * @param actionEvent
     */
    public void mark_1(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 1));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_2(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 2));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_3(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 3));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_4(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 4));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_5(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 5));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_6(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 6));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_7(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 7));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_8(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 8));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    public void mark_9(ActionEvent actionEvent) {
        marks.add(new Mark(arch_mark_combine[0], arch_mark_combine[1], 9));
        setArchMarkCombineCombineNext();
        drawArchImText();
    }

    /**
     * Вивід матриці оцінок у грід-панелі
     * textField_marks      - масив текстових полів з оцінками
     * gridPane_mark        - грід-панель відображення оцінок
     */
    protected void mark_done() {
        mark_panel.getChildren().clear();
        visibleFalseToAllAnchors();
        Rating_arch_3.setVisible(true);

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
            gridPane_mark.add(textField_marks.get(textField_marks.size() - 1), marks.get(i).getNumArch1() + 1, marks.get(i).getNumArch0() + 1);
            /**
             * Обробка діагоналі оцінок
             */
            if (marks.get(i).getNumArch0() == marks.get(i).getNumArch1()) {
                textField_marks.get(textField_marks.size() - 1).setText("1");
            }
        }


        mark_panel.getChildren().add(gridPane_mark);

    }

    /**
     * Під'єднання до БД
     * derby_DB         -   підключення добази репозитарію арххітектур
     *
     * @param actionEvent
     */
    public void connect_DB(ActionEvent actionEvent) {
        try {
            dbWorker.disconnectArchDb();
            JFileChooser db_dir = new JFileChooser(new File(System.getProperty("user.dir")));
            db_dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            db_dir.setAcceptAllFileFilterUsed(false);
            db_dir.setDialogTitle("Виберіть папку з БД архітектур");
            db_dir.showDialog(null, "Обрати");
            // существет ли база(создана ли)

            dbWorker.connectionToArchDb(db_dir.getSelectedFile().getAbsolutePath().toString());
            startRating();
        } catch (Exception e) {
            e.printStackTrace();
            dbWorker.disconnectArchDb();
        }
    }

    protected void visibleFalseToAllAnchors() {
        Rating_arch_1.setVisible(false);
        Rating_arch_2.setVisible(false);
        Rating_arch_3.setVisible(false);
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
        try {
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

            dbWorker.connectionToMarkDb();


            String note_exp = note_field.getText().toString();

            try {
                dbWorker.session_save_to_db(task_choise.getId(), crit_choise, note_exp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int session_id = dbWorker.getLastSessionID();

            for (int i = 0; i < markArrayList.size(); i++) {
                try {
                    dbWorker.marksSaveToDB(markArrayList.get(i), architecture_done_choise.get(markArrayList.get(i).getNumArch0()).getIdDone(),
                            architecture_done_choise.get(markArrayList.get(i).getNumArch1()).getIdDone(), session_id);
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
                startRating();
            } else if (n == 1) {
                Stage win = new Stage();
                win = (Stage) root.getScene().getWindow();
                dbWorker.disconnectAll();
                win.close();
            } else {
            /*Stage win = new Stage();
            win = (Stage) root.getScene().getWindow();
            disconnect_DB(mark_db);
            disconnect_DB(derby_DB);
            win.close();*/

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Функція (метод) викліку потоку
     */
    protected void tread_go() {
        Thread myThread = new Thread(MyThread);
        myThread.setPriority(5);
        myThread.setDaemon(true);
        myThread.start();
    }

    /**
     * Потік генерації наступної  візуалізації архітектур
     */
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
}


