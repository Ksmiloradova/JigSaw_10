package com.example.jigsaw_10;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {

  Rectangle a;
  Rectangle b;
  Rectangle c;
  Rectangle d;
  Rectangle e;
  Color color = Color.BLUE;
  private String name;
  public int form = 1;

//  public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
//    this.a = a;
//    this.b = b;
//    this.c = c;
//    this.d = d;
//  }
//
//  public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
//    this.a = a;
//    this.b = b;
//    this.c = c;
//    this.d = d;
//    this.name = name;
//    color = Color.BLUE;
//    this.a.setFill(color);
//    this.b.setFill(color);
//    this.c.setFill(color);
//    this.d.setFill(color);
//  }

  public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, Rectangle e, int form) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.form = form*2+1;
  }

  public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, Rectangle e, int form,
      String name) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.name = name;
    color = Color.BLUE;
    this.a.setFill(color);
    this.b.setFill(color);
    this.c.setFill(color);
    this.d.setFill(color);
    this.e.setFill(color);
    this.form = form*2+1;
    while (--(this.form) > 0) {
      orient();
    }
    this.form = form;
  }

  private void orient() {
    helpOrient(a);
    helpOrient(b);
    helpOrient(c);
    helpOrient(d);
    helpOrient(e);
  }

  private void helpOrient(Rectangle a) {
    double ax = a.getX(), ay = a.getY();
    // Central block.
    if (ax == 500 && ay == 50) {
      return;
    }
    if (ay == 0 && ax < 550) {
      a.setX(ax + 50);
    } else if (ax == 550 && ay < 100) {
      a.setY(ay + 50);
    } else if (ay == 100 && ax > 450) {
      a.setX(ax - 50);
    } else {
      a.setY(ay - 50);
    }
  }

  public String getName() {
    return name;
  }

}
