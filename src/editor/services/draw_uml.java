package editor.services;

import javafx.scene.image.Image;

import java.io.*;

/**
 * Created by godex_000 on 20.05.2014.
 */
public class draw_uml {
    public static Image draw_class(String class_text){
        Image class_image = null;
        BufferedWriter out_data = null;
        try {
            out_data = new BufferedWriter(new FileWriter(new File("class.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringReader stringReader = new StringReader(class_text);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try {
            out_data.write("@startuml");

        out_data.newLine();
        out_data.write("skinparam backgroundColor transparent\n" +//Прозрачный фон
                "skinparam roundCorner 10");                        //Скругленые углы
        out_data.newLine();
        for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            out_data.write(line);
            out_data.newLine();
        }
        out_data.newLine();
        out_data.write("@enduml");
        bufferedReader.close();
        out_data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] cmd = {"cmd", "/C", "plantuml.jar -charset utf-8 class.txt"};     //запустить отрисовку
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Waiting for batch file ...");
        try {
            p.waitFor();                                                            //Ждать пока отрисует
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Batch file done.");
        class_image = new Image("file:class.png", true);
        return class_image;
    }
}
