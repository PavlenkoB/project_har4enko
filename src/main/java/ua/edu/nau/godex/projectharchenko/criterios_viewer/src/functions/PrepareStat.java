package ua.edu.nau.godex.projectharchenko.criterios_viewer.src.functions;

/**
 * Created by AlxEx on 23.12.2015.
 */
public enum PrepareStat {
    SELECT_ALL_FROM_SESSION("SELECT * FROM SESSION"), SELECT_FROM_MARK_BY_SESSION_ID("SELECT * FROM MARK WHERE SESSION_ID = ?"),
    SELECT_FROM_TASK("SELECT * FROM TASK"), SELECT_ALL_FROM_SESSION_BY_TASK_ID("SELECT * FROM SESSION WHERE TASK_ID = ?");

    private String prepareStat;

    PrepareStat(String prepareStat) {
        this.prepareStat = prepareStat;
    }

    public String getPrepareStat() {
        return prepareStat;
    }
}
