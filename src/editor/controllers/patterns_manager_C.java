package editor.controllers;

import editor.classes.DerbyDBManager;
import editor.classes.id_Lable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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
    DerbyDBManager DB_connection;

    void initData(DerbyDBManager derbyDBManager) {
        DB_connection = derbyDBManager;
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM ARCHITECTURE ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_from_arch.setItems(items);

            CB_from_arch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    from_lay_load();
                    CB_from_mod.setItems(FXCollections.observableArrayList());
                    from_list.setItems(FXCollections.observableArrayList());
                }
            });
            CB_to_arch.setItems(items);
            CB_to_arch.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    to_lay_load();
                    CB_to_mod.setItems(FXCollections.observableArrayList());
                    to_list.setItems(FXCollections.observableArrayList());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }/**/
    }

    private void from_lay_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID="+((id_Lable)CB_from_arch.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_from_lay.setItems(items);
            CB_from_lay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    from_mod_load();
                    from_list.setItems(FXCollections.observableArrayList());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_mod_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID="+((id_Lable)CB_from_lay.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void from_pat_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID="+((id_Lable)CB_from_mod.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void to_lay_load() {
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID="+((id_Lable)CB_to_arch.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
            ObservableList<id_Lable> items = FXCollections.observableArrayList();
            while (rs.next()) {
                id_Lable tmp_lable = new id_Lable(rs.getInt("ID"), rs.getString("NAME"));
                items.add(tmp_lable);
            }
            CB_to_lay.setItems(items);
            CB_to_lay.valueProperty().addListener(new ChangeListener<id_Lable>() {
                @Override
                public void changed(ObservableValue ov, id_Lable t, id_Lable t1) {
                    to_mod_load();
                    to_list.setItems(FXCollections.observableArrayList());
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
            rs = DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID="+((id_Lable)CB_to_lay.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
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
        ResultSet rs = null;
        try {
            //derby_DB
            rs = DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID="+((id_Lable)CB_to_mod.getSelectionModel().getSelectedItem()).getDbid().intValue()+" ORDER BY NAME ASC");
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


}
