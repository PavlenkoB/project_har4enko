package editor.classes;

import editor.interfaces.Configuration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
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
 * android test
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
        donotResizeAndAddStyle(dialogNONE);
        dialogNONE.showAndWait();
    }

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
                        buttonSelected[0] = Response.NO;
                        dialogNONE.close();
                    }
                }).build()
        ).build(), Color.TRANSPARENT
        );
        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        donotResizeAndAddStyle(dialogNONE);
        dialogNONE.showAndWait();
        return buttonSelected[0];
    }

    /**
     *
     * @param title Title of window
     * @param text text of window
     * @param val value by default
     * @return inputed text
     */
    public static String showInputDialog(String title, String text, String val) {
        final String[] inputVal = new String[1];
        final TextField[] textField = new TextField[1];
        final Stage dialogNONE = new Stage();
        dialogNONE.initModality(Modality.APPLICATION_MODAL);
        Scene sceneNONE = new Scene(HBoxBuilder.create().styleClass("modal-dialog").children(
                LabelBuilder.create().text(text).build(),
                ButtonBuilder.create().text(RB.getString("загальні.ввід")).defaultButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        dialogNONE.close();
                    }
                }).build(),
                ButtonBuilder.create().text(RB.getString("загальні.відміна")).cancelButton(true).onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        textField[0].setText(null);
                        dialogNONE.close();
                    }
                }).build(),
                TextFieldBuilder.create().text(val).id("tfInput").build()
        ).build(), Color.TRANSPARENT
        );
        textField[0] = (TextField) sceneNONE.lookup("#tfInput");
        dialogNONE.setTitle(title);
        dialogNONE.setScene(sceneNONE);
        donotResizeAndAddStyle(dialogNONE);
        dialogNONE.showAndWait();
        return textField[0].getText();
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
        donotResizeAndAddStyle(dialogNONE);
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
        donotResizeAndAddStyle(dialogNONE);
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
        donotResizeAndAddStyle(dialogNONE);
        dialogNONE.showAndWait();
    }

    /**
     * Додати стиль до модального вікна
     * не зміний розмір і прибрати кнопки закриття і зменшення
     *
     * @param stage - окно для которого применить
     */
    private static void donotResizeAndAddStyle(Stage stage) {
        stage.getScene().getStylesheets().add(Modals.class.getResource("/editor/css/style.css").toExternalForm());
        //stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
    }

    //    static Response buttonSelected = Response.CANCEL;
    public static enum Response {
        NO, YES, CANCEL
    }


}
