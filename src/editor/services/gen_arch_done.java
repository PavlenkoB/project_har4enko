package editor.services;

import Classes.Architecture;
import Classes.Module;

import java.util.ArrayList;

/**
 * Created by godex_000 on 27.05.2014.
 */
public class gen_arch_done {
    public static void gen(Architecture arch_in){

        ArrayList<Module> modd_arr= new ArrayList<>();
        ArrayList<Integer> modd_arr_sellected= new ArrayList<>();
        for(int s_lay=0;s_lay<arch_in.layers.size();s_lay++){
            for(int s_mod=0;s_mod<arch_in.layers.get(s_lay).modules.size();s_mod++){
             modd_arr.add(arch_in.layers.get(s_lay).modules.get(s_mod));
            }
        }
        //Все устанавливаем в 1
        for(int s_mod=0;s_mod<modd_arr.size();s_mod++) {
            modd_arr_sellected.add(s_mod,0);
        }
        shet(modd_arr,modd_arr_sellected,modd_arr_sellected.size());
    }
    public static void shet(ArrayList<Module> modd, ArrayList<Integer> modd_sell,int s_pos){

        if(modd_sell.get(s_pos)>modd.get(s_pos).avilable_paterns.size()&&s_pos>0) {
        }else {
            if (modd_sell.get(s_pos) > modd.get(s_pos).avilable_paterns.size()) {
                modd_sell.set(s_pos, 0);
                s_pos--;//переход к счетчику на 1 уровень выше
                modd_sell.set(s_pos, modd_sell.get(s_pos) + 1);
                shet(modd, modd_sell, s_pos);
            }else {
                modd_sell.set(s_pos, modd_sell.get(s_pos) + 1);
                if (modd_sell.get(s_pos) > modd.get(s_pos).avilable_paterns.size()) {
                    modd_sell.set(s_pos, 0);
                    s_pos--;//переход к счетчику на 1 уровень выше
                    modd_sell.set(s_pos, modd_sell.get(s_pos) + 1);
                    shet(modd, modd_sell, s_pos);
                }
                modd.get(s_pos).selected_patern=modd.get(s_pos).avilable_paterns.get(modd_sell.get(s_pos));
                //save
            }
        }
    }


}
