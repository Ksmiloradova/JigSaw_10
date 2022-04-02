package com.example.jigsaw_10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DialogController implements Initializable {
  @FXML
  private Label stepsLb;
  @FXML
  private Label timeLb;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    stepsLb.setText("Steps - " + com.example.jigsaw_10.MainController.stepNumber);
    timeLb.setText(
        "Total time - " + com.example.jigsaw_10.Main.seconds / 3600 + ":" + (com.example.jigsaw_10.Main.seconds % 3600) / 60 + ":" + com.example.jigsaw_10.Main.seconds % 60);
  }
}