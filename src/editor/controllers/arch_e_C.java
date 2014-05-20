package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Architecture;
import Classes.Layer;
import Classes.Module;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
class Arch_my extends Architecture {
    public ArrayList<Layer_my> layers = new ArrayList<Layer_my>();

    public void add_layer(String name, String description) {//Добавить слой в архитектуру
        Layer_my layer = new Layer_my(name, description);
        this.layers.add(layer);
    }
}

class Layer_my extends Layer {
    public ArrayList<Module> modules = new ArrayList<Module>();

    public Layer_my(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add_module(String name, String description) {//Добавить модуль в слой
        Module_my module = new Module_my(name, description);
        this.modules.add(module);
    }
}

class Module_my extends Module {
    public Module_my(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

public class arch_e_C implements Initializable {

    public TextArea arch_text;
    public ImageView arch_img;
    public TextField arch_name;

    Arch_my tmp_arch = new Arch_my();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tmp_arch.setName("sd");
        tmp_arch.add_layer("1", "2");
        tmp_arch.add_layer("3", "4");
        arch_visual(tmp_arch);
    }

    public void add_layer() {//добавить слой в архитектуру
        String l_name = JOptionPane.showInputDialog("Імя");
        String l_description = JOptionPane.showInputDialog("Опис");
        tmp_arch.add_layer(l_name, l_description);
    }

    public void add_module(int layer, int pos) {//Добавить модуль
        String m_name = JOptionPane.showInputDialog("Імя");
        String m_description = JOptionPane.showInputDialog("Опис");
        tmp_arch.layers.get(layer).add_module(m_name,m_description);
    }

    public void arch_visual(Arch_my arch_in) {
        arch_name.setText(arch_in.getName());
    }
}