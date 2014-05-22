package editor.classes;

import Classes.Module;

import java.util.ArrayList;

public class Module_up extends Module {
    public ArrayList<Pattern_up> avilable_paterns= new ArrayList<Pattern_up>();//патерни доступні цьому модулю
    public Pattern_up selected_patern;//Вибраний патерн
    public Module_up(Integer id, Integer lay_id, String name,String description){
        this.id = id;
        this.lay_id = lay_id;
        this.description = description;
        this.name = name;
    }
    public void add_pattern (Pattern_up add_pat){
        this.avilable_paterns.add(add_pat);
    }

    public Pattern_up getSelected_patern() {
        return selected_patern;
    }

    public void setSelected_patern(Pattern_up selected_patern) {
        this.selected_patern = selected_patern;
    }
}
