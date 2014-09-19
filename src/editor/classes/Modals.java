package editor.classes;

import editor.interfaces.Configuration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by
 * User: godex_000
 * Date: 19.09.2014.
 * Time: 0:36
 */
public class Modals implements Configuration {

//    static Response buttonSelected = Response.CANCEL;
    public enum Response { NO, YES, CANCEL };

    public static void showInfoAM(String title, String text) {
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

    public static void showOptionDialogYN(String title, String text, final Thread functionToDo) {
        //Response buttonSelected;
        final Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);


        Scene sceneNONE =
                new Scene(
                        HBoxBuilder.create().styleClass("modal-dialog").children(
                                LabelBuilder.create().text(text).build(),

                                ButtonBuilder.create().text(resourceBundle.getString("загальні.так")).defaultButton(true).onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
// take action and close the dialog.
                                        //System.out.println("Liked: " + webView.getEngine().getTitle());
                                        //primaryStage.getScene().getRoot().setEffect(null);
                                       functionToDo.run();
                                        dialogNONE.close();
                                    }
                                }).build(),
                                ButtonBuilder.create().text(resourceBundle.getString("загальні.ні")).cancelButton(true).onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
// abort action and close the dialog.
                                        //System.out.println("Disliked: " + webView.getEngine().getTitle());
                                        //primaryStage.getScene().getRoot().setEffect(null);
                                        //buttonSelected=Response.NO;
                                        dialogNONE.close();

                                    }
                                }).build()
                        ).build()
                        , Color.TRANSPARENT
                );

        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.show();
        //dialogNONE.getOnCloseRequest

        //return buttonSelected;
    }

    public static void infoN(String title, String text) {
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

    public static void infoWM(String title, String text) {
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
