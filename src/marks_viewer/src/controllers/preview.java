package src.controllers;

import Classes.Architecture;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

import static editor.services.archWork.arch_image_gen_with_patterns;

/**
 * Created by Alx Shcherbak on 26.11.2014.
 */
public class preview {
    public AnchorPane preview_text;
    public ImageView preview_im;
    //public AnchorPane descript;
    Image pre_im;


    private Architecture architecture = new Architecture();

    public void Exit(ActionEvent actionEvent) {
    }

    public void initData(Architecture architecture_to_draw) {

        pre_im = arch_image_gen_with_patterns(architecture_to_draw);
        draw_arch_im_text(architecture_to_draw, pre_im);

    }

    public void draw_arch_im_text(Architecture architecture, Image preview_image) {
        preview_text.getChildren().clear();
        //descript.getChildren().clear();


        double zoom = 0.8;
        preview_im.setImage(null);
        preview_im.setFitHeight(preview_image.getRequestedHeight() * zoom);
        preview_im.setFitWidth(preview_image.getRequestedWidth() * zoom);

        preview_im.setImage(preview_image);

        int vsize = 0,
                hsize = 0;

        hsize = 3;
        for (int i = 0; i < architecture.getLayers().size(); i++) {
            vsize++;
            vsize += architecture.getLayers().get(i).getModules().size();
        }

        vsize += 2;

        GridPane gridPane_arch = new GridPane();
        gridPane_arch.getChildren().clear();
        gridPane_arch.setHgap(hsize);
        gridPane_arch.setVgap(vsize);
        gridPane_arch.setPadding(new Insets(10, 10, 10, 10));
        gridPane_arch.setBorder(Border.EMPTY);
        //gridPane_arch.setGridLinesVisible(true);

        Label label_arch = new Label();
        label_arch.setText(architecture.getName());
        label_arch.setFont(Font.font(16));

        Label label_op_1 = new Label("Шар");
        label_op_1.setFont(Font.font(15));
        Label label_op_2 = new Label("Модуль");
        label_op_2.setFont(Font.font(15));
        Label label_op_3 = new Label("Патерн");
        label_op_3.setFont(Font.font(15));

        gridPane_arch.add(label_arch, 0, 0);
        gridPane_arch.add(label_op_1, 0, 1);
        gridPane_arch.add(label_op_2, 1, 1);
        gridPane_arch.add(label_op_3, 2, 1);

        ArrayList<Label> label_1 = new ArrayList<>(),
                label_2 = new ArrayList<>(),
                label_0 = new ArrayList<>();
        label_0.clear();
        label_1.clear();
        label_2.clear();

        int vpos = 2;
        for (int i = 0; i < architecture.getLayers().size(); i++) {
            label_0.add(new Label());
            label_0.get(label_0.size() - 1).setText(architecture.getLayers().get(i).getName());
            label_0.get(label_0.size() - 1).setFont(Font.font(14));
            gridPane_arch.add(label_0.get(label_0.size() - 1), 0, vpos);
            vpos++;
            for (int j = 0; j < architecture.getLayers().get(i).getModules().size(); j++) {
                label_0.add(new Label());
                label_0.get(label_0.size() - 1).setText(architecture.getLayers().get(i).getModules().get(j).getName());
                label_0.get(label_0.size() - 1).setFont(Font.font(12));
                gridPane_arch.add(label_0.get(label_0.size() - 1), 1, vpos);

                label_1.add(new Label());
                label_1.get(label_1.size() - 1).setText(architecture.getLayers().get(i).getModules().get(j).getSelected_pattern().getName());
                label_1.get(label_1.size() - 1).setFont(Font.font(12));
                gridPane_arch.add(label_1.get(label_1.size() - 1), 2, vpos);
                vpos++;
            }
        }

        preview_text.getChildren().add(gridPane_arch);
    }
}
