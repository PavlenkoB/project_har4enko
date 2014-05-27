package editor.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    static Connection conn = null;

    public static void main(String[] args) {
        DerbyDBManager db = new DerbyDBManager("paterns_DB");
        try {
            try {
                //пишем в таблицу
                fillDB(db);
            } catch (SQLException e) {
                //если БД не существовала, то создаем таблицу и после этого заполняем её значениями
                db.executeUpdate("CREATE TABLE demotab(i integer, i2 integer)");
                fillDB(db);
            }
            ResultSet rs = db.executeQuery("SELECT * FROM demotab");
            while (rs.next()) {
                System.out.println("i = " + rs.getString(1) + ", i^2 = " + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillDB(DerbyDBManager db) throws SQLException {
        for (int i = 0; i < 5; i++) {
            db.executeUpdate("INSERT INTO demotab VALUES(" + String.valueOf(i) + "," + String.valueOf(i * i) + ")");
        }
    }
}
