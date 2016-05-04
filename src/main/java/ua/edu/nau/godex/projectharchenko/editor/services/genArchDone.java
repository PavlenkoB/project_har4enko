package ua.edu.nau.godex.projectharchenko.editor.services;

import Classes.Architecture;
import Classes.Module;

import java.util.ArrayList;

/**
 * Created by godex_000 on 27.05.2014.
 */
public class genArchDone {
    /**
     * генерирует всевозможные варианты архитектур
     * с разными патернами
     *
     * @param origin_arch оригынальна рахытектура
     * @param modules_arr Список модулыв етой архитектуры
     * @return Список сгенерированых архитектур
     */
    public static ArrayList<Architecture> pre_combine(Architecture origin_arch, ArrayList<Module> modules_arr) {
        return Architecture.gen_arch_done_pre_combine(origin_arch, modules_arr);
    }

}
