package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Lancha extends Barco {
    private int vida = 10;
    private int ataque = 20;
    private int sonar = 12;
    private int velocidad = 10;
    private int equipo; //equipo 1 es rojo y equipo 2 es azul
    private int x;
    private int y;
    private Pane pane;
    private final int posXMax = 1024;
    private final int posYMax = 764;
    public Lancha(int equipo, int x, int y, Pane pane) {
        this.equipo = equipo;
        this.x = x;
        this.y = y;
        this.pane = pane;
    }
    @Override
    public void run() {
        Lancha lancha = new Lancha(1,0,0,pane);
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/acorazado.png")));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.getChildren().add(imageView);
            }
        });
        lancha.mover(this.vida,this.velocidad,this.sonar,x,y,this.equipo,imageView);
    }
}
