package com.example.proyectobatalladelmarcoral.modelos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barco extends Thread{

    private int vida;
    private int ataque;
    private int sonar;
    private int velocidad;
    private int equipo; //equipo 1 es rojo y equipo 2 es azul
    private int x;
    private int y;
    private String nombre;
    private Pane pane;
    public Barco(int vida, int ataque, int sonar, int velocidad, int equipo, int x, int y, String nombre, Pane pane) {
        this.vida = vida;
        this.ataque = ataque;
        this.sonar = sonar;
        this.velocidad = velocidad;
        this.equipo = equipo;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.pane = pane;
    }

    public void mover() {

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("/images/acorazado.png")));
        pane.getChildren().add(imageView);
        imageView.setLayoutY(VPos.TOP.ordinal());
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        double sceneWidth = pane.getWidth();
        double msgWidth = imageView.getLayoutBounds().getWidth();

        KeyValue initKeyValue = new KeyValue(imageView.translateXProperty(), sceneWidth);
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

        KeyValue endKeyValue = new KeyValue(imageView.translateXProperty(), -1.0
                * msgWidth);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);

        Timeline timeline = new Timeline(initFrame, endFrame);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
/*
* import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//from  w  ww . j ava2  s  .  c om
public class Main extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
    Text msg = new Text("java2s.com");
    msg.setTextOrigin(VPos.TOP);
    msg.setFont(Font.font(24));

    Pane root = new Pane(msg);
    root.setPrefSize(500, 70);
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.setTitle("Scrolling Text");
    stage.show();

    double sceneWidth = scene.getWidth();
    double msgWidth = msg.getLayoutBounds().getWidth();

    KeyValue initKeyValue = new KeyValue(msg.translateXProperty(), sceneWidth);
    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

    KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), -1.0
        * msgWidth);
    KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);

    Timeline timeline = new Timeline(initFrame, endFrame);

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }
}*/
}
