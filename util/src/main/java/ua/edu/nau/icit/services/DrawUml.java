package ua.edu.nau.icit.services;

/**
 * Created by godex_000 on 20.05.2014.
 */
public class DrawUml {
    /**
     * С текста UML генерирует картинку
     *
     * @param class_text текст на базе которого генерируе картнку
     * @return картинка javaFX
     */
    public static javafx.scene.image.Image draw_class(String class_text) {
        return functions.draw_class_image(class_text);
    }

}

