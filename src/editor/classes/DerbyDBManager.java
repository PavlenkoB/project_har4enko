package editor.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class DerbyDBManager {
    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String url = "jdbc:derby:";
    private static String dbName = null;
    private static Connection con = null;

    public DerbyDBManager(String dbName) {
        this.dbName = dbName;
        System.out.print("Try connect to '"+dbName+"'");
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
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        System.out.print("\rConnection to '"+dbName+"' established\n");
    }


    public DerbyDBManager(File db_dir) {//Создать в папке БД
        this.dbName = db_dir.getAbsolutePath();
        db_dir.delete();
        dbName = dbName.replace('\\', '/');
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url + dbName + ";create=true");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DerbyDBManager.con = con;
    }

    private Boolean dbExists() {
        try {
            if (con.isClosed() || con == null) {
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url + this.dbName);
                    return true;
                } catch (Exception e) {
                    System.out.println("Connection error");
                    e.printStackTrace();

                    // Если база не создана то ничего не делаем
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            if (con == null) {
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url + this.dbName);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    e.printStackTrace();
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    // запрос на обновление базы данных  (INSERT, UPDATE, CREATE TABLE и т.п.)
    public void executeUpdate(String sql) throws SQLException {
        //Statement stmt = con.createStatement();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
//        preparedStatement.setMaxRows(20);
//        preparedStatement.

        preparedStatement.executeUpdate();
        //stmt.close();
        preparedStatement.close();
    }

    /*

     * @param sql_file файл який необхідно виконати
     * @return result_info.comment = коментар
     * @author godex_000
     */
    // запрос на обновление базы данных  (INSERT, UPDATE, CREATE TABLE и т.п.) с файла
    public result_info executeUpdate_from_file(File sql_file) throws SQLException {
        result_info res = new result_info();
        try {
            BufferedReader in = new BufferedReader(new FileReader(sql_file));
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = in.readLine()) != null) {
                sb.append(str + "\n ");
            }
            in.close();
            this.executeUpdate(sb.toString());
            res.setStatus(true);
        } catch (Exception e) {
            System.err.println("Failed to Execute" + sql_file.getAbsolutePath().toString() + ". The error is" + e.getMessage());
            res.setComment("Failed to Execute" + sql_file.getAbsolutePath().toString() + ". The error is" + e.getMessage());
        }
        return res;
    }

    /**
     * @param aSQLScriptFilePath шлях до файлу який необхідно виконати
     * @return result_info.comment = коментар
     * @author godex_000
     */
    public result_info executeUpdate_from_file(String aSQLScriptFilePath) throws SQLException {
        result_info res = new result_info();
        try {
            BufferedReader in = new BufferedReader(new FileReader(aSQLScriptFilePath));
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = in.readLine()) != null) {
                sb.append(str + "\n ");
            }
            in.close();
            this.executeUpdate(sb.toString());
            res.setStatus(true);
        } catch (Exception e) {
            System.err.println("Failed to Execute" + aSQLScriptFilePath + ". The error is" + e.getMessage());
            res.setComment("Failed to Execute" + aSQLScriptFilePath + ". The error is" + e.getMessage());
        }
        return res;
    }

    // запрос на выборку данных из базы
    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        return result;
    }

    public void disconectDB() {//отключиться от БД
        try {
            String shutdownURL = url + dbName + ";shutdown=true";
            DriverManager.getConnection(shutdownURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDbName() {
        return dbName;
    }
}