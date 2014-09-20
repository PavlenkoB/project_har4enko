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

/**
 * Created by
 * User: godex_000
 * Date: 19.09.2014.
 * Time: 0:36
 */
public class Modals implements Configuration {

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
        dialogNONE.showAndWait();
    }

    ;


    public static Response showYNDialog(String title, String text) {
        final Response[] buttonSelected = new Response[1];
        final Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);
        Scene sceneNONE = new Scene(HBoxBuilder.create().styleClass("modal-dialog").children(
                LabelBuilder.create().text(text).build(),
                ButtonBuilder.create().text(RB.getString("загальні.так")).defaultButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        buttonSelected[0] = Response.YES;
                        dialogNONE.close();
                    }
                }).build(),
                ButtonBuilder.create().text(RB.getString("загальні.ні")).cancelButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        dialogNONE.close();
                    }
                }).build()
        ).build(), Color.TRANSPARENT
        );
        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.showAndWait();
        return buttonSelected[0];
    }

    public static Response showYNDialog(String title, String text, String yes, String no) {
        final Response[] buttonSelected = new Response[1];
        final Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);
        Scene sceneNONE = new Scene(HBoxBuilder.create().styleClass("modal-dialog").children(
                LabelBuilder.create().text(text).build(),
                ButtonBuilder.create().text(yes).defaultButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        buttonSelected[0] = Response.YES;
                        dialogNONE.close();
                    }
                }).build(),
                ButtonBuilder.create().text(no).cancelButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        dialogNONE.close();
                    }
                }).build()
        ).build(), Color.TRANSPARENT
        );
        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        dialogNONE.showAndWait();
        return buttonSelected[0];
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
        dialogNONE.showAndWait();
    }

    //    static Response buttonSelected = Response.CANCEL;
    public static enum Response {
        NO, YES, CANCEL
    }
}
