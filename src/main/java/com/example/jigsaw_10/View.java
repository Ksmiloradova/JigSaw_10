package com.example.jigsaw_10;

import java.nio.Buffer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class View {
  @FXML
  private static Label label;
  @FXML
  private static Label steps;
  @FXML
  private static Label stepsLb;
  @FXML
  private static Label timeLb;

  public void setViewLabelFxText(String text){
    label.setText(text);
  }

  public void setViewStepsFxText(String text){
    steps.setText(text);
  }

  public static void setLabel(Label label) {
    View.label = label;
  }

  public static void setFinalTime(Label label) {
    View.timeLb = label;
  }
  public static void setFinalSteps(Label label) {
    View.stepsLb = label;
  }
  public static void setSteps(Label label) {
    View.label = label;
  }
  public void setViewFinalTimeFxText(String text){
    timeLb.setText(text);
  }
  public void setViewFinalStepsFxText(String text){
    stepsLb.setText(text);
  }

}
