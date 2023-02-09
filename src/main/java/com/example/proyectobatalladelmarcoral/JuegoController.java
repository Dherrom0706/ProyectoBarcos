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
        Destructor destructor3 = null;
        Destructor destructor4 = null;
        try {
            destructor1 = new Destructor();
            destructor2 = new Destructor();
            destructor3 = new Destructor();
            destructor4 = new Destructor();
            destructor1.setEquipo("Rojo");
            destructor4.setEquipo("Rojo");
            destructor2.setEquipo("Azul");
            destructor3.setEquipo("Azul");

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        control.aniadir_barco(destructor1, panel, 100, 40);
        control.aniadir_barco(destructor2, panel, 900,100);
        control.aniadir_barco(destructor3, panel, 900,200);
        control.aniadir_barco(destructor4, panel, 10,100);

        control.mover(destructor1);
        control.mover(destructor2);
        control.mover(destructor3);
        control.mover(destructor4);

    }
}