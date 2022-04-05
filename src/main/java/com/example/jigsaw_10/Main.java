package com.example.jigsaw_10;

import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  public static Stage windows;
  public long localSeconds;

  private static final int SIZE = 50;
  private static int XMAX = SIZE * 9;
  public static int YMAX = SIZE * 9;
  public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
  private Pane root;
  private Form object;
  private static Form nextObj = MainController.makeRect();
  private static FXMLLoader loader;
  private static MainController controller;
  public static Main m;
  Timeline time;
  KeyFrame frame;


  @Override
  public void start(Stage primaryStage) throws Exception {
    doTime();
    m = this;
    for (int[] a : MESH) {
      Arrays.fill(a, 0);
    }
    loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    root = loader.load();
    controller = loader.getController();
    controller.setAll(root, object);
    windows = primaryStage;

    Form a = nextObj;
    root.getChildren().addAll(a.a, a.b, a.c, a.d, a.e);
    object = a;
    nextObj = MainController.makeRect();

    Scene scene = new Scene(root, 600, 450, Color.BLACK);
    windows.setResizable(false);
    windows.setTitle("J I G S A W");
    windows.setScene(scene);
    windows.show();
  }

  public void stopGame() {
    time.stop();
  }

  private void doTime() {
    localSeconds = 1;
    time = new Timeline();
    frame = new KeyFrame(Duration.seconds(1), event -> {
      controller.setViewLabelFxText(
          "Time - " + localSeconds / 3600 + ":" + (localSeconds % 3600) / 60 + ":"
              + localSeconds % 60);
      ++localSeconds;
      if (localSeconds <= 0) {
        time.stop();
      }
    });
    time.setCycleCount(Timeline.INDEFINITE);
    time.getKeyFrames().add(frame);
    time.stop();
    time.play();
  }
}