package Classes;

import editor.classes.DerbyDBManager;
import editor.classes.result_info;
import editor.services.ImageConverter;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Pattern implements Cloneable {
    private Integer id;
    private Integer mod_id;
    private String name;
    private String description;
    private String uml_text;
    private String type;
    private Integer arch_id;


    private javafx.scene.image.Image preview;

    public Pattern() {
        this.id = null;
        this.mod_id = null;
        this.name = null;
        this.description = null;
        this.uml_text = null;
    }

    public Pattern(Integer id, Integer mod_id, String name, String description, String uml_text) {
        this.id = id;
        this.mod_id = mod_id;
        this.name = name;
        this.description = description;
        this.uml_text = uml_text;
    }

    public Pattern(Integer id, Integer mod_id, String name, String description, String uml_text, String type, Integer arch_id, Image preview) {
        this.id = id;
        this.mod_id = mod_id;
        this.name = name;
        this.description = description;
        this.uml_text = uml_text;
        this.type = type;
        this.arch_id = arch_id;
        this.preview = preview;
    }

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
            pattern_out.setArch_id(q_result.getInt("ARCH_ID"));
            pattern_out.setType("TYPE");

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

            if (pattern_out.getPreview() == null || pattern_out.getPreview().getHeight() < 20) {
                pattern_out.setPreview(new Image("editor/res/img/preview-not-available.jpg"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pattern_out;
    }

    /**
     * Зберіга патерн в базу
     *
     * @param pattern_in          Патерн яки1 потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static result_info pattern_save_to_DB(Pattern pattern_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        result_info result = new result_info();
        if (pattern_in.getId() == null||pattern_in.getId().toString().equals("")) {
            String query = "INSERT INTO PATERNS (MOD_ID,NAME,VALUE,DESCRIPTION,ARCH_ID,TYPE) VALUES (" + pattern_in.getMod_id() + ",'" + pattern_in.getName() + "','" + pattern_in.getUml_text() + "','" + pattern_in.getDescription() +"',"+pattern_in.getArch_id()+",'"+pattern_in.getType() +"')";
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
                    "SET MOD_ID=" + pattern_in.getMod_id() + ",NAME='" + pattern_in.getName() + "',VALUE='" + pattern_in.getUml_text() + "',DESCRIPTION='" + pattern_in.getDescription() + "',ARCH_ID="+pattern_in.getArch_id()+",TYPE='"+pattern_in.getType()+"' WHERE ID=" + pattern_in.getId();

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

    public static String pattern_uml_text_gen(Pattern pattern_in) {
        pattern_in.getName();
        String class_text = new String();
        class_text += "}\n";
        return class_text;
    }

    public javafx.scene.image.Image getPreview() {
        return preview;
    }

    public void setPreview(javafx.scene.image.Image preview) {
        this.preview = preview;
    }

    public Pattern clone() throws CloneNotSupportedException {
        Pattern p_return = (Pattern) super.clone();
        if (this.id != null)
            p_return.id = new Integer(this.id);
        else
            p_return.id = null;
        if (this.mod_id != null)
            p_return.mod_id = new Integer(this.mod_id);
        else
            p_return.mod_id = null;
        p_return.name = new String(this.name);
        p_return.description = new String(this.description);

        if (this.arch_id != null)
            p_return.arch_id = new Integer(this.arch_id);
        else
            p_return.arch_id = null;

        if (this.type != null)
            p_return.type = new String(this.type);
        else
            p_return.type = new String();
        if (this.preview != null)
            //TODO картинку тоже клонировать
            p_return.preview = this.preview;//new javafx.scene.image.Image(this.preview);
        else
            p_return.preview = null;

        return p_return;
    }

    public static void delete_pattern_from_DB(Integer pat_id,DerbyDBManager derby_DB_connection){
        try {
            derby_DB_connection.executeUpdate("DELETE FROM PATERNS WHERE ID="+pat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMod_id() {
        return mod_id;
    }

    public void setMod_id(Integer mod_id) {
        this.mod_id = mod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUml_text() {
        return uml_text;
    }

    public void setUml_text(String uml_text) {
        this.uml_text = uml_text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getArch_id() {
        return arch_id;
    }

    //TODO опис функції

    public void setArch_id(Integer arch_id) {
        this.arch_id = arch_id;
    }
}
