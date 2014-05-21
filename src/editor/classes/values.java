package editor.classes;

/**
 * Created by godex_000 on 21.05.2014.
 */
public class values {
    String name;
    Integer id;
    values(){}
    values(Integer id, String name){
        this.id=id;
        this.name=name;
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
}
