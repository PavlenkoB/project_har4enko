package editor.controllers;

import editor.services.functions;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by godex_000 on 22.07.2014.
 */
public class about_C implements Initializable {

    public TextArea change_list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO завантажити текс з файлу і відобразити в текстовому полі
        change_list.setText(functions.read_lines_from_file(new File(String.valueOf(getClass().getResource("README.md")))));
    }
}
