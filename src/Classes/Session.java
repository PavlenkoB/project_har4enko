package Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class Session {
    private Integer id;
    private Task task;
    private Criteriy criteriy;
    private Integer taskId;
    private ArrayList<Mark> marks;
    private Date date;
    private String note;

    public Session(Integer id, Task task, Criteriy criteriy, Integer taskId, ArrayList<Mark> marks, Date date, String note) {
        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
        this.taskId = taskId;
        this.marks = marks;
        this.date = date;
        this.note = note;
    }

    public String getNote() {

        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Session(Integer id, Integer taskId, ArrayList<Mark> marks, Date date, String note) {
        this.id = id;
        this.taskId = taskId;
        this.marks = marks;
        this.date = date;
        this.note = note;
    }

    public Session(Integer id, Criteriy criteriy, Integer taskId, ArrayList<Mark> marks, Date date, String note) {
        this.id = id;
        this.criteriy = criteriy;
        this.taskId = taskId;
        this.marks = marks;
        this.date = date;
        this.note = note;
    }

    public Session(Integer id, Integer taskId, ArrayList<Mark> marks, Date date) {
        this.id = id;
        this.taskId = taskId;
        this.marks = marks;
        this.date = date;
    }

    public Session(Integer id, Task task, Criteriy criteriy, Integer taskId, ArrayList<Mark> marks, Date date) {
        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
        this.taskId = taskId;
        this.marks = marks;
        this.date = date;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTaskId() {
        return taskId;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Session() {
        this.id = null;
        this.task = null;
        this.criteriy = null;
        this.taskId = null;
        this.marks = null;
        this.date = null;

    }

    public Integer getId() {
        return id;
    }

    public Session(Integer id, Task task, Criteriy criteriy, Integer taskId, ArrayList<Mark> marks) {
        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
        this.taskId = taskId;
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

    public Session(Integer id, Integer taskId, ArrayList<Mark> marks) {

        this.id = id;
        this.taskId = taskId;
        this.marks = marks;
    }

    public Session(Integer id, Task task, Criteriy criteriy) {

        this.id = id;
        this.task = task;
        this.criteriy = criteriy;
    }
}
