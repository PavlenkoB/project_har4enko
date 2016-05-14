package ua.edu.nau.godex.projectharchenko.repository_editor.services;
/*
import Classes.Pattern;
import repository_editor.classes.DerbyDBManager;
import repository_editor.classes.ResultInfo;
*/

import ua.edu.nau.godex.projectharchenko.classes.Pattern;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.DerbyDBManager;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.ResultInfo;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class PatternWork {
    //TODO опис функції
    public static Pattern pattern_load_from_DB(Integer pattern_id, DerbyDBManager derby_DB_connection) {
        return Pattern.patternLoadFromDB(pattern_id, derby_DB_connection);
    }

    /**
     * Зберіга патерн в базу
     *
     * @param pattern_in          Патерн яки1 потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static ResultInfo pattern_save_to_DB(Pattern pattern_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        return Pattern.pattern_save_to_DB(pattern_in, derby_DB_connection);
    }

    //TODO опис функції

    public static String pattern_uml_text_gen(Pattern pattern_in) {
        return Pattern.pattern_uml_text_gen(pattern_in);
    }
}
