package ua.edu.nau.godex.projectharchenko.repository_editor.controllers;
/*
import classes.Pattern;
import repository_editor.classes.DerbyDBManager;
import repository_editor.classes.Modals;
import repository_editor.interfaces.Configuration;
import repository_editor.services.DrawUml;
import repository_editor.services.RepEditorFunctions;
*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import ua.edu.nau.godex.projectharchenko.classes.Pattern;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.DerbyDBManager;
import ua.edu.nau.godex.projectharchenko.repository_editor.classes.Modals;
import ua.edu.nau.godex.projectharchenko.repository_editor.interfaces.Configuration;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.DrawUml;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.RepEditorFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 23.07.2014.
 */
public class PaternEditorController implements Initializable, Configuration {
    public TextField TA_pattern_name;
    public TextArea TA_pattern_description;
    public TextArea TA_pattern_uml;
    public Image pattern_image;
    public Pattern tmp_pattern;
    public DerbyDBManager derby_DB;
    public GridPane root;

    void initData(Pattern pattern, DerbyDBManager derby_con) {
        tmp_pattern = pattern;

        derby_DB = derby_con;
        Stage thisstage = (Stage) root.getScene().getWindow();
        thisstage.getIcons().add(new Image("/res/img/uml_icon.png"));
        thisstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (Modals.Response.YES == Modals.showYNDialog(RB.getString("загальні.увага"), RB.getString("загальні.ви_впевнені_що_бажаете_вийти_незбережені_зміни_буде_втрачено"))) {
                } else {
                    we.consume();
                }
            }
        });
        /**/
        TA_pattern_description.setText(tmp_pattern.getDescription());
        TA_pattern_name.setText(tmp_pattern.getName());
        TA_pattern_uml.setText(tmp_pattern.getUmlText());
    }

    public void initialize(URL url, ResourceBundle rb) {

/*
//при двойном клике грузить патерн
        LV_paterns_DB.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1 && derby_DB != null) {
                    load_this_patern_DB(null);
                }
            }
        });
        //list_load_DB();/**/
/**/
    }

    /**
     * Показуе превю
     *
     * @param actionEvent
     */
    public void preview(ActionEvent actionEvent) {
        pattern_image = RepEditorFunctions.drawClassImageThread(TA_pattern_uml.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/repository_editor/views/image_preview.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        try {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene((Pane) loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImagePreviewController controller = loader.<ImagePreviewController>getController();
        controller.initData(pattern_image, tmp_pattern.getName());
        //stage.setTitle("" + arch_old.getName());
        stage.show();
    }

    public void save(ActionEvent actionEvent) {
        tmp_pattern.setName(TA_pattern_name.getText());
        tmp_pattern.setDescription(TA_pattern_description.getText());
        tmp_pattern.setUmlText(TA_pattern_uml.getText());
        tmp_pattern.setPreview(DrawUml.draw_class(TA_pattern_uml.getText()));
        Pattern.pattern_save_to_DB(tmp_pattern, derby_DB);
        Modals.showInfoApplicationModal("Інформація", "Паттерн збережено");
    }

    public void cancel(ActionEvent actionEvent) {

    }
}
