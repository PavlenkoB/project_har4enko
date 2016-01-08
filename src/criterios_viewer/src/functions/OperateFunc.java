package src.functions;

import Classes.*;
import DataBase.DB_manager;
import editor.classes.DerbyDBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class OperateFunc {
    private ArrayList<Task> tasks = new ArrayList<>();          //  Массив заданий
    private ArrayList<Session> sessions = new ArrayList<>();    //  Массив сессий
    private Session session_choice = new Session();             //  Вибрана сессия для просмотра оценок с массива sessions
    private Architecture architecture_done_choice_type;         //  Тип выбраной архитектуры
    private Map<Criterion, Integer> criterionMap = new HashMap<>(); // Оценки по критериям

    public void loadDataMark(DerbyDBManager markDb) throws SQLException {
        boolean flag_mark = true;

        if (flag_mark) {
            ResultSet rs_sess = null;
            try {
                //derby_DB
                rs_sess = markDb.executeQuery(PrepareStat.SELECT_ALL_FROM_SESSION.getPrepareStat());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            while (rs_sess.next()) {
                ArrayList<Mark> marks = new ArrayList<>();
                ResultSet rs_mark = null;
                rs_mark = markDb.executeQuery(PrepareStat.SELECT_FROM_MARK.getPrepareStat(), +rs_sess.getInt("ID"));
                while (rs_mark.next()) {
                    marks.add(new Mark(rs_mark.getInt("ID"), rs_mark.getInt("ARCH_1_ID"), rs_mark.getInt("ARCH_2_ID"), rs_mark.getInt("MARK")));
                }
                Date date = new Date((long) rs_sess.getFloat("DATE_SES"));
                sessions.add(new Session(rs_sess.getInt("ID"), rs_sess.getString("CRITERION"), rs_sess.getInt("TASK_ID"), marks, date, rs_sess.getString("NOTE")));
            }
        }
    }

    public void loadDataTask(DerbyDBManager archDb){

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public Session getSession_choice() {
        return session_choice;
    }

    public Architecture getArchitecture_done_choice_type() {
        return architecture_done_choice_type;
    }

    public Map<Criterion, Integer> getCriterionMap() {
        return criterionMap;
    }
}
