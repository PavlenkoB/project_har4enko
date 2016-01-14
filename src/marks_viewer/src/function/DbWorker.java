package src.function;

/**
 * Created by AlxEx on 14.01.2016.
 */
public class DbWorker {
    private static DbWorker ourInstance = new DbWorker();

    public static DbWorker getInstance() {
        return ourInstance;
    }

    private DbWorker() {
    }
}
