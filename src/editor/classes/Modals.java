package editor.classes;

import editor.interfaces.Configuration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by
 * User: godex_000
 * Date: 19.09.2014.
 * Time: 0:36
 */
public class Modals implements Configuration {

    public static void showInfoAM(String title,String text){
        Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);

        Scene sceneNONE = new Scene(VBoxBuilder.create()
                .children(
                        new Text(title),
                        new Text(text))
                .alignment(Pos.CENTER)
                .padding(new Insets(10))
                .build());

        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.show();
    }
    public static boolean showOptionDialog(String title,String text){
        Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);


        Scene sceneNONE = new Scene(VBoxBuilder.create()
                .children(
                        new Button(title),
                        new Button(text),
                        new Button(resourceBundle.getString("загальні.ні")))
                .alignment(Pos.CENTER)
                .padding(new Insets(10))
                .build());

        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.show();
        return false;
    }

    public static void infoN(String title,String text){
        Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.NONE);

        Scene sceneNONE = new Scene(VBoxBuilder.create()
                .children(
                        new Text(title),
                        new Text(text))
                .alignment(Pos.CENTER)
                .padding(new Insets(10))
                .build());

        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.show();
    }
    public static void infoWM(String title,String text){
        Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.WINDOW_MODAL);

        Scene sceneNONE = new Scene(VBoxBuilder.create()
                .children(
                        new Text(title),
                        new Text(text))
                .alignment(Pos.CENTER)
                .padding(new Insets(10))
                .build());

        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.show();
    }

}
