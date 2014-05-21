package editor.services;

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
        while (line_pos<in_string.length()) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }
}
