package editor.classes;

import Classes.Layer;

import java.util.ArrayList;

public class Layer_up extends Layer {
    public ArrayList<Module_up> modules=new ArrayList<Module_up>();
    public Layer_up(Integer id, Integer arch_id, String name, String description) {
        this.id = id;
        this.arch_id = arch_id;
        this.name = name;
        this.description = description;
    }
}
