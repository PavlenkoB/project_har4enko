package ua.edu.nau.godex.projectharchenko.repository_editor.services;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by godex_000 on 03.06.2014.
 */
public class ImageConverter {
    public static java.awt.Image FXimgToAWTimg(javafx.scene.image.Image image) {
        return SwingFXUtils.fromFXImage(image, null);
    }

    public static javafx.scene.image.Image AWTImgtoFXImg(java.awt.Image awtimage) {
        return SwingFXUtils.toFXImage(AWTImgtoBufferedImage(awtimage), null);
    }

    /**
     * Converts a given awt Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage AWTImgtoBufferedImage(java.awt.Image img) {
        if (img instanceof BufferedImage) {
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

    /**
     * Converts a given FX Image into a BufferedImage
     *
     * @param fxImage The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage FXImgtoBufferedImage(Image fxImage) {
        // Create a buffered image with transparency
        BufferedImage bimage = SwingFXUtils.fromFXImage(fxImage, null);

        // Return the buffered image
        return bimage;
    }
}
