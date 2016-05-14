package ua.edu.nau.godex.projectharchenko.repository_editor.classes;

import javafx.scene.control.Label;

/**
 * Created by godex_000 on 03.07.2014.
 */
public class IdLable extends Label {
    Integer dbId;

    public IdLable(Integer id, String text) {
        super(text);
        this.dbId = id;
    }

    public Integer getDbId() {
        return dbId;
    }

    /**
     * Встановити значення ID
     *
     * @param dbId який ID встановити
     */
    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

}
