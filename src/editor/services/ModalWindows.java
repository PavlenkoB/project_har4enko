package editor.services;

import editor.controllers.main_C;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Created by godex_000 on 26.07.2014.
 */
public class ModalWindows {
    public static Integer yes_no(String title, String text, String yes_text, String no_text) {
        AnchorPane window_content = new AnchorPane();
        window_content.setPrefWidth(Region.USE_COMPUTED_SIZE);
        window_content.setPrefHeight(Region.USE_COMPUTED_SIZE);
        Stage stage = new Stage();
        stage.setMinHeight(50);
        stage.setMinHeight(100);
        stage.setTitle(title);
        Label L_text = new Label(text);
        Button B_yes = new Button(yes_text);
        B_yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");

            }
        });
        Button B_no = new Button(no_text);
        window_content.getChildren().addAll(L_text, B_no, B_yes);
        stage.setScene(new Scene(window_content));
        stage.show();
        return -1;
    }
}
