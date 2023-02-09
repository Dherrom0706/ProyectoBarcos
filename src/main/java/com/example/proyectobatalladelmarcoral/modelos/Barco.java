package com.example.proyectobatalladelmarcoral.modelos;


import javafx.scene.image.ImageView;

public abstract class Barco{
    public abstract int getVida();
    public abstract int getAtaque();
    public abstract int getSonar();
    public abstract int getVelocidad();
    public abstract ImageView getImagen();
    public abstract double getX();
    public abstract double getY();
    public abstract void setX(double x);
    public abstract void setY(double y);
    public abstract String getEquipo();
    public abstract void setEquipo(String equipo);
    public abstract void setVida(int vida);
}
