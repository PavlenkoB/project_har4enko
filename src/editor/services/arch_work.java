package editor.services;

import Classes.Architecture;
import editor.classes.DerbyDBManager;
import editor.classes.result_info;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class arch_work {

    //TODO опис функції
    public static Architecture arch_load_from_DB(Integer arch_id, DerbyDBManager derby_DB_connection) {
        return Architecture.arch_load_from_DB(arch_id, derby_DB_connection);
    }

    /**
     * Зберіга архітектуру в базу
     *
     * @param arch_in             Архітектура яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static result_info arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        return Architecture.arch_save_to_DB(arch_in, derby_DB_connection);
    }


    //TODO опис функції

    public static String arch_uml_text_gen(Architecture architecture) {
        return Architecture.arch_uml_text_gen(architecture);
    }

    /**
     * Генерирует картинку архитектуры с выбраными патернами
     *
     * @param architecture архитектура для которой сделать картинку
     * @return картинка архитектуры с патернами внутри
     */
    public static javafx.scene.image.Image arch_image_gen_with_patterns(Architecture architecture) {
        return draw_uml.draw_class(arch_uml_text_gen(architecture));
    }


}
