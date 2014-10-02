package create_arch.Controllers;

import Classes.Architecture;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static editor.services.arch_work.arch_image_gen_with_patterns;

/**
 * Created by Alex on 30.07.2014.
 */
public class preview_create_arch_C implements Initializable {
    public AnchorPane preview_text;
    public ImageView preview_im;
    public Button next;
    public Button back;
    public TextField go_to_value;
    public Button go_to;
    public AnchorPane descript;
    ArrayList<Architecture> architectures = new ArrayList<>();
    int sel_arch;
    Image undo_im, redo_im, pre_im;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void draw_arch_im_text(Architecture architecture, Image preview_image, int num_all, int num_selected) {
        preview_text.getChildren().clear();
        descript.getChildren().clear();

        Label lay_desc = new Label();

        lay_desc.setText("Архітектура A" + (num_selected + 1) + " з " + num_all + " архітектур");
        lay_desc.setAlignment(Pos.CENTER);
        lay_desc.setFont(Font.font(15));

        descript.setRightAnchor(lay_desc, 25.0);
        descript.setLeftAnchor(lay_desc, 25.0);
        descript.setTopAnchor(lay_desc, 5.0);
        descript.setBottomAnchor(lay_desc, 5.0);
        descript.getChildren().add(lay_desc);

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

    public void Exit(ActionEvent actionEvent) {
    }

    public void next_act(ActionEvent actionEvent) {
        sel_arch++;
        pre_im = redo_im;
        myThread = new Thread();
        myThread.start();
        draw_arch_im_text(architectures.get(sel_arch), pre_im, architectures.size(), sel_arch);
        border_contr(architectures.size(), sel_arch);
    }

    public void go_to_act(ActionEvent actionEvent) {
        String goto_str = go_to_value.getText().toString();
        Integer buff = Integer.parseInt(goto_str);
        int goto_value = (int) buff;
        sel_arch = goto_value - 1;
        pre_im = arch_image_gen_with_patterns(architectures.get(sel_arch));
        myThread = new Thread();
        myThread.start();
        draw_arch_im_text(architectures.get(sel_arch), pre_im, architectures.size(), sel_arch);
        border_contr(architectures.size(), sel_arch);
    }

    public void back_act(ActionEvent actionEvent) {
        sel_arch--;
        pre_im = undo_im;
        myThread = new Thread();
        myThread.start();
        draw_arch_im_text(architectures.get(sel_arch), pre_im, architectures.size(), sel_arch);
        border_contr(architectures.size(), sel_arch);
    }

    public void border_contr(int num_all, int num_selected) {
        if (num_selected == 0) {
            back.setDisable(true);
        } else if ((num_selected + 1) == num_all) {
            next.setDisable(true);
        } else {
            back.setDisable(false);
            next.setDisable(false);
        }
    }

    public void initData(ArrayList<Architecture> architectures_done) {
        /*for (int i=0;i<architectures_done.size();i++){
            architectures.add(architectures_done.get(i));
        }*/
        architectures = architectures_done;
        sel_arch = 0;
        pre_im = arch_image_gen_with_patterns(architectures.get(sel_arch));
        myThread.start();
        draw_arch_im_text(architectures.get(sel_arch), pre_im, architectures.size(), sel_arch);
        border_contr(architectures.size(), sel_arch);
    }

    private Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (sel_arch != 0)
                        undo_im = arch_image_gen_with_patterns(architectures.get(sel_arch - 1));
                    if (sel_arch != architectures.size() - 1)
                        redo_im = arch_image_gen_with_patterns(architectures.get(sel_arch + 1));
                }
            });
        }
    });
}
