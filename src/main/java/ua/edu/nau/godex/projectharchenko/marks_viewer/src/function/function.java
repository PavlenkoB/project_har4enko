package src.function;

import editor.classes.DerbyDBManager;

import java.sql.SQLException;

/**
 * Created by Alx Shcherbak on 07.11.2014.
 */
public class function {


    /**
     * Від'єднання від бази даних
     *
     * @param database -   база до від'єднання
     */
    public void disconnect_DB(DerbyDBManager database) {//отключиться от БД
        try {
            if (database.getCon() != null) {
                if (!database.getCon().isClosed()) {
                    database.disconectDB();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
