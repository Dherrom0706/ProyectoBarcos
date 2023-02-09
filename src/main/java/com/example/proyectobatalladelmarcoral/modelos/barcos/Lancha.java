package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Lancha extends Barco {

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
