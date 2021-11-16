package com.example.trafficlight;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;


public class HelloApplication extends Application {
    Color black = Color.rgb(21, 19, 19);
    Color gray =  Color.rgb(48, 44, 44);
    Color green =  Color.rgb(85, 123, 56);
    Color yellow =  Color.rgb(205, 202, 41);
    Color red =  Color.rgb(205, 59, 41);
    int time = 0;
    Circle circle1 = new Circle(300,100,35,gray);
    Circle circle2 = new Circle(300,180,35,gray);
    Circle circle3 = new Circle(300,260,35,gray);
    @Override
    public void start(Stage stage) {
        StringBuilder str = new StringBuilder();
        try {
            FileReader filereader = new FileReader("C:\\Users\\Администратор\\IdeaProjects\\trafficlight\\src\\main\\java\\com\\example\\trafficlight\\theme.txt");
            int data = filereader.read();
            while (data != -1){
                str.append((char) data);
                data = filereader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setTitle(str.toString());
        Group group = new Group();
        Scene scene = new Scene(group,Color.rgb(218, 247, 166));
        stage.setScene(scene);
        Bigrect bigrect = new Bigrect(250,20,100,320,black);
        Smallrect smallrect = new Smallrect(281,340,40,200,black);
        smallrect.draw(group);
        bigrect.draw(group);
        group.getChildren().addAll(circle1,circle2,circle3);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),e->{
            time+=1;
            if (time == 1) {
                setCircle1();
            }
            else if (time == 2) {
                setCircle2();
            }
            else {
                setCircle3();
            }
            if (time >= 3) {
                time = 0;
            }


        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    void setCircle1() {
        circle3.setFill(gray);
        circle1.setFill(red);
    }
    void setCircle2() {
        circle1.setFill(gray);
        circle2.setFill(yellow);
    }
    void setCircle3() {
        circle2.setFill(gray);
        circle3.setFill(green);
    }




    public static void main(String[] args) {
        launch();
    }
}