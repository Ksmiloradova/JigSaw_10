package com.example.jigsaw_10;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  MainController controller;
  Stage windows;
  private final long starttime = 0;
  private long seconds = starttime;

  public static final int SIZE = 50;
  public static int XMAX = SIZE * 9;
  public static int YMAX = SIZE * 9;
  public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
  private static Pane group = new Pane();
  private static Form object;
  private static Form nextObj = Controller.makeRect();
  private static Scene scene = new Scene(group, XMAX + 150, YMAX);

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    Pane root = loader.load();
    controller = loader.getController();
    windows = primaryStage;
    for (int[] a : MESH) {
      Arrays.fill(a, 0);
    }

    Form a = nextObj;
    root.getChildren().addAll(a.a, a.b, a.c, a.d, a.e);
    object = a;
    nextObj = Controller.makeRect();
    doTime();

    Scene scene = new Scene(root, 600, 450, Color.BLACK);
    windows.setResizable(false);
    windows.setTitle("J I G S A W");
    windows.setScene(scene);
    windows.show();
  }
  private void moveOnKeyPress(Form form) {
//    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//      @Override
//      public void handle(KeyEvent event) {
//        switch (event.getCode()) {
//          case RIGHT:
//            Controller.MoveRight(form);
//            break;
//          case DOWN:
//            MoveDown(form);
//            score++;
//            break;
//          case LEFT:
//            Controller.MoveLeft(form);
//            break;
//          case UP:
//            MoveTurn(form);
//            break;
//        }
//      }
//    });
  }
  private void doTime() {
    Timeline time = new Timeline();
    KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.setViewLabelFxText("Time - " + seconds/3600 + ":" + seconds/60 + ":" + seconds);
        ++seconds;
        if (seconds <= 0) {
          time.stop();
        }
      }
    });
    time.setCycleCount(Timeline.INDEFINITE);
    time.getKeyFrames().add(frame);
    if (time != null) {
      time.stop();
    }
    time.play();
  }
}