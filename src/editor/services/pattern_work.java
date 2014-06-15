package editor.services;

import Classes.Pattern;
import editor.classes.DerbyDBManager;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class pattern_work {
    //TODO опис функції
    public static Pattern pattern_load_from_DB(Integer pattern_id, DerbyDBManager derby_DB_connection) {
        Pattern pattern_out=new Pattern();
        return pattern_out;
    }

    /**
     * Збаріга архітектуру в базу
     *
     * @param pattern_in          Патерн яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static boolean pattern_save_to_DB(Pattern pattern_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        boolean result = false;

        return result;
    }


    //TODO опис функції
    private static void save_pattern_img_update(Pattern pattern_in, DerbyDBManager derbyDBManager) throws Exception {

    }


    //TODO опис функції

    public static String pattern_uml_text_gen(Pattern pattern_in) {
        pattern_in.getName();
        String class_text = new String();
        class_text += "}\n";
        return class_text;
    }
}
