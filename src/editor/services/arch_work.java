package editor.services;

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import editor.classes.result_info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class arch_work {

    //TODO опис функції
    public static Architecture arch_load_from_DB(Integer arch_id, DerbyDBManager derby_DB_connection) {
        Architecture arch_out = new Architecture();
        ResultSet rs_arch, rs_lay, rs_mod, rs_pat = null;
        int s_lay = 0, s_mod = 0, s_pat = 0;
        try {
            rs_arch = derby_DB_connection.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + arch_id);
            rs_arch.next();
            arch_out = new Architecture(rs_arch.getInt("ID"), rs_arch.getString("NAME"), rs_arch.getString("DESCRIPTION"));
            arch_out.setUsecase(rs_arch.getString("USECASE"));
            /*Зчитати превю*/

            ImageIcon image = null;
            //TODO конект не тот(
            Connection con = DerbyDBManager.getCon();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + arch_id);
            if (rs.next()) {
                Blob photo = rs.getBlob("PREVIEW");
                if (photo != null) {
                    ObjectInputStream ois = null;
                    try {
                        ois = new ObjectInputStream(photo.getBinaryStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        image = (ImageIcon) ois.readObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    arch_out.setPreview(ImageConverter.AWTImgtoFXImg(image.getImage()));
                } else {
                    arch_out.setPreview(null);
                }
            }
            s.close();


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

    /**
     * Збаріга архітектуру в базу
     *
     * @param arch_in             Архітектура яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static result_info arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        result_info result = new result_info();
        try {
            ResultSet rs_tmp;
            if (arch_in.getDescription() == null) arch_in.setDescription("");
            if (arch_in.getUsecase() == null) arch_in.setUsecase("");
            if (arch_in.getId() == null || arch_in.getId() == 0) {//Добавить в базу
                //Нові патерни модулі і сама архітектура

                derby_DB_connection.executeUpdate("INSERT INTO ARCHITECTURE2 (NAME,USECASE,DESCRIPTION) VALUES ('" + arch_in.getName() + "','" + arch_in.getUsecase() + "','" + arch_in.getDescription() + "'");


                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM ARCHITECTURE");
                rs_tmp.next();
                arch_in.setId(rs_tmp.getInt(1));
                try {
                    save_arch_img_update(arch_in, derby_DB_connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                //якщо змінти дані про архітектуру
                derby_DB_connection.executeUpdate("UPDATE ARCHITECTURE " + "SET NAME='" + arch_in.getName() + "',USECASE='" + arch_in.getUsecase() + "',DESCRIPTION='" + arch_in.getDescription() + "' WHERE ID=" + arch_in.getId());
                try {
                    save_arch_img_update(arch_in, derby_DB_connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
                    if (arch_in.getLayers().get(s_lay).getId() == null || arch_in.getId() == 0) {
                        // Якщо шар новий то створити нові моудул і сам шар
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
                    } else {
                        // якщо змінили дані про шар
                        derby_DB_connection.executeUpdate("UPDATE LAYER " + "SET NAME='" + arch_in.getLayers().get(s_lay).getName() + "',ARCH_ID=" + arch_in.getId() + ",DESCRIPTION='" + arch_in.getLayers().get(s_lay).getDescription() + "' WHERE ID=" + arch_in.getLayers().get(s_lay).getId());
                        for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                            if (arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() == null || arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() == 0) {
                                // якщо модуль новий
                                derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                                rs_tmp.next();
                                arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                            } else {
                                // якщо модуль редагований
                                derby_DB_connection.executeUpdate("UPDATE MODULE " + "SET NAME='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "',DESCRIPTION='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "' WHERE ID=" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId());

                            }

                        }
                    }
                }
            }
            result.setStatus(true);
            System.out.printf("Arch save successful");
        } catch (SQLException e) {
            result.setComment(e);
            e.printStackTrace();
        }
        return result;
    }


    //TODO Удаления архитектуре вместе со всеми связями
    //TODO Сравнивать загруженую архитектуру с отправленой на сохранение на наличее мертвих связей в первой и удалять их с бази
    public static Architecture del_mod_from_layer(Architecture arch_in, Integer lay_pos, Integer mod_pos) {
        arch_in.getLayers().get(lay_pos).getModules().remove(mod_pos);
        return arch_in;
    }


    //TODO опис функції
    private static void save_arch_img_update(Architecture architecture, DerbyDBManager derbyDBManager) throws Exception {
        Connection con;
        con = derbyDBManager.getCon();

        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE ARCHITECTURE SET PREVIEW=" + "?" + " WHERE ID=" + architecture.getId());

        Blob blob = con.createBlob();
        ImageIcon ii = new ImageIcon(ImageConverter.FXimgToAWTimg(architecture.getPreview()));

        ObjectOutputStream oos;
        oos = new ObjectOutputStream(blob.setBinaryStream(1));
        oos.writeObject(ii);
        oos.close();
        ps.setBlob(1, blob);
        ps.execute();
        blob.free();
        ps.close();
    }

    //TODO опис функції

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


}
