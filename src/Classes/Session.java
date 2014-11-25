package Classes;

import sun.util.calendar.BaseCalendar;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class Session {
    private Integer id;
    private Task task;
    private Criteriy criteriy;

    public Session(){
        this.id = null;
        this.task = null;
        this.criteriy = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Criteriy getCriteriy() {
        return criteriy;
    }

    public void setCriteriy(Criteriy criteriy) {
        this.criteriy = criteriy;
    }

    public Session(Integer id, Task task) {

        this.id = id;
        this.task = task;
    }

    public Session(Integer id, Task task, Criteriy criteriy) {

        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
    }
}
