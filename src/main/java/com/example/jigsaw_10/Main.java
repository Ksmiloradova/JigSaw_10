package com.example.jigsaw_10;

import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  MainController controller;
  Stage windows;
  public static long seconds = 0;

  public static final int SIZE = 50;
  public static int XMAX = SIZE * 9;
  public static int YMAX = SIZE * 9;
  public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
  public static Pane root;
  public static Form object;
  public static Form nextObj = MainController.makeRect();

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    root = loader.load();
    controller = loader.getController();
    windows = primaryStage;
    for (int[] a : MESH) {
      Arrays.fill(a, 0);
    }

    Form a = nextObj;
    root.getChildren().addAll(a.a, a.b, a.c, a.d, a.e);
    object = a;
    nextObj = MainController.makeRect();
    doTime();


    Scene scene = new Scene(root, 600, 450, Color.BLACK);
    windows.setResizable(false);
    windows.setTitle("J I G S A W");
    windows.setScene(scene);
    windows.show();
  }

  private void doTime() {
    Timeline time = new Timeline();
    KeyFrame frame = new KeyFrame(Duration.seconds(1), event -> {
      controller.setViewLabelFxText(
          "Time - " + seconds / 3600 + ":" + (seconds%3600) / 60 + ":" + seconds%60);
      ++seconds;
      if (seconds <= 0) {
        time.stop();
      }
    });
    time.setCycleCount(Timeline.INDEFINITE);
    time.getKeyFrames().add(frame);
    time.stop();
    time.play();
  }
}