package com.example.trafficlight;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bigrect {
    int posx;
    int posy;
    int width;
    int height;
    Color color;
    Bigrect(int posx,int posy,int width,int height,Color color) {
        this.posx = posx;
        this.posy = posy;
        this.width = width;
        this.height = height;
        this.color = color;

    }


    void draw (Group root) {
        Rectangle rectangle = new Rectangle(posx,posy,width,height);
        rectangle.setFill(color);
        root.getChildren().add(rectangle);
    }
}
