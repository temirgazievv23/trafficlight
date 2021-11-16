package com.example.trafficlight;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Smallrect extends Bigrect{
    Smallrect(int posx, int posy, int width, int height, Color color) {
        super(posx, posy, width, height, color);
    }
    @Override
    void draw (Group root) {
        Rectangle rectangle = new Rectangle(posx,posy,width,height);
        rectangle.setStroke(color);
        rectangle.setFill(color);
        root.getChildren().add(rectangle);
    }
}
