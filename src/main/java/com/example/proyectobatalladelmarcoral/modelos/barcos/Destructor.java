package com.example.proyectobatalladelmarcoral.modelos.barcos;

import com.example.proyectobatalladelmarcoral.modelos.Barco;

public class Destructor extends Barco {
    protected int vida;
    protected int ataque;
    protected int sonar;
    protected int velocidad;
    protected int equipo; //equipo 1 es rojo y equipo 2 es azul
    protected int x;
    protected int y;

    public Destructor(int equipo, int x, int y) {
        this.vida = 80;
        this.ataque = 50;
        this.sonar = 15;
        this.velocidad = 5;
        this.equipo = equipo;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {

    }

    @Override
    protected void mover() {

    }
}
