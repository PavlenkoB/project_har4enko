package src.function;

import Classes.Architecture;
import Classes.Mark;
import Classes.Session;
import Classes.Task;
import editor.classes.DerbyDBManager;
import editor.services.archWork;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AlxEx on 14.01.2016.
 */
public class DbWorker {
    /**
     *
     */
    private DerbyDBManager archDB; //= new DerbyDBManager("DB/paterns_DB");
    /**
     *
     */
    private DerbyDBManager markDb; // = new DerbyDBManager("DB/Marks");
    /**
     *
     */
    private String archDbStr;       //  Путь к базе патернов    -   относительный
    /**
     *
     */
    private String markDbStr;       //  Путь к базе оценок

    /**
     * @return
     */
    public boolean readyToWork() {
        return archDB != null && markDb != null && archDB.connectionEstablish() && markDb.connectionEstablish();
    }

    /**
     * @return
     */
    public List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>();
        if (archDB.connectionEstablish()) {
            try {
                ResultSet rs_rep = archDB.executeQuery("SELECT * FROM TASK");
                while (rs_rep.next()) {
                    taskList.add(new Task(rs_rep.getInt("ID"), rs_rep.getString("NAME"), rs_rep.getString("DESCRIPTION"),
                            new archWork().architectureDoneArrayListFromDbByTaskID(rs_rep.getInt("ID"), archDB)));
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
     * @return
     */
    public List<Session> getSessionList() {
        List<Session> sessionList = new ArrayList<>();
        if (markDb.connectionEstablish()) {
            try {
                ResultSet rs_sess = markDb.executeQuery("SELECT * FROM SESSION");
                while (rs_sess.next()) {
                    ArrayList<Mark> marks = new ArrayList<>();
                    ResultSet rs_mark = markDb.executeQuery("SELECT * FROM MARK WHERE SESSION_ID =" + rs_sess.getInt("ID"));
                    while (rs_mark.next()) {
                        marks.add(new Mark(rs_mark.getInt("ID"), rs_mark.getInt("ARCH_1_ID"), rs_mark.getInt("ARCH_2_ID"), rs_mark.getInt("MARK")));
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
     * @param once
     * @return
     */
    public Architecture getArchitectureType(Architecture once) {
        return archWork.arch_load_from_DB(once.getId(), archDB);
    }

    /**
     * @param archDbStr
     */
    public void connectionToArchDb(String archDbStr) {
        disconnectArchDb();
        this.archDbStr = archDbStr;
        this.archDB = new DerbyDBManager(this.archDbStr);
        logger.info(": connected to archDb / " + this.archDbStr);
    }

    /**
     * @param markDbStr
     */
    public void connectionToMarkDb(String markDbStr) {
        disconnectMarkDb();
        this.markDbStr = markDbStr;
        this.markDb = new DerbyDBManager(this.markDbStr);
        logger.info(": connected to markDb / " + this.markDbStr);
    }

    /**
     *
     */
    public void disconnectArchDb() {
        disconnect_DB(archDB);
        logger.info(": disconnected from archDb / " + this.archDbStr);
    }

    /**
     *
     */
    public void disconnectMarkDb() {
        disconnect_DB(markDb);
        logger.info(": disconnected from markDb / " + this.markDbStr);
    }

    /**
     *
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
            e.printStackTrace();
        }
    }

    private static DbWorker ourInstance = new DbWorker();

    public static DbWorker getInstance() {
        return ourInstance;
    }

    private DbWorker() {
    }

    private static Logger logger = Logger.getLogger(DbWorker.ourInstance.getClass());
}
