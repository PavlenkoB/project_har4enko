package ua.edu.nau.godex.projectharchenko.database;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by Alex on 28.04.2014.
 */
public class DateBaseManager {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String url = "jdbc:derby:";
    public static Logger logger = Logger.getLogger(DateBaseManager.class.getName());
    private static Connection con = null;
    private static String dbName = null;

    public DateBaseManager(String dbName) {
        this.dbName = dbName;
        if (!dbExists()) {
            try {
                Class.forName(driver);
                // Подключение к БД или её создание
                con = DriverManager.getConnection(url + dbName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Boolean dbExists() {
        if (con == null) {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url + this.dbName);
                return true;
            } catch (Exception e) {
                logger.info("Connection error");
                e.printStackTrace();

                // Если база не создана то ничего не делаем
            }
        } else {
            return true;
        }
        return false;
    }

    // запрос на обновление базы данных  (INSERT, UPDATE, CREATE TABLE и т.п.)
    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = con.createStatement();
        int count = stmt.executeUpdate(sql);
        stmt.close();
    }

    // запрос на выборку данных из базы
    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        return result;
    }

    public void disconectDB() {//отключиться от БД
        try {
            con.close();
        } catch (SQLException e) {
            logger.info("Не удалось закрыть подключение к БД");
            e.printStackTrace();
        }
    }
}
