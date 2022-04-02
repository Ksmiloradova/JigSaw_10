package com.example.jigsaw_10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController extends View implements Initializable {

  @FXML
  private static Pane root = Main.root;
  @FXML
  private Label label;
  @FXML
  public static Label localLabel;
  @FXML
  private Label steps;
  @FXML
  public static Label localSteps;
  @FXML
  private Button btn;
  @FXML
  private void openDialog() throws IOException {

    Parent root = FXMLLoader.load(getClass().getResource("DialogWindow.fxml"));

    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setScene(scene);

    stage.show();
//    FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
//    DialogController controller = new DialogController();
////    controller.setLabels(stepNumber, Main.seconds);
//    loader.setController(controller);
//    final Parent root1 = FXMLLoader.load(getClass().getResource("DialogWindow.fxml"));
//    final Scene scene1 = new Scene(root1);
//    stage.initModality(Modality.APPLICATION_MODAL);
//    stage.initStyle(StageStyle.UNDECORATED);
//    stage.initOwner(btn.getScene().getWindow());
//    stage.setScene(scene1);
//    stage.show();
  }


  public static final int SIZE = Main.SIZE;
  public static int XMAX = Main.XMAX;
  public static int YMAX = Main.YMAX;
  public static int[][] MESH = Main.MESH;
  public static Form object = Main.object;
  public static int stepNumber = 0;


  public static Form makeRect() {
    int block = (int) (Math.random() * 155);
    int orientation = (int) (Math.random() * 4);
    String name;
    Rectangle a = new Rectangle(SIZE - 2, SIZE - 2), b = new Rectangle(SIZE - 2,
        SIZE - 2), c = new Rectangle(SIZE - 2, SIZE - 2),
        d = new Rectangle(SIZE - 2, SIZE - 2), e = new Rectangle(SIZE - 2, SIZE - 2);
    double ax = 0, ay = 0, bx = 0, by = 0, cx = 0, cy = 0, dx = 0, dy = 0, ex = 0, ey = 0;
    Rectangle[] figure = {a, b, c, d, e};
    double[] xCord = {ax, bx, cx, dx, ex};
    double[] yCord = {ay, by, cy, dy, ey};
    double[] startX = new double[6];
    double[] startY = new double[6];

    name = generateFigure(block, a, b, c, d, e);
    setHandles(a, figure, xCord, yCord, startX, startY);
    setHandles(b, figure, xCord, yCord, startX, startY);
    setHandles(c, figure, xCord, yCord, startX, startY);
    setHandles(d, figure, xCord, yCord, startX, startY);
    setHandles(e, figure, xCord, yCord, startX, startY);
    return new Form(a, b, c, d, e, orientation, name);
  }

  private static String generateFigure(int block, Rectangle a, Rectangle b, Rectangle c,
      Rectangle d,
      Rectangle e) {
    root = Main.root;
    String name;
    if (block < 20) {
      a.setX(500);
      a.setY(0);
      b.setX(500);
      b.setY(50);
      c.setX(450);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      setSame(a, e);
      name = "j";
    } else if (block < 40) {
      a.setX(500);
      a.setY(0);
      b.setX(500);
      b.setY(50);
      c.setX(450);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      b.setX(500);
      b.setY(50);
      c.setX(550);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      setSame(a, e);
      name = "l";
    } else if (block < 45) {
      a.setX(500);
      a.setY(50);
      setSame(a, b);
      setSame(a, c);
      setSame(a, d);
      setSame(a, e);
      name = "o";
    } else if (block < 55) {
      a.setX(500);
      a.setY(50);
      b.setX(550);
      b.setY(50);
      c.setX(450);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      setSame(a, e);
      name = "s";
    } else if (block < 75) {
      a.setX(500);
      a.setY(50);
      b.setX(450);
      b.setY(100);
      c.setX(500);
      c.setY(100);
      d.setX(550);
      d.setY(100);
      setSame(a, e);
      name = "t";
    } else if (block < 85) {
      a.setX(450);
      a.setY(50);
      b.setX(500);
      b.setY(50);
      c.setX(500);
      c.setY(100);
      d.setX(550);
      d.setY(100);
      setSame(a, e);
      name = "z";
    } else if (block < 95) {
      a.setX(500);
      a.setY(0);
      b.setX(500);
      b.setY(50);
      c.setX(500);
      c.setY(100);
      setSame(a, e);
      setSame(a, d);
      name = "i";
    } else if (block < 115) {
      a.setX(450);
      a.setY(0);
      b.setX(500);
      b.setY(0);
      c.setX(450);
      c.setY(50);
      setSame(a, e);
      setSame(a, d);
      name = "r";
    } else if (block < 135) {
      a.setX(550);
      a.setY(0);
      b.setX(550);
      b.setY(50);
      c.setX(450);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      e.setX(550);
      e.setY(100);
      name = "L";
    } else {
      a.setX(500);
      a.setY(0);
      b.setX(500);
      b.setY(50);
      c.setX(450);
      c.setY(100);
      d.setX(500);
      d.setY(100);
      e.setX(550);
      e.setY(100);
      name = "T";
    }
    return name;
  }

  private static void setHandles(Rectangle b, Rectangle[] figure, double[] xCord, double[] yCord,
      double[] startX, double[] startY) {
    b.setOnMousePressed(event -> {
      startX[5] = b.getX();
      startY[5] = b.getY();
      for (int i = 0; i < figure.length; ++i) {
        xCord[i] = figure[i].getTranslateX() - event.getSceneX();
        yCord[i] = figure[i].getTranslateY() - event.getSceneY();
        startX[i] = figure[i].getX();
        startY[i] = figure[i].getY();
      }
    });
    b.setOnMouseDragged(event -> {
      for (int i = 0; i < figure.length; ++i) {
        figure[i].setTranslateX(xCord[i] + event.getSceneX());
        figure[i].setTranslateY(yCord[i] + event.getSceneY());
      }
    });
    b.setOnMouseReleased(event -> {
      boolean isCorrect =
          !(event.getSceneX() < 0) && !(event.getSceneY() < 0) && !(event.getSceneX() > 450)
              && !(event.getSceneY() > 450);
      for (int i = 0; i < figure.length; ++i) {
        if (getMeshFirst(event.getSceneY() + startY[i] - startY[5]) < 0
            || getMeshSecond(event.getSceneX() + startX[i] - startX[5]) < 0 ||
            MESH[getMeshFirst(event.getSceneY() + startY[i] - startY[5])][getMeshSecond(
                event.getSceneX() + startX[i] - startX[5])] == 1) {
          isCorrect = false;
          break;
        }
      }
      if (isCorrect) {
        for (int i = 0; i < figure.length; ++i) {
          MESH[getMeshFirst(event.getSceneY() + startY[i] - startY[5])][getMeshSecond(
              event.getSceneX() + startX[i] - startX[5])] = 1;
          figure[i].setTranslateX(50 * getMeshSecond(event.getSceneX()) - startX[5]);
          figure[i].setTranslateY(50 * getMeshFirst(event.getSceneY()) - startY[5]);
          figure[i].setOnMousePressed(null);
          figure[i].setOnMouseDragged(null);
          figure[i].setOnMouseReleased(null);
        }
        MainController.localSteps.setText("Steps - " + (++stepNumber));
        Form form = makeRect();
        root.getChildren().addAll(form.a, form.b, form.c, form.d, form.e);
        object = form;
      } else {
        for (int i = 0; i < figure.length; ++i) {
          figure[i].setTranslateX(0);
          figure[i].setTranslateY(0);
        }
      }
    });
  }

  private static int getMeshFirst(double y) {
    if (y < 0 || y > 450) {
      return -1;
    }
    return (int) (y / 50);
  }

  private static int getMeshSecond(double x) {
    if (x < 0 || x > 450) {
      return -1;
    }
    return (int) (x / 50);
  }

  private static void setSame(Rectangle a, Rectangle e) {
    e.setX(a.getX());
    e.setY(a.getY());
  }
  public void setViewLabelFxText(String text) {
    label.setText(text);
  }

  public void setViewStepsFxText(String text) {
    steps.setText(text);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    localLabel = label;
    setLabel(label);
    localSteps = steps;
    setSteps(steps);
  }
}