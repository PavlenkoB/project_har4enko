package editor.services;

import Classes.Architecture;
import Classes.Module;

import java.util.ArrayList;

/**
 * Created by godex_000 on 27.05.2014.
 */
public class gen_arch_done {
    public static ArrayList<Architecture> pre_combine(Architecture origin_arch, ArrayList<Module> modules_arr) {
        Architecture tmp_arch = null;
        try {
            tmp_arch = origin_arch.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ArrayList<Architecture> return_Architectures = new ArrayList<>();
        ArrayList<Integer> modd_arr_sellected = new ArrayList<>();
        //Все устанавливаем в 1
        for (int s_mod = 0; s_mod < modules_arr.size(); s_mod++) {
            modd_arr_sellected.add(s_mod, 0);
        }
        combine(return_Architectures, tmp_arch, modules_arr, modd_arr_sellected, modd_arr_sellected.size() - 1);
        return return_Architectures;
    }

    public static void combine(ArrayList<Architecture> return_Architectures, Architecture tmp_arch, ArrayList<Module> modules_arr, ArrayList<Integer> modd_arr_sell, int s_pos) {
        if (modd_arr_sell.get(s_pos) >= modules_arr.get(s_pos).avilable_paterns.size() && s_pos == 0) {
        } else {
            if (modd_arr_sell.get(s_pos) >= modules_arr.get(s_pos).avilable_paterns.size()) {
                modd_arr_sell.set(s_pos, 0);
                s_pos--;//переход к счетчику на 1 уровень выше
                modd_arr_sell.set(s_pos, modd_arr_sell.get(s_pos) + 1);
                combine(return_Architectures, tmp_arch, modules_arr, modd_arr_sell, s_pos);
            } else {
                if(s_pos==-1){s_pos=0;}
                modules_arr.get(s_pos).selected_patern = modules_arr.get(s_pos).avilable_paterns.get(modd_arr_sell.get(s_pos));
                //save
                int s_add = 0;
                for (int s_lay = 0; s_lay < tmp_arch.layers.size(); s_lay++) {
                    for (int s_mod = 0; s_mod < tmp_arch.layers.get(s_lay).modules.size(); s_mod++) {
                        for (int s_copy = 0; s_copy < modules_arr.size(); s_copy++) {
                            if (tmp_arch.layers.get(s_lay).modules.get(s_mod).id == modules_arr.get(s_copy).id) {
                                tmp_arch.layers.get(s_lay).modules.get(s_mod).selected_patern=modules_arr.get(s_copy).selected_patern;
                            }
                        }
                        s_add++;
                    }
                }

                return_Architectures.add(tmp_arch);
                modd_arr_sell.set(s_pos, modd_arr_sell.get(s_pos) + 1);
                combine(return_Architectures, tmp_arch, modules_arr, modd_arr_sell, modd_arr_sell.size()-1);
            }
        }
    }


}
