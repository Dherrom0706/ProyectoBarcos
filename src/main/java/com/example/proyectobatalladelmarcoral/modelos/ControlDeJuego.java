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

import java.util.ArrayList;

public class ControlDeJuego {
    private int posXMax = 1024;
    private int posYMax = 764;

    ArrayList<Barco> barcos_partida = new ArrayList<>();
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
                barco.setX(barco.getX() + velX);
                barco.setY(barco.getY() + velY);
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
                //metodo de disparo y metodo de sonar
                Barco barco_avistado;
                if ((barco_avistado = devolver_barco_avistado(imageView,barco)) != null){
                    System.out.println(devolver_barco_avistado(imageView,barco));
                    disparo_efecuado(barco,barco_avistado);
                }

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        if (barco.getVida() == 0){
            timeline.stop();
        }
    }

    private void disparo_efecuado(Barco barco, Barco barcoAvistado) {


    }

    private Barco devolver_barco_avistado(ImageView barco_imagen, Barco barco) {

        for (Barco barco_actual_lista:barcos_partida) {
            if (barco.getSonar()*100 >= posicion_relativa_barcos(barco,barco_actual_lista)){
                return barco_actual_lista;
            }
        }

        return null;
    }

    private double posicion_relativa_barcos(Barco barco, Barco barco_actual_lista) {

       return Math.abs(Math.abs(barco.getX()-barco_actual_lista.getX())-Math.abs(barco.getY()-barco_actual_lista.getY()));

    }

    public void aniadir_barco(Barco barco, AnchorPane panel, double x, double y) {
        ImageView imagen = barco.getImagen();
        barcos_partida.add(barco);
        barco.setX(x);
        barco.setY(y);
        imagen.setX(x);
        imagen.setY(y);
        panel.getChildren().add(imagen);

        System.out.println(barcos_partida);
    }
}
