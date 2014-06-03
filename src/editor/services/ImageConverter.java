package editor.services;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;

/**
 * Created by godex_000 on 03.06.2014.
 */
public class ImageConverter {
    public static java.awt.image.BufferedImage FXtoAWT(javafx.scene.image.Image image) {
        final int width = (int) image.getWidth();
        final int height = (int) image.getHeight();

        final BufferedImage awtImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        final Graphics g = awtImage.createGraphics();

        ImageView imageView = new ImageView(image);
        final BorderPane borderPane = new BorderPane();
        borderPane.setCenter(imageView);
        final JFXPanel panel = new JFXPanel();
        panel.setSize(width, height);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                Scene scene = new Scene(borderPane, width, height);
                panel.setScene(scene);
            }
        });
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                panel.paint(g);
                g.dispose();
            }
        });
        return awtImage;
    }

    public static javafx.scene.image.Image AWTtoFX(java.awt.Image image) throws IOException {
        if (!(image instanceof RenderedImage)) {
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            image = bufferedImage;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, "png", out);
        out.flush();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        return new javafx.scene.image.Image(in);
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(java.awt.Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
