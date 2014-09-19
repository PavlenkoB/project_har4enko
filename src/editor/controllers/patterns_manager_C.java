package editor.controllers;

import Classes.Pattern;
import editor.interfaces.Configuration;
import editor.classes.DerbyDBManager;
import editor.classes.id_Lable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 04.07.2014.
 */
public class patterns_manager_C implements Initializable,Configuration {
    public ComboBox cbFromArch;
    public ComboBox cbFromLay;
    public ComboBox cbFromMod;
    public ComboBox cbToArch;
    public ComboBox cbToLay;
    public ComboBox cbToMod;
    public ListView lvFromList;
    public ListView toList;
    public BorderPane root;
    public DerbyDBManager dbConnection;
    private String fromLastQuery, toLastQuery;
    private String fromType,toType;
    private Integer fromModId, toModId, fromArchId, toArchId;

    public void initData(final DerbyDBManager derbyDBManager) {
        dbConnection = derbyDBManager;
        ResultSet rs = null;
        try {
            //derby_DB
            rs = dbConnection.executeQuery("SELECT * FROM ARCHITECTURE ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            items.add(new id_Lable(-1, "Базові"+" "+ resourceBundle.getString("загальні.патерни")));
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            cbFromArch.setItems(items);

            cbFromArch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    cbFromMod.setItems(FXCollections.observableArrayList());
                    lvFromList.setItems(FXCollections.observableArrayList());
                    from_lay_load();
                }
            });
            cbToArch.setItems(items);
            cbToArch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    cbToMod.setItems(FXCollections.observableArrayList());
                    toList.setItems(FXCollections.observableArrayList());
                    to_lay_load();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }/**/


        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        //thisstage.setTitle("Управління репозиторіем патернів: редактор архітектур");
        thisstage.setMinWidth(900);//Минимальная шырина
        thisstage.setMinHeight(700);//Минимальная высота окна
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Object[] options = {resourceBundle.getString("загальні.так"),
                        resourceBundle.getString("загальні.ні")};
                int n = JOptionPane.showOptionDialog(null,
                        resourceBundle.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"),
                        resourceBundle.getString("загальні.увага"),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
                if (n == 0) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/main_window_V2.fxml")
                    );

                    Stage stage = new Stage(StageStyle.DECORATED);
                    try {
                        stage.setScene(new Scene((Pane) loader.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    main_C controller = loader.<main_C>getController();
                    controller.initData(null, derbyDBManager);

                    stage.show();
                    Stage stage_this = (Stage) root.getScene().getWindow();
                    // do what you have to do
                    stage_this.close();
                } else {
                    we.consume();
                }
            }
        });
    }

    /**
     * Завантажити список звідки і зберегти його останій запит
     *
     * @param Query запит
     */
    private void fromListLoad(String Query) {
        try {
            ResultSet rs = null;
            rs = dbConnection.executeQuery(Query);
            fromLastQuery = Query;
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            lvFromList.setItems(items);
            lvFromList.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажити список куди і зберегти його останій запит
     *
     * @param Query запит
     */
    private void to_list_load(String Query) {
        try {
            ResultSet rs = null;
            rs = dbConnection.executeQuery(Query);
            toLastQuery = Query;
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            toList.setItems(items);

            toList.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_lay_load() {
        ResultSet rs = null;
        try {
            if (((id_Lable) cbFromArch.getSelectionModel().getSelectedItem()).getDbid().intValue() != -1) {
                //якщо вибрав архітектуру
                rs = dbConnection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + ((id_Lable) cbFromArch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
                fromArchId=((id_Lable) cbFromArch.getSelectionModel().getSelectedItem()).getDbid().intValue();
                ObservableList<id_Lable> items = FXCollections.observableArrayList();
                items.add(new id_Lable(-1, resourceBundle.getString("непривязані_паттерни")));
                fromModId=-1;
                while (rs.next()) {
                    id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                    items.add(tmp_lable);
                }
                cbFromLay.setItems(items);
                cbFromLay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                    @Override
                    public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                        lvFromList.setItems(FXCollections.observableArrayList());
                        from_mod_load();
                    }
                });
            } else {
                fromModId=-1;
                fromArchId=0;
                //якщо глобальні патерни
                fromListLoad("SELECT * FROM PATERNS WHERE TYPE='GLOBAL' ORDER BY NAME ASC");
                fromType = "GLOBAL";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_mod_load() {
        ResultSet rs = null;
        try {

            if (((id_Lable) cbFromLay.getSelectionModel().getSelectedItem()).getDbid().intValue() != -1) {
                //derby_DB
                rs = dbConnection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + ((id_Lable) cbFromLay.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");

                ObservableList<id_Lable> items = FXCollections.observableArrayList();
                while (rs.next()) {
                    id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                    items.add(tmp_lable);
                }
                cbFromMod.setItems(items);
                cbFromMod.valueProperty().addListener(new ChangeListener<id_Lable>() {
                    @Override
                    public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                        from_pat_load();
                    }
                });
            } else {
                //непривязані патерни


                cbFromMod.setItems(FXCollections.observableArrayList());
                fromListLoad("SELECT * FROM PATERNS WHERE MOD_ID=-1 AND ARCH_ID=" + ((id_Lable) cbFromArch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_pat_load() {
        //derby_DB
        fromListLoad("SELECT * FROM PATERNS WHERE MOD_ID=" + ((id_Lable) cbFromMod.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
        fromModId=((id_Lable) cbFromMod.getSelectionModel().getSelectedItem()).getDbid().intValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void to_lay_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = dbConnection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + ((id_Lable) cbToArch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            toArchId=((id_Lable) cbToArch.getSelectionModel().getSelectedItem()).getDbid().intValue();
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            cbToLay.setItems(items);
            cbToLay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    toList.setItems(FXCollections.observableArrayList());
                    to_mod_load();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void to_mod_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = dbConnection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + ((id_Lable) cbToLay.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            cbToMod.setItems(items);
            cbToMod.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    to_pat_load();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void to_pat_load() {
        //derby_DB
        to_list_load("SELECT * FROM PATERNS WHERE MOD_ID=" + ((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
        toModId=((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid().intValue();
    }

    /**
     * Зліва на право перемістити
     * звідки-куди
     */
    public void from_move_to() {
        if (lvFromList.getSelectionModel().getSelectedItem() != null) {
            if (cbToArch.getSelectionModel().getSelectedItem() != null) {
                Pattern from = Pattern.patternLoadFromDB(((id_Lable) lvFromList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection);
                Pattern new_p = new Pattern();
                new_p.setName(from.getName());
                if (cbToMod.getSelectionModel().getSelectedItem() != null) {
                    new_p.setModId(((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid());
                } else {
                    new_p.setModId(-1);
                }
                new_p.setUmlText(from.getUmlText());
                new_p.setDescription(from.getDescription());
                new_p.setPreview(from.getPreview());
                new_p.setArch_id(((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid());
                new_p.setType("");
                Pattern.pattern_save_to_DB(new_p, dbConnection);
                Pattern.delete_pattern_from_DB(from.getId(), dbConnection);
            }
        }
        fromListLoad(fromLastQuery);
        to_list_load(toLastQuery);
    }

    /**
     * Зліва направо скопіюввти
     * звідки-куди
     */
    public void from_copy_to() {
        if (lvFromList.getSelectionModel().getSelectedItem() != null) {
            if (cbToArch.getSelectionModel().getSelectedItem() != null) {
                Pattern from = Pattern.patternLoadFromDB(((id_Lable) lvFromList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection);
                Pattern new_p = new Pattern();
                new_p.setName(from.getName());
                if (cbToMod.getSelectionModel().getSelectedItem() != null) {
                    new_p.setModId(((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid());
                } else {
                    new_p.setModId(-1);
                }
                new_p.setUmlText(from.getUmlText());
                new_p.setDescription(from.getDescription());
                new_p.setPreview(from.getPreview());
                new_p.setArch_id(((id_Lable) cbToMod.getSelectionModel().getSelectedItem()).getDbid());
                new_p.setType("");

                Pattern.pattern_save_to_DB(new_p, dbConnection);
            }
        }
        fromListLoad(fromLastQuery);
        to_list_load(toLastQuery);
    }

    /**
     * Зправа на ліво перемістити
     * куди-звідки
     */
    public void to_move_from() {
    }

    /**
     * Зправа на ліво зкопіювати
     * куди-звідки
     */
    public void to_copy_from() {

    }

    public void from_list_delete() {
        if (lvFromList.getSelectionModel().getSelectedItem() != null) {
            Pattern.delete_pattern_from_DB(((id_Lable) lvFromList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection);
            fromListLoad(fromLastQuery);
        }
    }


    public void from_list_preview() {
        if (lvFromList.getSelectionModel().getSelectedItem() != null) {
            System.out.printf("");
        }
    }

    public void from_list_edit() {
        if (lvFromList.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/patern_editor.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            try {
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene((Pane) loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            patern_editor_C controller = loader.<patern_editor_C>getController();
            controller.initData(Pattern.patternLoadFromDB(((id_Lable) lvFromList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection), dbConnection);
            stage.setTitle("Редагування патерну");
            stage.show();
            //Stage stage_c = (Stage) TA_arch_description.getScene().getWindow();
            // do what you have to do
            //stage_c.close();
        }
    }

    public void from_list_add() {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/patern_editor.fxml"));

                Stage stage = new Stage(StageStyle.DECORATED);

                try {
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.setScene(new Scene((Pane) loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                patern_editor_C controller = loader.<patern_editor_C>getController();

//        Pattern(Integer id, Integer modId, String name, String description, String umlText, String type, Integer arch_id, Image preview) {
                controller.initData(new Pattern(null,fromModId,"","","", fromType, fromArchId,null), dbConnection);
                stage.setTitle("Редагування патерну");
                stage.show();
                //Stage stage_c = (Stage) TA_arch_description.getScene().getWindow();
                // do what you have to do
                //stage_c.close();
    }

    public void to_list_preview() {
        if (toList.getSelectionModel().getSelectedItem() != null) {

            System.out.printf("");
        }
    }

    public void to_list_edit() {
        if (toList.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/editor/views/patern_editor.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            try {
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene((Pane) loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            patern_editor_C controller = loader.<patern_editor_C>getController();
            controller.initData(Pattern.patternLoadFromDB(((id_Lable) toList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection), dbConnection);
            stage.setTitle("Редагування патерну");
            stage.show();
        }
    }


    public void to_list_delete() {
        if (toList.getSelectionModel().getSelectedItem() != null) {
            Pattern.delete_pattern_from_DB(((id_Lable) toList.getSelectionModel().getSelectedItem()).getDbid(), dbConnection);
            to_list_load(toLastQuery);
        }
    }
}
