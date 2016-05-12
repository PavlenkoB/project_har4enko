package ua.edu.nau.godex.projectharchenko.classes;

import javafx.scene.image.Image;
import ua.edu.nau.godex.projectharchenko.editor.classes.DerbyDBManager;
import ua.edu.nau.godex.projectharchenko.editor.classes.resultInfo;
import ua.edu.nau.godex.projectharchenko.editor.services.ImageConverter;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Pattern implements Cloneable {
    public static final String SOME_CONST = "";
    private Integer id;
    private Integer modId;
    private String name;
    private String description;
    private String umlText;
    private String type;

    private Integer arch_id;
    private javafx.scene.image.Image preview;

    public Pattern() {
        this.id = null;
        this.modId = null;
        this.name = null;
        this.description = null;
        this.umlText = null;
    }

    public Pattern(Integer id, Integer modId, String name, String description, String umlText) {
        this.id = id;
        this.modId = modId;
        this.name = name;
        this.description = description;
        this.umlText = umlText;
    }

    public Pattern(Integer id, Integer modId, String name, String description, String umlText, String type, Integer arch_id, Image preview) {
        this.id = id;
        this.modId = modId;
        this.name = name;
        this.description = description;
        this.umlText = umlText;
        this.type = type;
        this.arch_id = arch_id;
        this.preview = preview;
    }

    public static Pattern patternLoadFromDB(Integer pattern_id, DerbyDBManager derby_DB_connection) {
        Pattern pattern_out = new Pattern();
        String query = "SELECT * FROM PATERNS WHERE ID=" + pattern_id.toString();
        ResultSet q_result;
        try {
            q_result = derby_DB_connection.executeQuery(query);
            q_result.next();
            pattern_out.setId(pattern_id);
            pattern_out.setModId(q_result.getInt("MOD_ID"));
            pattern_out.setName(q_result.getString("NAME"));
            pattern_out.setUmlText(q_result.getString("VALUE"));
            pattern_out.setDescription(q_result.getString("DESCRIPTION"));
            pattern_out.setArch_id(q_result.getInt("ARCH_ID"));
            pattern_out.setType(q_result.getString("TYPE"));

            /*Зчитати превю*/

            ImageIcon image = null;
            //TODO конект не тот(
            Connection con = derby_DB_connection.getCon();
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

            if (pattern_out.getPreview() == null) {
                pattern_out.setPreview(new Image("res/img/preview-not-available.jpg"));
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
    public static resultInfo pattern_save_to_DB(Pattern pattern_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        resultInfo result = new resultInfo();
        if (pattern_in.getId() == null || pattern_in.getId().toString().equals("")) {
            ResultSet rs_tmp;
            try {
                PreparedStatement preparedStatement = derby_DB_connection.getCon().prepareStatement("INSERT INTO PATERNS (MOD_ID,NAME,VALUE,DESCRIPTION,ARCH_ID,TYPE) VALUES (?,?,?,?,?,?)");
                preparedStatement.setInt(1, pattern_in.getModId());
                preparedStatement.setString(2, pattern_in.getName());
                preparedStatement.setString(3, pattern_in.getUmlText());
                preparedStatement.setString(4, pattern_in.getDescription());
                preparedStatement.setInt(5, pattern_in.getArch_id());
                preparedStatement.setString(6, pattern_in.getType());
                preparedStatement.executeUpdate();

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
            try {
                PreparedStatement preparedStatement = derby_DB_connection.getCon().prepareStatement("UPDATE PATERNS SET MOD_ID=?,NAME=?,VALUE=?,DESCRIPTION=?,ARCH_ID=?,TYPE=? WHERE ID=?");
                preparedStatement.setInt(1, pattern_in.getModId());
                preparedStatement.setString(2, pattern_in.getName());
                preparedStatement.setString(3, pattern_in.getUmlText());
                preparedStatement.setString(4, pattern_in.getDescription());
                preparedStatement.setInt(5, pattern_in.getArch_id());
                preparedStatement.setString(6, pattern_in.getType());
                preparedStatement.setInt(7, pattern_in.getId());
                preparedStatement.executeUpdate();
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

    public static void delete_pattern_from_DB(Integer pat_id, DerbyDBManager derby_DB_connection) {
        try {
            derby_DB_connection.executeUpdate("DELETE FROM PATERNS WHERE ID=" + pat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            p_return.id = (int) this.id;
        else
            p_return.id = null;
        if (this.modId != null)
            p_return.modId = new Integer(this.modId);
        else
            p_return.modId = null;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
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

    public String getUmlText() {
        return umlText;
    }

    public void setUmlText(String umlText) {
        this.umlText = umlText;
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
