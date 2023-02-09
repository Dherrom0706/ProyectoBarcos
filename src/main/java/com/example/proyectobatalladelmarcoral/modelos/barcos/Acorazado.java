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
    public double x = 0;
    public double y = 0;
    public String equipo = "";
    public int vida = getVida();
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

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String getEquipo() {
        return this.equipo;
    }
    @Override
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

}
