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
    private String tipo;
    private int xDer;
    private int yAbajo;

    private int xIzq;
    private int yArriba;
    public Barco(double vida, int sonar, int velocidad, int ataque, ImageView imageView, String equipo,String tipo) {
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
        this.tipo = tipo;

        if (this.tipo.equals("lancha")){
            this.imageView.setFitWidth(120);
            this.imageView.setFitHeight(40);
            xDer = 90;
            yAbajo = 73;
            yArriba = 0;
            xIzq = 0;
        } else if (this.tipo.equals("acorazado")){
            this.imageView.setFitWidth(220);
            this.imageView.setFitHeight(80);
            xDer = 160;
            yAbajo = 110;
            xIzq = -35;
            yArriba =22;
        } else if (this.tipo.equals("destructor")){
            this.imageView.setFitWidth(220);
            this.imageView.setFitHeight(60);
            xDer = 160;
            yAbajo = 92;
            xIzq = -35;
            yArriba =22;
        }else if (this.tipo.equals("submarino")){
            this.imageView.setFitWidth(140);
            this.imageView.setFitHeight(40);
            xDer = 90;
            yAbajo = 73;
            yArriba = 0;
            xIzq = 0;
        }
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
        x = x + velX;
        if (imageView.getX() >= posXMax - xDer || imageView.getX() <= xIzq) {
            velX = velX * -1;
            if (random < 0.2) {
                velY = velY * -1;
            }
        }

        imageView.setY(imageView.getY() + velY);
        y = y + velY;
        if (imageView.getY() >= posYMax - yAbajo || imageView.getY() <= yArriba) {
            velY = velY * -1;
            if (random < 0.2) {
                velX = velX * -1;
            }
        }

        // Rotar la imagen según la dirección del movimiento
        double angle = Math.toDegrees(Math.atan2(velY, velX));
        imageView.setRotate(angle);

    }

}
