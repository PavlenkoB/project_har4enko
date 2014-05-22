package editor.classes;

import Classes.Pattern;

public class Pattern_up extends Pattern {
    public String uml_text;
    public Pattern_up(Integer id, Integer mod_id, String name, String description, String uml_text) {
        this.id = id;
        this.mod_id = mod_id;
        this.name = name;
        this.description = description;
        this.uml_text = uml_text;
    }
}
