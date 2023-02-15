package com.example.proyectobatalladelmarcoral.modelos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.lang.Math;
import javafx.geometry.Bounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ControlDeJuego {
    private int posXMax = 1024;
    private int posYMax = 764;

    ArrayList<Barco> barcos_partida = new ArrayList<>();
    HashMap<Barco,Timeline> mapa_barcos_timeline = new HashMap<>();
    Timeline timeline;

    public void comenzar_partida(){
        for (Barco barco : barcos_partida) {
            timeline = new Timeline(new KeyFrame(Duration.millis(10),actionEvent -> {
                barco.mover();
                barco_avistado(barco);
                barco.setRecarga(barco.getRecarga() + 10);
            }));
            mapa_barcos_timeline.put(barco,timeline);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            System.out.println(mapa_barcos_timeline);
        }
    }


    private void disparo_efecuado(Barco barco, Barco barcoAvistado) {
        double r = Math.random();
        double dmg;

        if (barco.getRecarga() >= 2000){
            System.out.println(barco.getRecarga());
            if (r < 0.25){
                dmg = 0.0;
            } else if (r < 0.50) {
                dmg = barco.getAtaque() / 2;
            }else {
                dmg = barco.getAtaque();
            }
            barcoAvistado.setVida(barcoAvistado.getVida()-dmg);
            barco.setRecarga(0);

            System.out.println("Barco que dispara: "+barco+"       , "+barco.getVida()+"  "+barco.getEquipo());
            System.out.println("Barco que recibe: "+barcoAvistado+"    , "+barcoAvistado.getVida()+"  "+barcoAvistado.getEquipo());
        }

    }

    private void barco_avistado(Barco barco) {

        for (Barco barco_actual_lista:barcos_partida) {
            if (!barco.getEquipo().equals(barco_actual_lista.getEquipo())){
                Bounds bounds1 = barco.getImagen().getBoundsInParent();
                double centerX1 = bounds1.getMinX() + bounds1.getWidth() / 2;
                double centerY1 = bounds1.getMinY() + bounds1.getHeight() / 2;
                Bounds bounds2 = barco_actual_lista.getImagen().getBoundsInParent();
                double centerX2 = bounds2.getMinX() + bounds2.getWidth() / 2;
                double centerY2 = bounds2.getMinY() + bounds2.getHeight() / 2;

                double dx = centerX1 - centerX2;
                double dy = centerY1 - centerY2;
                double distancia = Math.sqrt(dx * dx + dy * dy);
                if (distancia <= barco.getSonar()*20){

                    if (barco_actual_lista.getVida() <= 0){
                        Timeline comprobar = mapa_barcos_timeline.get(barco_actual_lista);
                        comprobar.stop();
                    }else{
                        disparo_efecuado(barco,barco_actual_lista);
                    }

                }
            }
        }
    }

    /*Bounds bounds1 = barco.getImagen().getBoundsInParent();
     double centerX1 = bounds1.getMinX() + bounds1.getWidth() / 2;
     double centerY1 = bounds1.getMinY() + bounds1.getHeight() / 2;
     Bounds bounds2 = barco_actual_lista.getImagen().getBoundsInParent();
     double centerX2 = bounds2.getMinX() + bounds2.getWidth() / 2;
     double centerY2 = bounds2.getMinY() + bounds2.getHeight() / 2;

     double dx = centerX1 - centerX2;
     double dy = centerY1 - centerY2;
     double distancia = Math.sqrt(dx * dx + dy * dy);

     if (distancia <= barco.getSonar()*20){
     if (barco_actual_lista.getVida() <= 0){
     Timeline comprobar = mapa_barcos_timeline.get(barco_actual_lista);
     comprobar.stop();
     }else{
     if (!barco.getEquipo().equals(barco_actual_lista.getEquipo())){
     disparo_efecuado(barco,barco_actual_lista);
     }
     }
     break;
     }*/


    public synchronized void aniadir_barco(Barco barco, AnchorPane panel, double x, double y) {
        ImageView imagen = barco.getImagen();
        barcos_partida.add(barco);
        imagen.setX(x);
        imagen.setY(y);
        panel.getChildren().add(imagen);
        System.out.println(barcos_partida);
    }
}
