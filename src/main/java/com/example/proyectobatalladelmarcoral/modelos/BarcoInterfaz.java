package com.example.proyectobatalladelmarcoral.modelos;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class BarcoInterfaz {

    private Label lb_vida;
    private ProgressBar progreso;
    private String equipo;

    public BarcoInterfaz(Label lb_vida, ProgressBar progreso, String equipo) {
        this.lb_vida = lb_vida;
        this.progreso = progreso;
        this.equipo = equipo;
    }

    public Label getLb_vida() {
        return lb_vida;
    }

    public void setLb_vida(Label lb_vida) {
        this.lb_vida = lb_vida;
    }

    public ProgressBar getProgreso() {
        return progreso;
    }

    public void setProgreso(ProgressBar progreso) {
        this.progreso = progreso;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
