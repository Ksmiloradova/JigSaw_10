package com.example.jigsaw_10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DialogController implements Initializable {

  @FXML
  private Label stepsLb;
  @FXML
  private Label timeLb;
  @FXML
  private Button restartBtn;

  @FXML
  private void onExit() {
    Platform.exit();
    System.exit(0);
  }

  @FXML
  private void onNewGame() {
    Stage stage = (Stage) restartBtn.getScene().getWindow();
    stage.close();
    try {
      Main.m.stopGame();
      Main.windows.close();
      new Main().start(new Stage());
    } catch (Exception e1) {
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    long seconds = Main.m.localSeconds;
    if (seconds>0) {
      --seconds;
    }
    stepsLb.setText("Steps - " + com.example.jigsaw_10.MainController.stepNumber);
    timeLb.setText(
        "Total time - " + seconds / 3600 + ":" + (seconds % 3600) / 60 + ":"
            + seconds % 60);
  }

}