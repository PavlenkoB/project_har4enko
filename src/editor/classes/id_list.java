package editor.classes;

/**
 * Created by godex_000 on 24.06.2014.
 */
public class id_list {
    private Integer ID;
    private String name;
    public id_list() {
    }
    public id_list(Integer ID){
        this.ID=new Integer(ID);
    }

    public id_list(Integer ID, String name) {
        this.ID = new Integer(ID);
        this.name = new String(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }


}
