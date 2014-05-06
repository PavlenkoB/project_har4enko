package Classes;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Architecture {
    public Integer id;
    public String name;
    public Layer[] layers;
    public String description;
    public Integer id_done;
    public Integer task_id;

    public Architecture() {
        this.id = 0;
        this.name = null;
        this.layers = null;
        this.description = null;
        this.id_done = 0;
        this.task_id = 0;
    }

    public Architecture(Integer id, String name, Layer[] layers, String description, Integer id_done, Integer task_id) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
        this.id_done = id_done;
        this.task_id = task_id;
    }

    public Architecture(Integer id, String name, Layer[] layers, String description) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
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

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

}


