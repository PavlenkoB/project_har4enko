package ua.edu.nau.godex.projectharchenko.classes;


import ua.edu.nau.godex.projectharchenko.editor.classes.DerbyDBManager;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Layer implements Cloneable {
    private Integer id;
    private Integer archId;
    private String name;
    private String description;
    private Integer id_done;
    private ArrayList<Module> modules = new ArrayList<>();

    public Layer(Integer id, Integer archId, String name, String description) {
        this.id = id;
        this.archId = archId;
        this.name = name;
        this.description = description;
    }

    public Layer(Integer id, Integer archId, String name, String description, Integer id_done, ArrayList<Module> modules) {
        this.id = id;
        this.archId = archId;
        this.name = name;
        this.description = description;
        this.id_done = id_done;
        this.modules = modules;
    }

    public Layer() {
    }

    public static Layer load_layer_from_DB(Integer layer_id, DerbyDBManager dbManager) {
        Layer layer = new Layer();
        try {
            ResultSet rs_arch = dbManager.executeQuery("SELECT * FROM LAYER WHERE ID=" + layer_id);
            rs_arch.next();
            layer.setId(rs_arch.getInt("ID"));
            layer.setArchId(rs_arch.getInt("ARCH_ID"));
            layer.setName(rs_arch.getString("NAME"));
            layer.setDescription(rs_arch.getString("DESCRIPTION"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return layer;
    }

    public Layer clone() throws CloneNotSupportedException {
        Layer l_return = (Layer) super.clone();
        if (this.id != null)
            l_return.id = new Integer(this.id);
        else
            l_return.id = null;
        if (this.archId != null)
            l_return.archId = new Integer(this.archId);
        else
            l_return.archId = null;

        l_return.name = new String(this.name);
        l_return.description = new String(this.description);

        if (this.id_done != null)
            l_return.id_done = new Integer(this.id_done);
        else
            l_return.id_done = null;

        ArrayList<Module> modules = new ArrayList<Module>(this.modules.size());
        for (Module item : this.modules) modules.add(item.clone());
        l_return.modules = modules;

        return l_return;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArchId() {
        return archId;
    }

    public void setArchId(Integer archId) {
        this.archId = archId;
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

    public Integer getId_done() {
        return id_done;
    }

    public void setId_done(Integer id_done) {
        this.id_done = id_done;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
