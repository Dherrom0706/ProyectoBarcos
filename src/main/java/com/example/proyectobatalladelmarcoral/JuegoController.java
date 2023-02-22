package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import com.example.proyectobatalladelmarcoral.modelos.BarcoInterfaz;
import com.example.proyectobatalladelmarcoral.modelos.ControlDeJuego;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {
    @FXML
    public AnchorPane panel;
    ControlDeJuego control = new ControlDeJuego();
    @FXML
    private GridPane panel_rojo;
    @FXML
    public ProgressBar barra_acorazado_rojo;
    @FXML
    public ProgressBar barra_destructor_rojo;
    @FXML
    public ProgressBar barra_lancha_roja;
    @FXML
    public ProgressBar barra_submarino_rojo;
    @FXML
    public Label lb_vida_acorazado_rojo;
    @FXML
    public Label lb_vida_destructor_rojo;
    @FXML
    public Label lb_vida_lancha_rojo;
    @FXML
    public Label lb_vida_submarino_rojo;
    @FXML
    public ImageView reload_acorazado_rojo;
    @FXML
    public ImageView reload_destructor_rojo;
    @FXML
    public ImageView reload_lancha_rojo;
    @FXML
    public ImageView reload_submarino_rojo;
    @FXML
    public GridPane panel_azul;
    @FXML
    public ProgressBar barra_acorazado_azul;
    @FXML
    public ProgressBar barra_destructor_azul;
    @FXML
    public ProgressBar barra_lancha_lancha;
    @FXML
    public ProgressBar barra_submarino_submarino;
    @FXML
    public Label lb_vida_acorazado_azul;
    @FXML
    public Label lb_vida_destructor_azul;
    @FXML
    public Label lb_vida_lancha_azul;
    @FXML
    public Label lb_vida_submarino_azul;
    @FXML
    private ImageView reload_acorazado_azul;
    @FXML
    public ImageView reload_destructor_azul;
    @FXML
    public ImageView reload_lancha_azul;
    @FXML
    public ImageView reload_submarino_azul;
    @FXML
    private Pane panel_intermedio;
    @FXML
    private VBox fondo_oceano;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Barco barco1;
        Barco barco2;
        Barco barco3;
        Barco barco4;
        Barco barco5;
        Barco barco6;
        Barco barco7;
        Barco barco8;

        BarcoInterfaz barcoInterfaz1;
        BarcoInterfaz barcoInterfaz2;
        BarcoInterfaz barcoInterfaz3;
        BarcoInterfaz barcoInterfaz4;
        BarcoInterfaz barcoInterfaz5;
        BarcoInterfaz barcoInterfaz6;
        BarcoInterfaz barcoInterfaz7;
        BarcoInterfaz barcoInterfaz8;


        barco1 = new Barco(120,20,3,80,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado_rojo.png"))),"rojo","acorazado");
        barco3 = new Barco(120,20,3,80,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado_azul.png"))),"azul","acorazado");
        barco2 = new Barco(10,12,10,20,new ImageView(new Image(getClass().getResourceAsStream("images/lancha_roja.png"))),"rojo","lancha");
        barco4 = new Barco(10,12,10,20,new ImageView(new Image(getClass().getResourceAsStream("images/lancha_azul.png"))),"azul","lancha");
        barco5 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/destructor_rojo.png"))),"rojo","destructor");
        barco6 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/destructor_azul.png"))),"azul","destructor");
        barco7 = new Barco(30,15,2,60,new ImageView(new Image(getClass().getResourceAsStream("images/submarinos_rojo.png"))),"rojo","submarino");
        barco8 = new Barco(30,15,2,60,new ImageView(new Image(getClass().getResourceAsStream("images/submarino_azul.png"))),"azul","submarino");

        control.aniadir_barco(barco1, panel, 100, 40);
        control.aniadir_barco(barco2, panel, 100,100);
        control.aniadir_barco(barco3, panel, 850,200);
        control.aniadir_barco(barco4, panel, 850,100);
        control.aniadir_barco(barco5, panel, 100,300);
        control.aniadir_barco(barco6, panel, 850,300);
        control.aniadir_barco(barco7, panel, 100,400);
        control.aniadir_barco(barco8, panel, 850,400);

        control.comenzar_partida();

    }

}