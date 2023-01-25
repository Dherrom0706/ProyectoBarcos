package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {


    @FXML
    public Pane panel;

    public Barco barco ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panel.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/fondo.jpg")),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        barco = new Barco(10,10,10,5,1,10,10,"Acorazado",panel);
        barco.mover();
    }
}