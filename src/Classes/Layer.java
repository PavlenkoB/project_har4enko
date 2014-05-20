package Classes;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Layer {
    public Integer id;
    public Integer arch_id;
    public String name;
    public String description;
    public Integer id_done;
    public Module[] modules;

    public Layer(Integer id, Integer arch_id, String name, String description) {
        this.id = id;
        this.arch_id = arch_id;
        this.name = name;
        this.description = description;
    }

    public Layer(Integer id, Integer arch_id, String name, String description, Integer id_done, Module[] modules) {
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

    public Module[] getModules() {
        return modules;
    }

    public void setModules(Module[] modules) {
        this.modules = modules;
    }
}
