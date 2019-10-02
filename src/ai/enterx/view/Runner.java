package ai.enterx.view;

import ai.enterx.physics.Simulation;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;

public class Runner extends AnimationTimer {

  private long startTime;
  private long last;
  private Simulation simulation;
  private ViewBodies viewBodies;

  public Runner(Simulation simulation, ViewBodies viewBodies) {
    this.simulation = simulation;
    this.viewBodies = viewBodies;
  }

  @Override
  public void start() {
    super.start();
    last = System.currentTimeMillis();
  }

  @Override
  public void handle(long l) {
    long uTime = TimeUnit.MILLISECONDS.convert((l-last),TimeUnit.NANOSECONDS);

    if(uTime>30){
      simulation.step();
      viewBodies.draw();
      last = l;
    }
  }
}
