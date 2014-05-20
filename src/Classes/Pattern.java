package Classes;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Pattern {
    public Integer id;
    public Integer mod_id;
    public String name;
    public String description;
    public String table;

    public Pattern(Integer id, Integer mod_id, String name, String description, String table) {
        this.id = id;
        this.mod_id = mod_id;
        this.name = name;
        this.description = description;
        this.table = table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMod_id() {
        return mod_id;
    }

    public void setMod_id(Integer mod_id) {
        this.mod_id = mod_id;
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

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }



}
