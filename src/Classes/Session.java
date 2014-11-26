package Classes;

import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class Session {
    private Integer id;
    private Task task;
    private Criteriy criteriy;
    private Integer task_id;
    private ArrayList<Mark> marks;

    public int getTask_id() {
        return task_id;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Session(){
        this.id = null;
        this.task = null;
        this.criteriy = null;
        this.task_id = null;
        this.marks = null;

    }

    public Integer getId() {
        return id;
    }

    public Session(Integer id, Task task, Criteriy criteriy, Integer task_id, ArrayList<Mark> marks) {
        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
        this.task_id = task_id;
        this.marks = marks;
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
    public Session(Integer id, Integer task_id, ArrayList<Mark> marks) {

        this.id = id;
        this.task_id = task_id;
        this.marks = marks;
    }

    public Session(Integer id, Task task, Criteriy criteriy) {

        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
    }
}
