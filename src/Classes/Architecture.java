package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Architecture implements Cloneable {
    public Integer id;
    public String name;
    public ArrayList<Layer> layers= new ArrayList<Layer>();
    public String description;
    public Integer id_done;
    public Integer task_id;
    public String usecase;

    public Architecture clone() throws CloneNotSupportedException {
        Architecture a_return = (Architecture)super.clone();
        if (this.id != null)
            a_return.id = new Integer(this.id);
        else
            a_return.id = null;
        a_return.name=new String(this.name);

        ArrayList<Layer> layers = new ArrayList<Layer>(this.layers.size());
        for(Layer item: this.layers) layers.add(item.clone());
        a_return.layers= layers;

        a_return.description=new String(this.description);
        if (this.id_done != null)
            a_return.id_done = new Integer(this.id_done);
        else
            a_return.id_done = null;
        if (this.task_id != null)
            a_return.task_id = new Integer(this.task_id);
        else
            a_return.task_id = null;
        if (this.usecase != null)
            a_return.usecase = new String(this.usecase);
        else
            a_return.usecase = null;

        return a_return;
    }


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


