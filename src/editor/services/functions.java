package editor.services;

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

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
    public static String arch_uml_text_gen(Architecture architecture){
        architecture.getName();
        String class_text = new String();
        class_text += "package \"" + architecture.name + "\"{\n";
        for (int s_lay = 0; s_lay < architecture.layers.size(); s_lay++) {
            class_text += "package \"" +architecture.layers.get(s_lay).name+ "\"{\n";
            for (int s_mod = 0; s_mod < architecture.layers.get(s_lay).modules.size(); s_mod++) {
                class_text += "package \"" +architecture.layers.get(s_lay).modules.get(s_mod).name+ "\"{\n";
                if(architecture.layers.get(s_lay).modules.get(s_mod).selected_patern!=null)
                    class_text +=architecture.layers.get(s_lay).modules.get(s_mod).selected_patern.uml_text+"\n";
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
            arch_out.usecase = rs_arch.getString("USECASE");

            //Выбрать все Слои даной архитектуры
            rs_lay = derby_DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + arch_id);
            while (rs_lay.next()) {
                arch_out.layers.add(new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                rs_mod = derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                s_mod=0;
                while (rs_mod.next()) {
                    arch_out.layers.get(s_lay).modules.add(new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    rs_pat = derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    ObservableList<String> items = FXCollections.observableArrayList();
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        arch_out.layers.get(s_lay).modules.get(s_mod).avilable_paterns.add(new Pattern(rs_pat.getInt("ID"), rs_pat.getInt("MOD_ID"), rs_pat.getString("NAME"), rs_pat.getString("DESCRIPTION"), rs_pat.getString("VALUE")));
                        //items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
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
    public static boolean arch_save_to_DB(Architecture arch_in,DerbyDBManager derby_DB_connection) throws SQLException {//Зберегти архітектуру в БД
        boolean result=false;
        ResultSet rs_tmp;
        if(arch_in.getId()==null||arch_in.getId()==0){//Добавить в базу
            derby_DB_connection.executeUpdate("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES ('" + arch_in.name + "','" + arch_in.usecase + "','" + arch_in.description + "')");
            rs_tmp= derby_DB_connection.executeQuery("SELECT MAX(ID) FROM ARCHITECTURE");
            rs_tmp.next();
            arch_in.id=rs_tmp.getInt(1);
        }else{
            //TODO якщо змінти дані про архітектуру
        }
            for(int s_lay=0;s_lay<arch_in.layers.size();s_lay++){
                if(arch_in.layers.get(s_lay).id==null){
                    derby_DB_connection.executeUpdate("INSERT INTO LAYER (ARCH_ID,NAME,DESCRIPTION) VALUES (" + arch_in.id + ",'" + arch_in.layers.get(s_lay).name + "','" + arch_in.layers.get(s_lay).description + "')");
                }else{
                    //TODO якщо змінити шар
                }
                for(int s_mod=0;s_mod<arch_in.layers.get(s_lay).modules.size();s_mod++){
                    //TODO Обробка модулів
                }
            }

        return result;
    }
    public static Architecture del_mod_from_layer(Architecture arch_in, Integer lay_pos, Integer mod_pos){
        arch_in.layers.get(lay_pos).modules.remove(mod_pos);
        return arch_in;
    }
}
