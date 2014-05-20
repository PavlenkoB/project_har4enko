package Classes;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Task {
    public Integer id;
    public String name;
    public String description;
    public Architecture[] architectures;

    public Task(Integer id, String name, String description, Architecture[] architectures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.architectures = architectures;
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

    public Architecture[] getArchitectures() {
        return architectures;
    }

    public void setArchitectures(Architecture[] architectures) {
        this.architectures = architectures;
    }
}
