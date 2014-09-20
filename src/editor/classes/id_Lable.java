package editor.classes;

import javafx.scene.control.Label;

/**
 * Created by godex_000 on 03.07.2014.
 */
public class id_Lable extends Label {
    Integer dbid;

    public Integer getDbid() {
        return dbid;
    }

    /**
     * Встановити значення ID
     *
     * @param dbid який ID встановити
     */
    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public id_Lable(Integer id, String text) {
        super(text);
        this.dbid = id;
    }

}
