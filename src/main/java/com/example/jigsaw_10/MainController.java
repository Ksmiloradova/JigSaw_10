package com.example.jigsaw_10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

  @FXML
  private static Pane root;
  @FXML
  public static Label localLabel;
  @FXML
  private Label steps;
  @FXML
  public static Label localSteps;
  @FXML
  private Label label;

  @FXML
  private void openDialog() throws IOException {

    Parent root = FXMLLoader.load(getClass().getResource("DialogWindow.fxml"));

    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setScene(scene);

    stage.show();
  }

  private static final int SIZE = 50;
  public static int[][] MESH = Main.MESH;
  public static Form object;
  public static int stepNumber;

  public void setAll(Pane inputRoot, Form inputObject) {
    stepNumber = 0;
    root = inputRoot;
    object = inputObject;
  }

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
    String name;
    if (block < 20) {
      name = setKvadriFigure(a, b, c, d, e, 500, 0, 500, 50, 450, 500, "j");
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
      name = setKvadriFigure(a, b, c, d, e, 500, 50, 550, 50, 450, 500, "s");
    } else if (block < 75) {
      name = setKvadriFigure(a, b, c, d, e, 500, 50, 450, 100, 500, 550, "t");
    } else if (block < 85) {
      name = setKvadriFigure(a, b, c, d, e, 450, 50, 500, 50, 500, 550, "z");
    } else if (block < 95) {
      name = setTripleFigure(a, b, c, d, e, 500, 50, 100, "i");
    } else if (block < 115) {
      name = setTripleFigure(a, b, c, d, e, 450, 0, 50, "r");
    } else if (block < 135) {
      name = setSeptaFigure(a, b, c, d, e, 550, "L");
    } else {
      name = setSeptaFigure(a, b, c, d, e, 500, "T");
    }
    return name;
  }


  /**
   * Method sets coordinates for five blocks figure
   *
   * @param a first rectangle
   * @param b second rectangle
   * @param c third rectangle
   * @param d fourth rectangle
   * @param e fifth rectangle
   * @param i x coordinate
   * @param l figure name
   * @return name of settled figure
   */
  private static String setSeptaFigure(Rectangle a, Rectangle b, Rectangle c, Rectangle d,
      Rectangle e,
      int i, String l) {
    String name;
    a.setX(i);
    a.setY(0);
    b.setX(i);
    b.setY(50);
    c.setX(450);
    c.setY(100);
    d.setX(500);
    d.setY(100);
    e.setX(550);
    e.setY(100);
    name = l;
    return name;
  }

  private static String setTripleFigure(Rectangle a, Rectangle b, Rectangle c, Rectangle d,
      Rectangle e,
      int i, int i2, int i3, String i4) {
    String name;
    a.setX(i);
    a.setY(0);
    b.setX(500);
    b.setY(i2);
    c.setX(i);
    c.setY(i3);
    setSame(a, e);
    setSame(a, d);
    name = i4;
    return name;
  }

  private static String setKvadriFigure(Rectangle a, Rectangle b, Rectangle c, Rectangle d,
      Rectangle e,
      int i, int i2, int i3, int i4, int i5, int i6, String j) {
    String name;
    a.setX(i);
    a.setY(i2);
    b.setX(i3);
    b.setY(i4);
    c.setX(i5);
    c.setY(100);
    d.setX(i6);
    d.setY(100);
    setSame(a, e);
    name = j;
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
        try {
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
        } catch (Exception e) {
          for (int i = 0; i < figure.length; ++i) {
            figure[i].setTranslateX(0);
            figure[i].setTranslateY(0);
          }
        }
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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    localLabel = label;
    localSteps = steps;
  }
}