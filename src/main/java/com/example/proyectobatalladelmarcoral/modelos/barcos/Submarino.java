package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Submarino extends Barco {
    private int vida = 30;
    private int ataque = 60;
    private int sonar = 10;
    private int velocidad = 2;
    private int equipo; //equipo 1 es rojo y equipo 2 es azul
    private int x;
    private int y;
    private AnchorPane pane;
    private final int posXMax = 1024;
    private final int posYMax = 764;
    public Submarino(int equipo, int x, int y, AnchorPane pane) {
        this.equipo = equipo;
        this.x = x;
        this.y = y;
        this.pane = pane;
    }
    @Override
    public void run() {
        Submarino submarino = new Submarino(1,0,0,pane);
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/acorazado.png")));
        pane.getChildren().add(imageView);
        submarino.mover(this.vida,this.velocidad,this.sonar,x,y,this.equipo,imageView);
    }
}
