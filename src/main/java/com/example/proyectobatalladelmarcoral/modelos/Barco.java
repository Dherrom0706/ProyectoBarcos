package com.example.proyectobatalladelmarcoral.modelos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public abstract class Barco extends Thread{

    private final int posXMax = 1024;
    private final int posYMax = 764;


    public void mover(int vida,int velocidad,int sonar,int x, int y, int equipo, ImageView imageView){


        imageView.setLayoutY(VPos.TOP.ordinal());
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double velX = velocidad/2;
            double velY = velocidad/2;
            int random;

            @Override
            public void handle(ActionEvent event) {

                imageView.setX(imageView.getX() + velX);
                imageView.setY(imageView.getY() + velY);

                if (imageView.getX() >= posXMax-90 || imageView.getX() <= 0){
                    velX = velX*(-1);
                    random = (int) (Math.random()*10+1);
                    System.out.println(random);

                }
                if (imageView.getY() >= posYMax-73 || imageView.getY() <= 0){

                    velY = velY*(-1);
                    random = (int) (Math.random()*10+1);
                    System.out.println(random);
                }

                if ((imageView.getX() >= posXMax-90 || imageView.getX() <= 0) && random==2){

                    velY = velY*(-1);

                }
                if ((imageView.getY() >= posYMax-73 || imageView.getY() <= 0) && random==2){

                    velX = velX*(-1);
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        if (vida== 0){
            timeline.stop();
        }
    }

}
