package com.example.proyectobatalladelmarcoral.modelos;

import com.example.proyectobatalladelmarcoral.modelos.barcos.Acorazado;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ControlDeJuego {
    private int posXMax = 1024;
    private int posYMax = 764;

    public void mover(Barco barco){

        ImageView imageView = barco.getImagen();
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double velX = barco.getVelocidad()/2;
            double velY = barco.getVelocidad()/2;
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
        if (barco.getVida() == 0){
            timeline.stop();
        }
    }

    public void aniadir_barco(Barco barco, AnchorPane panel, int x, int y) {
        ImageView imagen = barco.getImagen();
        imagen.setX(x);
        imagen.setY(y);
        panel.getChildren().add(imagen);

    }
}
