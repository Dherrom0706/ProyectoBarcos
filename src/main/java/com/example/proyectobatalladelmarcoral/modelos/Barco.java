package com.example.proyectobatalladelmarcoral.modelos;

public abstract class Barco extends Thread{

    protected int vida;
    protected int ataque;
    protected int sonar;
    protected int velocidad;
    protected int equipo; //equipo 1 es rojo y equipo 2 es azul
    protected int x;
    protected int y;
    protected abstract void mover();

}
