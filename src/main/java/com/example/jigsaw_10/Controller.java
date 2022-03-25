package com.example.jigsaw_10;

import javafx.scene.shape.Rectangle;

public class Controller {

  // Getting the numbers and the MESH from Main
  public static final int MOVE = Main.SIZE;
  public static final int SIZE = Main.SIZE;
  public static int XMAX = Main.XMAX;
  public static int YMAX = Main.YMAX;
  public static int[][] MESH = Main.MESH;

//  public static void MoveRight(Form form) {
//    if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
//        && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
//      int movea = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
//      int moveb = MESH[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
//      int movec = MESH[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
//      int moved = MESH[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
//      if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
//        form.a.setX(form.a.getX() + MOVE);
//        form.b.setX(form.b.getX() + MOVE);
//        form.c.setX(form.c.getX() + MOVE);
//        form.d.setX(form.d.getX() + MOVE);
//      }
//    }
//  }
//
//  public static void MoveLeft(Form form) {
//    if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
//        && form.d.getX() - MOVE >= 0) {
//      int movea = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
//      int moveb = MESH[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
//      int movec = MESH[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
//      int moved = MESH[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
//      if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
//        form.a.setX(form.a.getX() - MOVE);
//        form.b.setX(form.b.getX() - MOVE);
//        form.c.setX(form.c.getX() - MOVE);
//        form.d.setX(form.d.getX() - MOVE);
//      }
//    }
//  }

  public static Form makeRect() {
    int block = (int) (Math.random() * 150);
    int orientation = (int) (Math.random() * 4);
    String name;
    Rectangle a = new Rectangle(SIZE - 1, SIZE - 1), b = new Rectangle(SIZE - 1,
        SIZE - 1), c = new Rectangle(SIZE - 1, SIZE - 1),
        d = new Rectangle(SIZE - 1, SIZE - 1), e = new Rectangle(SIZE - 1, SIZE - 1);
    if (block < 15) {
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
    } else if (block < 30) {
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
      a.setX(550);
      a.setY(50);
      setSame(a, b);
      setSame(a, c);
      setSame(a, d);
      setSame(a, e);
      name = "o";
    } else if (block < 60) {
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
    } else if (block < 90) {
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
    } else if (block < 105) {
      a.setX(500);
      a.setY(0);
      b.setX(500);
      b.setY(50);
      c.setX(500);
      c.setY(100);
      setSame(a, e);
      setSame(a, d);
      name = "i";
    } else if (block < 120) {
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
    return new Form(a, b, c, d, e, orientation, name);
  }

  private static void setSame(Rectangle a, Rectangle e) {
    e.setX(a.getX());
    e.setY(a.getY());
  }
}