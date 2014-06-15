package editor.services;

import Classes.Architecture;
import Classes.Task;
import editor.classes.DerbyDBManager;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by godex_000 on 22.05.2014.
 */
public class functions {
    //TODO опис функції
    public static Integer get_ID(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return Integer.parseInt(out_string);
    }
    //TODO опис функції

    public static String get_NAME(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            line_pos++;
        }
        line_pos++;
        while (line_pos < in_string.length()) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }

    //TODO опис функції
    public static boolean task_done_save_to_DB(Task task, DerbyDBManager derby_DB_connection) {
        boolean result = false;
        try {
            derby_DB_connection.executeUpdate("INSERT INTO TASK (NAME,DESCRIPTION) VALUES ('" + task.getName() + "','" + task.getDescription() + "')");
            task.setId(last_id_from_table_DB("TASK", derby_DB_connection));
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Отримати максимальний(останій) ID з таблиці
     *
     * @param table_name          Імя таблиці
     * @param derby_DB_connection Підключення до БД
     * @return максимальни ID з таблиці
     */
    public static Integer last_id_from_table_DB(String table_name, DerbyDBManager derby_DB_connection) {
        Integer last_id = null;
        ResultSet rs_tmp;
        try {
            rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM " + table_name);
            rs_tmp.next();
            last_id = rs_tmp.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last_id;
    }

    //TODO опис функції
    public static boolean arch_done_save_to_DB(int task_id, Architecture arch_in, DerbyDBManager derby_DB_connection) throws SQLException {//Зберегти архітектуру в БД
        boolean result = false;
        ResultSet rs_tmp;
        if (arch_in.getDescription() == null) arch_in.setDescription("");
        if (arch_in.getUsecase() == null) arch_in.setUsecase("");
        //Добавить в базу
        //TODO Нові патерни модулі і сама архітектура
        derby_DB_connection.executeUpdate("INSERT INTO ARCH_DONE (TASK_ID,ARCH_ID) VALUES (" + task_id + "," + arch_in.getId() + ")");
        arch_in.setId_done(functions.last_id_from_table_DB("ARCH_DONE", derby_DB_connection));

        for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
            derby_DB_connection.executeUpdate("INSERT INTO LAY_DONE (ARCH_DONE_ID,LAY_ID) VALUES (" + arch_in.getId_done() + "," + arch_in.getLayers().get(s_lay).getId() + ")");
            arch_in.getLayers().get(s_lay).setId_done(functions.last_id_from_table_DB("LAY_DONE", derby_DB_connection));
            for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                derby_DB_connection.executeUpdate("INSERT INTO MODULE_DONE (LAY_DONE_ID,MOD_ID,PATTERN_ID) VALUES (" + arch_in.getLayers().get(s_lay).getId_done() + "," + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() + "," + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getSelected_patern().getId() + ")");
                arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId_done(functions.last_id_from_table_DB("MODULE_DONE", derby_DB_connection));
            }
        }

        System.out.printf("Arch save successful");
        return result;
    }
    public static Stage get_stage_by_element(Node element) {
        return (Stage) element.getScene().getWindow();
    }
}
