package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Acorazado extends Barco {

    private int vida = 120;
    private int ataque = 80;
    private int sonar = 20;
    private int velocidad = 3;
    private int equipo; //equipo 1 es rojo y equipo 2 es azul
    private int x;
    private int y;
    private AnchorPane pane;
    private final int posXMax = 1024;
    private final int posYMax = 764;
    public Acorazado(int equipo, int x, int y, AnchorPane pane) {
        this.equipo = equipo;
        this.x = x;
        this.y = y;
        this.pane = pane;
    }

    @Override
    public void run() {
        Acorazado acorazado = new Acorazado(1,x,y,pane);
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/acorazado.png")));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.getChildren().add(imageView);
            }
        });
        acorazado.mover(this.vida,this.velocidad,this.sonar,x,y,this.equipo,imageView);
    }
}
