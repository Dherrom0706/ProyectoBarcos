package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import com.example.proyectobatalladelmarcoral.modelos.ControlDeJuego;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        panel.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("images/fondo.jpg")),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Barco barco1;
        Barco barco2;
        Barco barco3;
        Barco barco4;


        barco1 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado.png"))),"rojo");
        barco2 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado.png"))),"rojo");
        barco3 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado.png"))),"azul");
        barco4 = new Barco(80,15,5,50,new ImageView(new Image(getClass().getResourceAsStream("images/acorazado.png"))),"azul");

        control.aniadir_barco(barco1, panel, 100, 40);
        control.aniadir_barco(barco2, panel, 100,100);
        control.aniadir_barco(barco3, panel, 900,200);
        control.aniadir_barco(barco4, panel, 900,100);

        control.mover(barco1);
        control.mover(barco2);
        control.mover(barco3);
        control.mover(barco4);





    }
}