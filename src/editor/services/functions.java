package editor.services;

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by godex_000 on 22.05.2014.
 */
public class functions {
    public static Integer get_ID(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return Integer.parseInt(out_string);
    }

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

    public static String arch_uml_text_gen(Architecture architecture) {
        architecture.getName();
        String class_text = new String();
        class_text += "package \"" + architecture.getName() + "\"{\n";
        for (int s_lay = 0; s_lay < architecture.getLayers().size(); s_lay++) {
            class_text += "package \"" + architecture.getLayers().get(s_lay).getName() + "\"{\n";
            for (int s_mod = 0; s_mod < architecture.getLayers().get(s_lay).getModules().size(); s_mod++) {
                class_text += "package \"" + architecture.getLayers().get(s_lay).getModules().get(s_mod).getName() + "\"{\n";
                if (architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelected_patern() != null)
                    class_text += architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelected_patern().getUml_text() + "\n";
                class_text += "}\n";
            }
            class_text += "}\n";
        }
        class_text += "}\n";
        return class_text;
    }

    public static Architecture arch_load_from_DB(Integer arch_id, DerbyDBManager derby_DB_connection) {
        Architecture arch_out = new Architecture();
        ResultSet rs_arch, rs_lay, rs_mod, rs_pat = null;
        int s_lay = 0, s_mod = 0, s_pat = 0;
        try {
            rs_arch = derby_DB_connection.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + arch_id);
            rs_arch.next();
            arch_out = new Architecture(rs_arch.getInt("ID"), rs_arch.getString("NAME"), rs_arch.getString("DESCRIPTION"));
            arch_out.setUsecase(rs_arch.getString("USECASE"));
            Blob photo = rs_arch.getBlob("PREVIEW");
            ObjectInputStream ois = null;
            try {
                if (photo!=null) {
                    ois = new ObjectInputStream(photo.getBinaryStream());
                    arch_out.setPreview((ImageIcon) ois.readObject());
                }else {
                    arch_out.setPreview(new ImageIcon());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //Выбрать все Слои даной архитектуры
            rs_lay = derby_DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + arch_id);
            while (rs_lay.next()) {
                arch_out.getLayers().add(new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                rs_mod = derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                s_mod = 0;
                while (rs_mod.next()) {
                    arch_out.getLayers().get(s_lay).getModules().add(new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    rs_pat = derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    ObservableList<String> items = FXCollections.observableArrayList();
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        arch_out.getLayers().get(s_lay).getModules().get(s_mod).getAvilable_paterns().add(new Pattern(rs_pat.getInt("ID"), rs_pat.getInt("MOD_ID"), rs_pat.getString("NAME"), rs_pat.getString("DESCRIPTION"), rs_pat.getString("VALUE")));
                        items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                    }
                    s_mod++;
                }
                s_lay++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Arch load end");
        return arch_out;
    }

    public static boolean arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) throws SQLException {//Зберегти архітектуру в БД
        boolean result = false;
        ResultSet rs_tmp;
        if(arch_in.getDescription()==null)arch_in.setDescription("");
        if(arch_in.getUsecase()==null)arch_in.setUsecase("");
        if (arch_in.getId() == null || arch_in.getId() == 0) {//Добавить в базу
            //TODO Нові патерни модулі і сама архітектура
            derby_DB_connection.executeUpdate("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION,PREVIEW) VALUES ('" + arch_in.getName() + "','" + arch_in.getUsecase() + "','" + arch_in.getDescription() + "','"+arch_in.getPreview()+"')");
            rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM ARCHITECTURE");
            rs_tmp.next();
            arch_in.setId(rs_tmp.getInt(1));
            for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
                derby_DB_connection.executeUpdate("INSERT INTO LAYER (ARCH_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getId() + ",'" + arch_in.getLayers().get(s_lay).getName() + "','" + arch_in.getLayers().get(s_lay).getDescription() + "')");
                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM LAYER");
                rs_tmp.next();
                arch_in.getLayers().get(s_lay).setId(rs_tmp.getInt(1));
                for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                    derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                    rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                    rs_tmp.next();
                    arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                }
            }
        } else {
            //TODO якщо змінти дані про архітектуру
            derby_DB_connection.executeUpdate("UPDATE ARCHITECTURE " + "SET NAME='" + arch_in.getName() + "',USECASE='" + arch_in.getUsecase() + "',DESCRIPTION='" + arch_in.getDescription() + "',PREVIEW='"+arch_in.getPreview()+"' WHERE ID=" + arch_in.getId());
            for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
                if(arch_in.getLayers().get(s_lay).getId()==null|| arch_in.getId()==0) {
                    //TODO Якщо шар новий то створити нові моудул і сам шар
                    derby_DB_connection.executeUpdate("INSERT INTO LAYER (ARCH_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getId() + ",'" + arch_in.getLayers().get(s_lay).getName() + "','" + arch_in.getLayers().get(s_lay).getDescription() + "')");
                    rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM LAYER");
                    rs_tmp.next();
                    arch_in.getLayers().get(s_lay).setId(rs_tmp.getInt(1));
                    for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                        derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                        rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                        rs_tmp.next();
                        arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                    }
                }else {
                    //TODO якщо змінили дані про шар
                    derby_DB_connection.executeUpdate("UPDATE LAYER " + "SET NAME='" + arch_in.getLayers().get(s_lay).getName() + "',ARCH_ID=" + arch_in.getId() + ",DESCRIPTION='" + arch_in.getLayers().get(s_lay).getDescription() + "' WHERE ID=" + arch_in.getLayers().get(s_lay).getId());
                    for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                        if(arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId()==null||arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId()==0){
                            //TODO якщо модуль новий
                            derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                            rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                            rs_tmp.next();
                            arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                        }else {
                            //TODO якщо модуль редагований
                            derby_DB_connection.executeUpdate("UPDATE MODULE " + "SET NAME='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "',DESCRIPTION='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "' WHERE ID=" +  arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId());

                        }

                    }
                }
            }
        }
        System.out.printf("Arch save successful");
        return result;
    }

    //TODO Удаления архитектуре вместе со всеми связями
    //TODO Сравнивать загруженую архитектуру с отправленой на сохранение на наличее мертвих связей в первой и удалять их с бази
    public static Architecture del_mod_from_layer(Architecture arch_in, Integer lay_pos, Integer mod_pos) {
        arch_in.getLayers().get(lay_pos).getModules().remove(mod_pos);
        return arch_in;
    }
}
