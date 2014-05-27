package Classes;

import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Architecture {
    public Integer id;
    public String name;
    public ArrayList<Layer> layers= new ArrayList<Layer>();
    public String description;
    public Integer id_done;
    public Integer task_id;
    public String usecase;

    public Architecture() {
        this.id = 0;
        this.name = new String();
        this.layers = null;
        this.description = new String();
        this.id_done = 0;
        this.task_id = 0;
        this.usecase = null;
    }
    public Architecture(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Architecture(Integer id, String name, ArrayList<Layer> layers, String description, Integer id_done, Integer task_id) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
        this.id_done = id_done;
        this.task_id = task_id;
    }


    public Architecture(Integer id, String name, ArrayList<Layer> layers, String description, String usecase) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
        this.usecase = usecase;
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

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public void setLayers(ArrayList<Layer> layers) {
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

    public String getUsecase() {
        return usecase;
    }

    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }

}


