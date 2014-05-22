package editor.services;

import Classes.Architecture;

/**
 * Created by godex_000 on 22.05.2014.
 */
public class functions {
    public static String get_ID(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }

    public static String get_NAME(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            line_pos++;
        }
        line_pos++;
        while (line_pos < in_string.length()) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }
    public static String arch_uml_text_gen(Architecture architecture){
        architecture.getName();
        String class_text = new String();
        class_text += "package \"" + architecture.name + "\"{\n";
        for (int s_lay = 0; s_lay < architecture.layers.size(); s_lay++) {
            class_text += "package \"" +architecture.layers.get(s_lay).name+ "\"{\n";
            for (int s_mod = 0; s_mod < architecture.layers.get(s_lay).modules.size(); s_mod++) {
                class_text += "package \"" +architecture.layers.get(s_lay).modules.get(s_mod).name+ "\"{\n";
                if(architecture.layers.get(s_lay).modules.get(s_mod).selected_patern!=null)
                    class_text +=architecture.layers.get(s_lay).modules.get(s_mod).selected_patern.uml_text+"\n";
                class_text += "}\n";
            }
            class_text += "}\n";
        }
        class_text += "}";
        return class_text;
    }
}
