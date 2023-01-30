package com.example.proyectobatalladelmarcoral.modelos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

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
    private final int posXMax = 1024;
    private final int posYMax = 764;
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
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double velX = velocidad/2;
            double velY = velocidad/2;
            int random;

            @Override
            public void handle(ActionEvent event) {

                imageView.setX(imageView.getX() + velX);
                imageView.setY(imageView.getY() + velY);

                if (imageView.getX() >= posXMax-90 || imageView.getX() <= 0){
                    velX = velX*(-1);
                    random = (int) (Math.random()*10+1);
                    System.out.println(random);

                }
                if (imageView.getY() >= posYMax-73 || imageView.getY() <= 0){

                    velY = velY*(-1);
                    random = (int) (Math.random()*10+1);
                    System.out.println(random);
                }

                if ((imageView.getX() >= posXMax-90 || imageView.getX() <= 0) && random==2){

                    velY = velY*(-1);

                }
                if ((imageView.getY() >= posYMax-73 || imageView.getY() <= 0) && random==2){

                    velX = velX*(-1);
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        if (vida== 0){
            timeline.stop();
        }
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
