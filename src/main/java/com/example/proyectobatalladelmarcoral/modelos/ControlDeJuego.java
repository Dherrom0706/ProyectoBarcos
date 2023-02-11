package com.example.proyectobatalladelmarcoral.modelos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.lang.Math;
import javafx.geometry.Bounds;

import java.util.ArrayList;

public class ControlDeJuego {
    private int posXMax = 1024;
    private int posYMax = 764;

    ArrayList<Barco> barcos_partida = new ArrayList<>();
    private Timeline timeline;
    public synchronized void mover(Barco barco){

        ImageView imageView = barco.getImagen();
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        //hacer un bucle que recorra la lista de barcos y hacer un timeline para cada uno
        timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
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
                if (((barco_avistado = devolver_barco_avistado(imageView,barco)) != null) && (barco_avistado.getEquipo() != barco.getEquipo())){
                    disparo_efecuado(barco,barco_avistado);
                }
                if (barco_avistado.getVida() <= 0) {
                    timeline.stop();
                }

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private synchronized void disparo_efecuado(Barco barco, Barco barcoAvistado) {

        barcoAvistado.setVida(barcoAvistado.getVida()-barco.getAtaque());
        System.out.println("Barco que dispara: "+barco.getVida());
        System.out.println("Barco que recibe: "+barcoAvistado.getVida());

    }

    private synchronized Barco devolver_barco_avistado(ImageView barco_imagen, Barco barco) {

        for (Barco barco_actual_lista:barcos_partida) {
            Bounds bounds1 = barco_imagen.getBoundsInParent();
            double centerX1 = bounds1.getMinX() + bounds1.getWidth() / 2;
            double centerY1 = bounds1.getMinY() + bounds1.getHeight() / 2;
            Bounds bounds2 = barco_actual_lista.getImagen().getBoundsInParent();
            double centerX2 = bounds2.getMinX() + bounds2.getWidth() / 2;
            double centerY2 = bounds2.getMinY() + bounds2.getHeight() / 2;

            double dx = centerX1 - centerX2;
            double dy = centerY1 - centerY2;
            double distancia = Math.sqrt(dx * dx + dy * dy);

            if (distancia <= barco.getSonar()*20){
                return barco_actual_lista;
            }
        }

        return null;
    }


    public synchronized void aniadir_barco(Barco barco, AnchorPane panel, double x, double y) {
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
