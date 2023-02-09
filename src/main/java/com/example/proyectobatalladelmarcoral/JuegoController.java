package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.ControlDeJuego;
import com.example.proyectobatalladelmarcoral.modelos.barcos.Acorazado;
import com.example.proyectobatalladelmarcoral.modelos.barcos.Destructor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
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
        Destructor destructor1 = null;
        Destructor destructor2 = null;
        try {
            destructor1 = new Destructor();
            destructor2 = new Destructor();
            destructor1.setEquipo("Rojo");
            destructor2.setEquipo("Azul");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        control.aniadir_barco(destructor1, panel, 10, 20);
        control.aniadir_barco(destructor2, panel, 100,200);

        control.mover(destructor1);
        control.mover(destructor2);

    }
}