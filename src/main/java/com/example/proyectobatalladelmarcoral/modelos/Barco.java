package com.example.proyectobatalladelmarcoral.modelos;


import javafx.scene.image.ImageView;

public class Barco{

    private double vida;
    private int sonar;
    private int velocidad;
    private int ataque;
    private ImageView imageView;
    private double x;
    private double y;
    private String equipo;
    private double velX;
    private double velY;
    private int posXMax = 1024;
    private int posYMax = 764;
    private int recarga = 0;

    public Barco(double vida, int sonar, int velocidad, int ataque, ImageView imageView, String equipo) {
        this.vida = vida;
        this.sonar = sonar;
        this.velocidad = velocidad;
        this.ataque = ataque;
        this.imageView = imageView;
        this.equipo = equipo;
        this.x = imageView.getX();
        this.y = imageView.getY();
        this.velX = velocidad / 2;
        this.velY = velocidad / 2;
    }

    public double getVida() {
        return vida;
    }

    public int getSonar() {
        return sonar;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public ImageView getImagen() {
        return imageView;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getRecarga() { return recarga; }

    public void setRecarga(int recarga) { this.recarga = recarga; }

    public void mover() {
        double random = Math.random();
        imageView.setX(imageView.getX() + velX);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        x = x + velX;
        if (imageView.getX() >= posXMax - 90 || imageView.getX() <= 0) {
            velX = velX * -1;
            if (random < 0.2) {
                velY = velY * -1;
            }
        }
        imageView.setY(imageView.getY() + velY);
        y = y + velY;
        if (imageView.getY() >= posYMax - 73 || imageView.getY() <= 0) {
            velY = velY * -1;
            if (random < 0.2) {
                velX = velX * -1;
            }
        }
    }

}
