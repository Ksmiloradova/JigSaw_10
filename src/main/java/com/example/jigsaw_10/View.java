package com.example.jigsaw_10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class View {
  @FXML
  private static Label label;
  @FXML
  private static Label steps;

  public void setViewLabelFxText(String text){
    label.setText(text);
  }

  public void setViewStepsFxText(String text){
    steps.setText(text);
  }

  public static void setLabel(Label label) {
    View.label = label;
  }
  public static void setSteps(Label label) {
    View.label = label;
  }
}
