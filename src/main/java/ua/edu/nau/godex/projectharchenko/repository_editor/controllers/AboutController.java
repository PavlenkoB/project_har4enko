package ua.edu.nau.godex.projectharchenko.repository_editor.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import ua.edu.nau.godex.projectharchenko.repository_editor.services.RepEditorFunctions;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 22.07.2014.
 */
public class AboutController implements Initializable {

    public TextArea change_list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            change_list.setText(RepEditorFunctions.read_lines_from_file(getClass().getResource("/README.md").toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
