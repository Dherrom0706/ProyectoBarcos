package com.example.proyectobatalladelmarcoral.modelos;


import javafx.scene.image.ImageView;

public class Barco{

    private int vida;
    private int sonar;
    private int velocidad;
    private int ataque;
    private ImageView imageView;
    private double x;
    private double y;
    private String equipo;

    public Barco(int vida, int sonar, int velocidad, int ataque, ImageView imageView, String equipo) {
        this.vida = vida;
        this.sonar = sonar;
        this.velocidad = velocidad;
        this.ataque = ataque;
        this.imageView = imageView;
        this.equipo = equipo;


    }

    public int getVida(){
        return this.vida;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public int getSonar(){
        return this.sonar;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public ImageView getImagen(){
        return this.imageView;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public String getEquipo(){
        return this.equipo;
    }
    public void setEquipo(String equipo){
        this.equipo = equipo;
    }
    public void setVida(int vida){
        this.vida = vida;
    }

}
