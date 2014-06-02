package Classes;


import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Layer implements Cloneable {
    private Integer id;
    private Integer arch_id;
    private String name;
    private String description;
    private Integer id_done;
    private ArrayList<Module> modules = new ArrayList<>();

    public Layer clone() throws CloneNotSupportedException {
        Layer l_return = (Layer) super.clone();
        if (this.id != null)
            l_return.id = new Integer(this.id);
        else
            l_return.id = null;
        if (this.arch_id != null)
            l_return.arch_id = new Integer(this.arch_id);
        else
            l_return.arch_id = null;

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

    public Layer(Integer id, Integer arch_id, String name, String description) {
        this.id = id;
        this.arch_id = arch_id;
        this.name = name;
        this.description = description;
    }

    public Layer(Integer id, Integer arch_id, String name, String description, Integer id_done, ArrayList<Module> modules) {
        this.id = id;
        this.arch_id = arch_id;
        this.name = name;
        this.description = description;
        this.id_done = id_done;
        this.modules = modules;
    }

    public Layer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArch_id() {
        return arch_id;
    }

    public void setArch_id(Integer arch_id) {
        this.arch_id = arch_id;
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
