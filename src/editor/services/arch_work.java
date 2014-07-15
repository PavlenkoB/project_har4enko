package editor.services;

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import Classes.Pattern;
import editor.classes.DerbyDBManager;
import editor.classes.result_info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class arch_work {

    //TODO опис функції
    public static Architecture arch_load_from_DB(Integer arch_id, DerbyDBManager derby_DB_connection) {
        return Architecture.arch_load_from_DB(arch_id,derby_DB_connection);
    }

    /**
     * Зберіга архітектуру в базу
     *
     * @param arch_in             Архітектура яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static result_info arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
        return Architecture.arch_save_to_DB(arch_in,derby_DB_connection);
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
