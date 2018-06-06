package ua.edu.nau.icit;

import org.apache.log4j.Logger;
import ua.edu.nau.icit.classes.*;
import ua.edu.nau.icit.services.archWork;
import ua.edu.nau.icit.services.functions;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AlxEx on 13.01.2016.
 */
public class DBWorker {
    private DerbyDBManager archDB; // = new DerbyDBManager("DB/paterns_DB");
    private DerbyDBManager markDb; // = new DerbyDBManager("DB/Marks");


    private String archDbStr;
    private String markDbStr = "DB/Marks";

    public List<Task> getTasksList() {
        if (archDB != null) {
            List<Task> taskList = new LinkedList<>();

            ResultSet rs = null;
            try {
                rs = archDB.executeQuery("SELECT * FROM TASK");

                while (rs.next()) {
                    //System.out.println(rs.getInt("ID") + "|" + rs.getString("NAME"));
                    taskList.add(new Task(rs.getInt("ID"), rs.getString("NAME"), rs.getString("DESCRIPTION")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return taskList;
        } else return null;
    }

    public List<Architecture> getArchitectureListByTaskID(int taskID) {
        List<Architecture> architectureList = null;
        try {
            architectureList = new archWork().architectureDoneArrayListFromDbByTaskID(taskID, archDB);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return architectureList;
    }

    public Architecture getArchitectureType(Architecture once) {
        return archWork.arch_load_from_DB(once.getId(), archDB);
    }

    /**
     * Збереження сесії оцінювання у базу
     *
     * @param task_id -   ідентифікатор оцінуваного завдання
     * @return -   вдалість операції
     * @throws SQLException
     */
    public void session_save_to_db(int task_id, String criterion, String note_exp) throws SQLException {
        Date d = new Date();
        float df = d.getTime();
        this.markDb.executeUpdate("INSERT INTO SESSION (TASK_ID, DATE_SES, CRITERION, NOTE) VALUES (" + task_id + " , " +
                df + " , '" + Criterion.fromString(criterion).name() + "' , '" + note_exp + "')");
        logger.info(": session save successful");
    }

    /**
     * Збереженя оцінок у базу даних оцінок
     *
     * @param mark      -   записувана оцінка
     * @param arch1ID   -   1 оцінувана архітектура (з пари)
     * @param arch2ID   -   2 оцінувана архітектура (з пари)
     * @param sessionID -   ідентифікатор сесії оцінювання
     * @return -   вдалість операції
     * @throws SQLException
     */
    public boolean marksSaveToDB(Mark mark, int arch1ID, int arch2ID, int sessionID) throws SQLException {//Зберегти архітектуру в БД
        boolean result = false;
        //Добавить в базу
        this.markDb.executeUpdate("INSERT INTO MARK (SESSION_ID,ARCH_1_ID,ARCH_2_ID,MARK) VALUES (" + sessionID + "," + arch1ID + "," + arch2ID + "," + mark.getMark() + ")");
        logger.info(": mark save successful");
        return true;
    }

    public void connectionToArchDb(String archDbStr) {
        disconnectArchDb();
        this.archDbStr = archDbStr;
        this.archDB = new DerbyDBManager(this.archDbStr);
        logger.info(": connected to archDb / " + this.archDbStr);
    }

    public void connectionToMarkDb() {
        disconnectMarkDb();

        File db_dir = new File(markDbStr);
        //Если требуемого файла не существует.
        if (!db_dir.exists())
            createMarkDB();
        else {
            this.markDb = new DerbyDBManager(this.markDbStr);
        }
        logger.info(": connected to markDb / " + this.markDbStr);
    }

    public void disconnectArchDb() {
        disconnect_DB(archDB);
        logger.info(": disconnected from archDb / " + this.archDbStr);
    }

    public void disconnectMarkDb() {
        disconnect_DB(markDb);
        logger.info(": disconnected from markDb / " + this.markDbStr);
    }

    public void disconnectAll() {
        disconnectArchDb();
        disconnectMarkDb();
    }

    public int getLastSessionID() {
        return functions.last_id_from_table_DB("SESSION", markDb);
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

    /**
     * Створення бази даних оцінок в директорії "DB/Marks"
     */
    public void createMarkDB() { //Создать БД
        File db_dir = new File(markDbStr);

        //Если требуемого файла не существует.
        if (!db_dir.exists()) {
            logger.info(": створення бази оцінок");
            //Создаем его.
            if (!db_dir.mkdirs()) {
                Modals.showInfoApplicationModal("INfo", "Crete marks direction");
                logger.info(":MarkDB / Create marks direction");
            }
            markDb = new DerbyDBManager(db_dir);
            logger.info(": створення бази оцінок / створення таблиць");
            //todo сделать нормально блок с доступом к ресурсам

                File in_dir;
                in_dir = new File(this.getClass().getClassLoader().getResource("resources/sql/create_marks_DB").getFile());
                if (!in_dir.exists()) {
                    in_dir = new File("resources/sql/create_marks_DB");
                    if (!in_dir.exists()) {
                        Modals.showInfoApplicationModal("Err", "cant find resource sql/create_marks_DB");
                        logger.error(":MarkDB / cant find resource sql/create_marks_DB");
                        System.exit(-1);
                    }
                }

                File[] fList;
                fList = in_dir.listFiles();
                for (File sql_file : fList) {
                    System.out.println(sql_file.getName());
                    //Нужны только папки в место isFile() пишим isDirectory()
                    if (sql_file.isFile()) {
                        String filename = sql_file.getName();
                        int dotPos = filename.lastIndexOf(".");
                        String ext = filename.substring(dotPos);
                        if (ext.equals(".sql")) {
                            try {
                                markDb.executeUpdate_from_file(sql_file);
                            } catch (SQLException e) {
                                logger.error(":MarkDB / " + e.getStackTrace());
                                e.printStackTrace();
                            }
                        }
                    }
                }
                logger.info(":MarkDB / tables have been created");
        }
    }

    private static DBWorker ourInstance = new DBWorker();

    public static DBWorker getInstance() {
        return ourInstance;
    }

    private DBWorker() {
    }

    private static Logger logger = Logger.getLogger(DBWorker.ourInstance.getClass());
}
