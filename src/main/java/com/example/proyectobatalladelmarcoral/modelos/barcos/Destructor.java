package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Destructor extends Barco {
    private int vida = 80;
    private int ataque = 50;
    private int sonar = 15;
    private int velocidad = 5;
    private int equipo; //equipo 1 es rojo y equipo 2 es azul
    private int x;
    private int y;
    private Pane pane;
    private final int posXMax = 1024;
    private final int posYMax = 764;
    public Destructor(int equipo, int x, int y, Pane pane) {
        this.equipo = equipo;
        this.x = x;
        this.y = y;
        this.pane = pane;
    }
    @Override
    public void run() {
        Destructor destructor = new Destructor(1,0,0,pane);
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/acorazado.png")));
        pane.getChildren().add(imageView);
        destructor.mover(this.vida,this.velocidad,this.sonar,x,y,this.equipo,imageView);
    }
}
