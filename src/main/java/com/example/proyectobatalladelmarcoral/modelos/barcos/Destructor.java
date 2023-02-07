package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.JuegoApp;
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

import java.net.URISyntaxException;

public class Destructor extends Barco {

    ImageView imagen = new ImageView(new Image(JuegoApp.class.getResourceAsStream("images/acorazado.png")));

    public Destructor() throws URISyntaxException {
    }

    @Override
    public int getVida() {
        return 80;
    }

    @Override
    public int getAtaque() {
        return 50;
    }

    @Override
    public int getSonar() {
        return 15;
    }

    @Override
    public int getVelocidad() {
        return 5;
    }

    @Override
    public ImageView getImagen() {
        return imagen;
    }
}
