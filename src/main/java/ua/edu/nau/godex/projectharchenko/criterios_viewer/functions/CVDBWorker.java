package ua.edu.nau.godex.projectharchenko.criterios_viewer.functions;

/*
import repository_editor.classes.DerbyDBManager;
import repository_editor.services.ArchWork;*/

import org.apache.log4j.Logger;
import ua.edu.nau.godex.projectharchenko.classes.Architecture;
import ua.edu.nau.godex.projectharchenko.classes.Mark;
import ua.edu.nau.godex.projectharchenko.classes.Session;
import ua.edu.nau.godex.projectharchenko.classes.Task;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.DerbyDBManager;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.ArchWork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AlxEx on 14.01.2016.
 */
public class CVDbWorker {
    private static CVDbWorker ourInstance = new CVDbWorker();
    private static Logger logger = Logger.getLogger(CVDbWorker.ourInstance.getClass());
    /**
     * DB manager to patterns and architectures repository
     */
    private DerbyDBManager archDB; //= new DerbyDBManager("DB/paterns_DB");
    /**
     * DB manager to marks and sessions
     */
    private DerbyDBManager markDb; // = new DerbyDBManager("DB/Marks");
    /**
     * String view of address of archDB repository
     */
    private String archDbStr;       //  Путь к базе патернов    -   относительный
    /**
     * String view of address of markDB repository
     */
    private String markDbStr;       //  Путь к базе оценок

    private CVDbWorker() {
    }

    public static CVDbWorker getInstance() {
        return ourInstance;
    }

    /**
     * flag that connections to markDB and ArchDB establish
     *
     * @return - establishing status of connections
     */
    public boolean readyToWork() {
        return archDB != null && markDb != null && archDB.connectionEstablish() && markDb.connectionEstablish();
    }

    /**
     * getting from BD list of all tasks with all architectures
     *
     * @return - taskList (ArrayList)
     */
    public List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>();
        if (archDB.connectionEstablish()) {
            try {
                ResultSet rs_rep = archDB.executeQuery(PrepareStat.SELECT_FROM_TASK.getPrepareStat());
                while (rs_rep.next()) {
                    taskList.add(new Task(rs_rep.getInt("ID"), rs_rep.getString("NAME"), rs_rep.getString("DESCRIPTION"),
                            new ArchWork().architectureDoneArrayListFromDbByTaskID(rs_rep.getInt("ID"), archDB)));
                }
                logger.info(": Tasks have gotten from DB");
            } catch (SQLException e) {
                logger.error(": Task getting from DB Error / " + e.getMessage() + " / " + e.getStackTrace() + " / " + e.getSQLState());
            } catch (CloneNotSupportedException e) {
                logger.error(": Task getting from DB Error / " + e.getMessage() + " / " + e.getStackTrace());
            }
        }
        return taskList;
    }

    /**
     * getting from BD list of all sessions with marks
     *
     * @return - sessionsList (ArrayList)
     */
    public List<Session> getSessionList() {
        List<Session> sessionList = new ArrayList<>();
        if (markDb.connectionEstablish()) {
            try {
                ResultSet rs_sess = markDb.executeQuery(PrepareStat.SELECT_ALL_FROM_SESSION.getPrepareStat());
                while (rs_sess.next()) {
                    ArrayList<Mark> marks = new ArrayList<>();
                    ResultSet rs_mark = markDb.executeQuery(PrepareStat.SELECT_FROM_MARK_BY_SESSION_ID.getPrepareStat(),
                            rs_sess.getInt("ID"));
                    while (rs_mark.next()) {
                        marks.add(new Mark(rs_mark.getInt("ID"), rs_mark.getInt("ARCH_1_ID"),
                                rs_mark.getInt("ARCH_2_ID"), rs_mark.getInt("MARK")));
                    }
                    Date date = new Date((long) rs_sess.getFloat("DATE_SES"));
                    sessionList.add(new Session(rs_sess.getInt("ID"), rs_sess.getString("CRITERION"), rs_sess.getInt("TASK_ID"), marks, date, rs_sess.getString("NOTE")));
                }
                logger.info(": Sessions have gotten from DB");
            } catch (SQLException e) {
                logger.error(": Sessions getting from DB Error / " + e.getMessage() + " / " + e.getStackTrace() + " / " + e.getSQLState());
            }
        }
        return sessionList;
    }

    /**
     * getting from BD list of all sessions with marks
     *
     * @return - sessionsList (ArrayList)
     */
    public List<Session> getSessionListByTask(Task task) {
        List<Session> sessionList = new ArrayList<>();
        if (markDb.connectionEstablish()) {
            try {
                ResultSet rs_sess = markDb.executeQuery(PrepareStat.SELECT_ALL_FROM_SESSION_BY_TASK_ID.getPrepareStat(),task.getId());
                while (rs_sess.next()) {
                    ArrayList<Mark> marks = new ArrayList<>();
                    ResultSet rs_mark = markDb.executeQuery(PrepareStat.SELECT_FROM_MARK_BY_SESSION_ID.getPrepareStat(),
                            rs_sess.getInt("ID"));
                    while (rs_mark.next()) {
                        marks.add(new Mark(rs_mark.getInt("ID"), rs_mark.getInt("ARCH_1_ID"),
                                rs_mark.getInt("ARCH_2_ID"), rs_mark.getInt("MARK")));
                    }
                    Date date = new Date((long) rs_sess.getFloat("DATE_SES"));
                    sessionList.add(new Session(rs_sess.getInt("ID"), task, rs_sess.getString("CRITERION"),
                            rs_sess.getInt("TASK_ID"), marks, date, rs_sess.getString("NOTE")));
                }
                logger.info(": Sessions have gotten from DB");
            } catch (SQLException e) {
                logger.error(": Sessions getting from DB Error / " + e.getMessage() + " / " + e.getStackTrace() + " / " + e.getSQLState());
            }
        }
        return sessionList;
    }

    /**
     * getting architecture type from BD by one architecture
     *
     * @param once - example architecture
     * @return - architecture type
     */
    public Architecture getArchitectureType(Architecture once) {
        return ArchWork.arch_load_from_DB(once.getId(), archDB);
    }

    /**
     * establishing connection to archDB
     *
     * @param archDbStr - String view of address of archDB repository
     */
    public void connectionToArchDb(String archDbStr) {
        disconnectArchDb();
        this.archDbStr = archDbStr;
        this.archDB = new DerbyDBManager(this.archDbStr);
        logger.info(": connected to archDb / " + this.archDbStr);
    }

    /**
     * establishing connection to markDB
     *
     * @param markDbStr - String view of address of markDB repository
     */
    public void connectionToMarkDb(String markDbStr) {
        disconnectMarkDb();
        this.markDbStr = markDbStr;
        this.markDb = new DerbyDBManager(this.markDbStr);
        logger.info(": connected to markDb / " + this.markDbStr);
    }

    /**
     * disconnecting connection from archDB
     */
    public void disconnectArchDb() {
        disconnect_DB(archDB);
        logger.info(": disconnected from archDb / " + this.archDbStr);
    }

    /**
     * disconnecting connection from markDB
     */
    public void disconnectMarkDb() {
        disconnect_DB(markDb);
        logger.info(": disconnected from markDb / " + this.markDbStr);
    }

    /**
     * disconnecting connections from archDB and markDB
     */
    public void disconnectAll() {
        disconnectArchDb();
        disconnectMarkDb();
    }

    /**
     * Від'єднання від бази даних
     *
     * @param database -   база до від'єднання
     */
    private void disconnect_DB(DerbyDBManager database) {//отключиться от БД
        try {
            if (database != null) {
                if (database.getCon() != null) {
                    if (!database.getCon().isClosed()) {
                        database.disconectDB();
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(": disconnecting from DB Error / " + e.getMessage() + " / " + e.getStackTrace() + " / " + e.getSQLState());e.printStackTrace();
        }
    }
}
