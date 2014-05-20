package Classes;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Module {
    public Integer id;
    public Integer lay_id;
    public String description;
    public String name;
    public Pattern[] patterns;
    public Integer id_done;

    public Module(Integer id, Integer lay_id, String description, String name) {
        this.id = id;
        this.lay_id = lay_id;
        this.description = description;
        this.name = name;
    }

    public Module(Integer id, Integer lay_id, String description, String name, Pattern[] patterns, Integer id_done) {
        this.id = id;
        this.lay_id = lay_id;
        this.description = description;
        this.name = name;
        this.patterns = patterns;
        this.id_done = id_done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLay_id() {
        return lay_id;
    }

    public void setLay_id(Integer lay_id) {
        this.lay_id = lay_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pattern[] getPatterns() {
        return patterns;
    }

    public void setPatterns(Pattern[] patterns) {
        this.patterns = patterns;
    }

    public Integer getId_done() {
        return id_done;
    }

    public void setId_done(Integer id_done) {
        this.id_done = id_done;
    }
}
