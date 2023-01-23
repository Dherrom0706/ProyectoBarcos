package com.example.proyectobatalladelmarcoral;

import com.example.proyectobatalladelmarcoral.modelos.Barco;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JuegoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JuegoApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024 , 764);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}