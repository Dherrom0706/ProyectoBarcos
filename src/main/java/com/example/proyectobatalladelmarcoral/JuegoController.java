package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.barcos.Acorazado;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {
    @FXML
    public AnchorPane panel;
    public Acorazado acoradazo1;
    public Acorazado acoradazo2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panel.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("/images/fondo.jpg")),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        acoradazo1 = new Acorazado(1,10,10,panel);
        acoradazo2 = new Acorazado(1,10,300,panel);
        acoradazo1.start();
        acoradazo2.start();

        try {
            acoradazo1.join();
            acoradazo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}