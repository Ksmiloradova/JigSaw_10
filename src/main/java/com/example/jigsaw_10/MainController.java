package com.example.jigsaw_10;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class MainController extends View implements Initializable {

  @FXML
  private Label label;
  @FXML
  public Label localLabel;
  @FXML
  private Button btn;

  @FXML
  private void click(ActionEvent event) {
    ((Button) (event.getSource())).setText("You've clicked!");
  }

  public void setViewLabelFxText(String text) {
    label.setText(text);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    localLabel = label;
    setLabel(label);
//    setViewLabelFxText("transfer of control in View \"labelFx\" variable");
    Platform.runLater(new Runnable() {

      @Override
      public void run() {
        while (!Thread.interrupted()) {
          try {
            Thread.sleep(1000);
            setViewLabelFxText("Time - " + new Date());
          } catch (InterruptedException e) {
            // ooops
          }
        }
      }
    });
//    (new Thread(() -> {
//      while (!Thread.interrupted()) {
//        try {
//          Thread.sleep(1000);
//          setViewLabelFxText("Time - " + new Date());
//        } catch (InterruptedException e) {
//          // ooops
//        }
//      }
//    })).start(); // the while thread will start in BG thread

//    (new Thread(() -> {
//      //Do some stuff in another thread
//      Platform.runLater(new Runnable() {
//        public void run() {
//          setViewLabelFxText("Time - " + ((new Date()).getTime() - date2.getTime()));
//        }
//      });
//    })).start();
  }
}