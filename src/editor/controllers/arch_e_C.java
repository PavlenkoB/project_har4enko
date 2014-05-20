package editor.controllers;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Architecture;
import Classes.Layer;
import editor.classes.DerbyDBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author godex_000
 */
class Arch_my extends Architecture {
    public ArrayList<Layer> layers;
    public void add_layer(String name,String description ) {
        Layer_my layer = new Layer_my(name, description);
        this.layers.add(layer);
    }
}
class Layer_my extends Layer {
    public Layer_my(String name,String description){
        this.name=name;
        this.description=description;
    }

}
public class arch_e_C implements Initializable {

    public TextArea arch_text;
    public ImageView arch_img;
    public TextField arch_name;

    Arch_my tmp_arch=new Arch_my();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tmp_arch.setName("sd");
        tmp_arch.add_
        arch_visual(tmp_arch);
    }
    public void add_layer(){//добавить слой в архитектуру

    }
    public void add_module(int layer, int pos){

        String l_name = JOptionPane.showInputDialog("Імя");
        String l_description = JOptionPane.showInputDialog("Опис");
        tmp_arch.add_layer(l_name,l_description);
    }
    public void arch_visual(Arch_my arch_in){
        arch_name.setText(arch_in.getName());
    }
}