package classes;

import java.sql.*;

public class DerbyDBManager {
    private static Connection con = null;
    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String url = "jdbc:derby:";
    private static String dbName = null;

    public String getDbName() {
        return dbName;
    }

    public DerbyDBManager(String dbName) {
        this.dbName = dbName;
        if (!dbExists()) {
            try {
                Class.forName(driver);
                dbName = dbName.replace('\\', '/');
                // Подключение к БД или её создание
                con = DriverManager.getConnection(url + dbName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                try {
                    con = DriverManager.getConnection(url + dbName + ";create=true");
                    con = null;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private Boolean dbExists() {
        Boolean exists = false;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + dbName);
            exists = true;
        } catch (Exception e) {
            //TODO create DB
            // Если база не создана то ничего не делаем
        }
        return (exists);
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
            System.out.println("Не удалось закрыть подключение к БД");
            e.printStackTrace();
        }
    }
}