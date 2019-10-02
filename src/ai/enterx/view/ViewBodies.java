package ai.enterx.view;

import ai.enterx.physics.Body;
import ai.enterx.physics.Simulation;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ViewBodies extends Canvas {

  private List<Body> bodies;
  private GraphicsContext gc = this.getGraphicsContext2D();
  private double rad = 10;

  public ViewBodies() {

  }

  public ViewBodies(Simulation simulation) {
    gc.setFill(Color.RED);
    setBodies(simulation.getBodies());
    setWidth(1000);
    setHeight(1000);

  }


  public void setBodies(List<Body> bodies) {
    this.bodies = bodies;
  }

  void draw() {

    gc.clearRect(0, 0, getWidth(), getHeight());
    bodies.forEach(body -> gc.fillOval(body.getXPosition(), body.getYPosition(), rad, rad));

  }

}
