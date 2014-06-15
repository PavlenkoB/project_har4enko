package editor.services;

import Classes.Pattern;
import editor.classes.DerbyDBManager;
import editor.classes.result_info;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class pattern_work {
    //TODO опис функції
    public static Pattern pattern_load_from_DB(Integer pattern_id, DerbyDBManager derby_DB_connection) {
        Pattern pattern_out = new Pattern();
        String query = "SELECT * FROM PATERNS WHERE ID=" + pattern_id.toString();
        ResultSet q_result;
        try {
            q_result = derby_DB_connection.executeQuery(query);
            q_result.next();
            pattern_out.setId(pattern_id);
            pattern_out.setMod_id(q_result.getInt("MOD_ID"));
            pattern_out.setName(q_result.getString("NAME"));
            pattern_out.setUml_text(q_result.getString("VALUE"));
            pattern_out.setDescription(q_result.getString("DESCRIPTION"));

            /*Зчитати превю*/

            ImageIcon image = null;
            //TODO конект не тот(
            Connection con = DerbyDBManager.getCon();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM PATERNS WHERE ID=" + pattern_id);
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
                    pattern_out.setPreview(ImageConverter.AWTImgtoFXImg(image.getImage()));
                } else {
                    pattern_out.setPreview(null);
                }
            }
            s.close();

            if (pattern_out.getPreview() == null||pattern_out.getPreview().getHeight()<20) {
                pattern_out.setPreview(new Image("editor/res/img/preview-not-available.jpg"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pattern_out;
    }

    /**
     * Збаріга архітектуру в базу
     *
     * @param pattern_in          Патерн яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static result_info pattern_save_to_DB(Pattern pattern_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        result_info result = new result_info();
        if (pattern_in.getId() == null) {
            String query = "INSERT INTO PATERNS (MOD_ID,NAME,VALUE,DESCRIPTION,PREVIEW) VALUES (" + pattern_in.getMod_id() + ",'" + pattern_in.getName() + "','" + pattern_in.getUml_text() + "','" + pattern_in.getDescription() + "')";
            ResultSet rs_tmp;
            try {
                derby_DB_connection.executeUpdate(query);
                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM ARCHITECTURE");
                rs_tmp.next();
                pattern_in.setId(rs_tmp.getInt(1));
                try {
                    save_pattern_img_update(pattern_in, derby_DB_connection);
                    result.setStatus(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String query = "UPDATE PATERNS " +//TODO ДО какого модуля
                    "SET MOD_ID=" + pattern_in.getMod_id() + ",NAME='" + pattern_in.getName() + "',VALUE='" + pattern_in.getUml_text() + "',DESCRIPTION='" + pattern_in.getDescription() + "' WHERE ID=" + pattern_in.getId();

            try {
                derby_DB_connection.executeUpdate(query);
                try {
                    save_pattern_img_update(pattern_in, derby_DB_connection);
                    result.setStatus(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    //TODO опис функції
    private static void save_pattern_img_update(Pattern pattern_in, DerbyDBManager derbyDBManager) throws Exception {
        Connection con;
        con = derbyDBManager.getCon();

        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE PATERNS SET PREVIEW=" + "?" + " WHERE ID=" + pattern_in.getId());

        Blob blob = con.createBlob();
        ImageIcon ii = new ImageIcon(ImageConverter.FXimgToAWTimg(pattern_in.getPreview()));

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

    public static String pattern_uml_text_gen(Pattern pattern_in) {
        pattern_in.getName();
        String class_text = new String();
        class_text += "}\n";
        return class_text;
    }
}
