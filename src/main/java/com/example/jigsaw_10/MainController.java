package com.example.jigsaw_10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController extends View implements Initializable {

//  public static final int MOVE = Main.SIZE;
  public static final int SIZE = Main.SIZE;
  public static int XMAX = Main.XMAX;
  public static int YMAX = Main.YMAX;
  public static int[][] MESH = Main.MESH;

  @FXML
  private Label label;
  @FXML
  public static Label localLabel;

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
  }
}