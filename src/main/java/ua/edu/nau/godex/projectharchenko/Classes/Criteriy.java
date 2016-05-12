package ua.edu.nau.godex.projectharchenko.classes;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class Criteriy {
    private Integer id;
    private String name;
    private String description;

    public Criteriy() {
        this.id = null;
        this.name = null;
        this.description = null;
    }

    public Criteriy(Integer id, String name, String description) {

        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
