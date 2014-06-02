package Classes;

import javax.swing.*;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Pattern implements Cloneable {
    private Integer id;
    private Integer mod_id;
    private String name;
    private String description;
    private String uml_text;
    private ImageIcon preview;

    public ImageIcon getPreview() {
        return preview;
    }

    public void setPreview(ImageIcon preview) {
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

        if (this.preview != null)
            p_return.preview = new ImageIcon(this.preview.getImage());
        else
            p_return.preview = null;

        return p_return;
    }

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


}
