package ai.enterx.physics;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Simulation implements Runnable {


  private List<Body> bodies;

  public Simulation(List<Body> bodies) {
    this.bodies = bodies;
  }

  @Override
  public void run() {

  }

  public void run(int times){
    for (int i = 0; i < times; i++) {
      simulation();
    }
  }

  public void step(){
    simulation();
  }

  private void simulation() {
    for (Body body : bodies) {
      updatePosition(body);
    }
    bodies.forEach(Body::updatePosition);
  }


  private void updatePosition(Body body) {
    Iterator<Body> looper = bodies.stream().filter(b -> !b.equals(body)).iterator();
    looper.forEachRemaining(body::step);
  }

  public List<Body> getBodies() {
    return Collections.unmodifiableList(bodies);
  }
}
