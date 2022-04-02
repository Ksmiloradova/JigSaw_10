package com.example.jigsaw_10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class View {

  @FXML
  private static Label label;

  public void setViewLabelFxText(String text) {
    label.setText(text);
  }

}
