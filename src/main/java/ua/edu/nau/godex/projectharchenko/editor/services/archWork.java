package ua.edu.nau.godex.projectharchenko.editor.services;

import Classes.Architecture;
import editor.classes.DerbyDBManager;
import editor.classes.resultInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by godex_000 on 15.06.2014.
 */
public class archWork {

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
    public static resultInfo arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) {//Зберегти архітектуру в БД
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
        return drawUml.draw_class(arch_uml_text_gen(architecture));
    }

    /**
     * Выборка с базы данных патернов масива готовых архитектур по ID задачи (TaskID)
     *
     * @param task_id   - id задачи
     * @param patternDB -   база данных - репозитарий патернов
     * @return -   массив архитектуротносящихся к задаче task_id или null
     * @throws java.sql.SQLException
     * @throws CloneNotSupportedException
     */
    public ArrayList<Architecture> architectureDoneArrayListFromDbByTaskID(Integer task_id, DerbyDBManager patternDB)
            throws SQLException, CloneNotSupportedException {
        if (patternDB != null && task_id != null) {
            ArrayList<Architecture> architectureArrayList = new ArrayList<>();
            Architecture architectureType = new Architecture();
            ResultSet rsArch = null,
                    rsLay = null,
                    rsMod = null;

            rsArch = patternDB.executeQuery("SELECT * FROM ARCH_DONE WHERE TASK_ID=" + task_id);
            rsArch.next();
            architectureType = arch_load_from_DB(rsArch.getInt("ARCH_ID"), patternDB);

            rsArch = null;
            rsArch = patternDB.executeQuery("SELECT * FROM ARCH_DONE WHERE TASK_ID=" + task_id);
            while (rsArch.next()) {
                architectureArrayList.add(new Architecture(rsArch.getInt("ARCH_ID"), "", rsArch.getInt("ID"), task_id));
            }

            for (int i = 0; i < architectureArrayList.size(); i++) {
                int id_done = architectureArrayList.get(i).getIdDone();


                architectureArrayList.set(i, architectureType.clone());
                architectureArrayList.get(i).setIdDone(id_done);
                architectureArrayList.get(i).setTaskId(task_id);

                rsLay = null;
                rsLay = patternDB.executeQuery("SELECT * FROM LAY_DONE WHERE ARCH_DONE_ID=" + architectureArrayList.get(i).getIdDone());
                while (rsLay.next()) {
                    for (int j = 0; j < architectureArrayList.get(i).getLayers().size(); j++) {
                        if (rsLay.getInt("LAY_ID") == architectureArrayList.get(i).getLayers().get(j).getId()) {
                            architectureArrayList.get(i).getLayers().get(j).setId_done(rsLay.getInt("ID"));
                        }
                    }
                }
                for (int j = 0; j < architectureArrayList.get(i).getLayers().size(); j++) {
                    rsMod = null;
                    rsMod = patternDB.executeQuery("SELECT * FROM MODULE_DONE WHERE LAY_DONE_ID=" + architectureArrayList.get(i).getLayers().get(j).getId_done());
                    while (rsMod.next()) {
                        for (int k = 0; k < architectureArrayList.get(i).getLayers().get(j).getModules().size(); k++) {
                            if (rsMod.getInt("MOD_ID") == architectureArrayList.get(i).getLayers().get(j).getModules().get(k).getId()) {
                                architectureArrayList.get(i).getLayers().get(j).getModules().get(k).setIdDone(rsMod.getInt("ID"));
                                for (int p = 0; p < architectureArrayList.get(i).getLayers().get(j).getModules().get(k).getAvilablePatterns().size(); p++) {
                                    if (architectureArrayList.get(i).getLayers().get(j).getModules().get(k).getAvilablePatterns().get(p).getId() == rsMod.getInt("PATTERN_ID")) {
                                        architectureArrayList.get(i).getLayers().get(j).getModules().get(k).setSelectedPattern(architectureArrayList.get(i).getLayers().get(j).getModules().get(k).getAvilablePatterns().get(p));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return architectureArrayList;
        }
        return null;
    }

}
