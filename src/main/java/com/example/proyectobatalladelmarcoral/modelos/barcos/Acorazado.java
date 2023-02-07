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

public class Acorazado extends Barco {

    @Override
    public int getVida() {
        return 0;
    }

    @Override
    public int getAtaque() {
        return 0;
    }

    @Override
    public int getSonar() {
        return 0;
    }

    @Override
    public int getVelocidad() {
        return 0;
    }

    @Override
    public ImageView getImagen() {
        return null;
    }
}
