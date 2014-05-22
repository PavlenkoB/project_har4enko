package editor.classes;

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;

import java.util.ArrayList;

/**
 * Created by godex_000 on 22.05.2014.
 */
public class Architecture_up extends Architecture {
    public ArrayList<Layer_up> arch_layers= new ArrayList<Layer_up>();
    public Architecture_up(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Architecture_up() {
    }
}
