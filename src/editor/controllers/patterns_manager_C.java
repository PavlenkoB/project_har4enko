package editor.controllers;

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
public class patterns_manager_C implements Initializable {
    public ComboBox CB_from_arch;
    public ComboBox CB_from_lay;
    public ComboBox CB_from_mod;
    public ComboBox CB_to_arch;
    public ComboBox CB_to_lay;
    public ComboBox CB_to_mod;
    public ListView from_list;
    public ListView to_list;
    public BorderPane root;
    DerbyDBManager DB_connection;
    private String from_last_query, to_last_query;

    void initData(final DerbyDBManager derbyDBManager) {
        DB_connection = derbyDBManager;
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM ARCHITECTURE ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            items.add(new id_Lable(-1, "Глобальні паттерни"));
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_from_arch.setItems(items);

            CB_from_arch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    CB_from_mod.setItems(FXCollections.observableArrayList());
                    from_list.setItems(FXCollections.observableArrayList());
                    from_lay_load();
                }
            });
            CB_to_arch.setItems(items);
            CB_to_arch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    CB_to_mod.setItems(FXCollections.observableArrayList());
                    to_list.setItems(FXCollections.observableArrayList());
                    to_lay_load();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }/**/


        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/editor/res/img/uml_icon.png"));
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Object[] options = {"Так",
                        "Ні"};
                int n = JOptionPane.showOptionDialog(null,
                        "Ви впевнені що бажаете вийти незбережені зміни буде втрачено?",
                        "Увага",
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
    private void from_list_load(String Query) {
        try {
            ResultSet rs = null;
            rs = DB_connection.executeQuery(Query);
            from_last_query = Query;
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            from_list.setItems(items);
            from_list.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
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
            rs = DB_connection.executeQuery(Query);
            to_last_query = Query;
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            to_list.setItems(items);

            to_list.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
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
            if (((id_Lable) CB_from_arch.getSelectionModel().getSelectedItem()).getDbid().intValue() != -1) {
                //якщо вибрав архітектуру

                rs = DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + ((id_Lable) CB_from_arch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
                ObservableList<id_Lable> items = FXCollections.observableArrayList();
                items.add(new id_Lable(-1, "Непривязані паттерни"));
                while (rs.next()) {
                    id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                    items.add(tmp_lable);
                }
                CB_from_lay.setItems(items);
                CB_from_lay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                    @Override
                    public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                        from_list.setItems(FXCollections.observableArrayList());
                        from_mod_load();
                    }
                });
            } else {
                //якщо глобальні патерни
                from_list_load("SELECT * FROM PATERNS WHERE TYPE='GLOBAL' ORDER BY NAME ASC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_mod_load() {
        ResultSet rs = null;
        try {

            if (((id_Lable) CB_from_lay.getSelectionModel().getSelectedItem()).getDbid().intValue() != -1) {
                //derby_DB
                rs = DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + ((id_Lable) CB_from_lay.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
                ObservableList<id_Lable> items = FXCollections.observableArrayList();
                while (rs.next()) {
                    id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                    items.add(tmp_lable);
                }
                CB_from_mod.setItems(items);
                CB_from_mod.valueProperty().addListener(new ChangeListener<id_Lable>() {
                    @Override
                    public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                        from_pat_load();
                    }
                });
            } else {
                //непривязані патерни

                CB_from_mod.setItems(FXCollections.observableArrayList());
                from_list_load("SELECT * FROM PATERNS WHERE MOD_ID=-1 AND ARCH_ID=" + ((id_Lable) CB_from_arch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_pat_load() {
        //derby_DB
        from_list_load("SELECT * FROM PATERNS WHERE MOD_ID=" + ((id_Lable) CB_from_mod.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void to_lay_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + ((id_Lable) CB_to_arch.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_to_lay.setItems(items);
            CB_to_lay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    to_list.setItems(FXCollections.observableArrayList());
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
            rs = DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + ((id_Lable) CB_to_lay.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_to_mod.setItems(items);
            CB_to_mod.valueProperty().addListener(new ChangeListener<id_Lable>() {
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
        to_list_load("SELECT * FROM PATERNS WHERE MOD_ID=" + ((id_Lable) CB_to_mod.getSelectionModel().getSelectedItem()).getDbid().intValue() + " ORDER BY NAME ASC");
    }

    /**
     * Зліва на право перемістити
     * звідки-куди
     */
    public void from_move_to() {
    }

    /**
     * Зліва направо скопіюввти
     * звідки-куди
     */
    public void from_copy_to() {

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


}
