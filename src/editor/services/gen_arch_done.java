package editor.services;

import Classes.Architecture;
import Classes.Module;
import Classes.Pattern;

import java.util.ArrayList;

/**
 * Created by godex_000 on 27.05.2014.
 */
public class gen_arch_done {
    /**
     * генерирует всевозможные варианты архитектур
     * с разными патернами
     *
     * @param origin_arch оригынальна рахытектура
     * @param modules_arr Список модулыв етой архитектуры
     * @return Список сгенерированых архитектур
     */
    public static ArrayList<Architecture> pre_combine(Architecture origin_arch, ArrayList<Module> modules_arr) {
        ArrayList<Architecture> return_Architectures = new ArrayList<>();
        ArrayList<Integer> modd_arr_sellected = new ArrayList<>();
        //Все устанавливаем в 1
        for (int s_mod = 0; s_mod < modules_arr.size(); s_mod++) {
            modd_arr_sellected.add(s_mod, 0);
            try {
                modules_arr.get(s_mod).setSelected_patern(modules_arr.get(s_mod).getAvilable_paterns().get(0).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return_Architectures=combine(return_Architectures, origin_arch, modules_arr, modd_arr_sellected);
        return return_Architectures;
    }

    /**
     * @param return_Architectures
     * @param origin_arch
     * @param modules_arr
     * @param modd_arr_sell        -
     */
    //TODO опис функції
    public static ArrayList<Architecture> combine(ArrayList<Architecture> return_Architectures, Architecture origin_arch, ArrayList<Module> modules_arr, ArrayList<Integer> modd_arr_sell) {
        //save
        Architecture tmp_arch = new Architecture();
        try {
            tmp_arch = origin_arch.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int s_add = 0;
        for (int s_lay = 0; s_lay < tmp_arch.getLayers().size(); s_lay++) {
            for (int s_mod = 0; s_mod < tmp_arch.getLayers().get(s_lay).getModules().size(); s_mod++) {
                for (int s_copy = 0; s_copy < modules_arr.size(); s_copy++) {
                    if (tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).getId().intValue() == modules_arr.get(s_copy).getId().intValue()) {//если ИД моделя совпадает то записать ему патерн
                        try {
                            tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).setSelected_patern(new Pattern());
                            tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).setSelected_patern(modules_arr.get(s_copy).getAvilable_paterns().get(modd_arr_sell.get(s_copy)).clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                s_add++;
            }
        }
        return_Architectures.add(tmp_arch);//сохраняем архитекутуры вариант
        modd_arr_sell.set(modd_arr_sell.size() - 1, modd_arr_sell.get(modd_arr_sell.size() - 1) + 1);//к последнему добавить +1
        for (int ta = modd_arr_sell.size() - 1; ta >= 0; ta--) {//провиряем не вышол кто за границы доступных патернов
            if (modd_arr_sell.get(ta) > modules_arr.get(ta).getAvilable_paterns().size()-1&& ta==0) {//если все патерны попробованы
                return return_Architectures;
            }
            if (modd_arr_sell.get(ta) > modules_arr.get(ta).getAvilable_paterns().size()-1) {
                modd_arr_sell.set(ta, 0);
                modd_arr_sell.set(ta - 1, modd_arr_sell.get(ta - 1)+1);
            }
        }
        combine(return_Architectures, origin_arch, modules_arr, modd_arr_sell);
        return return_Architectures;
    }
        /*}
    }*/
}
