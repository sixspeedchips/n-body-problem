package ai.enterx.physics;

import ai.enterx.cmath.Simulateable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Body implements Simulateable {

  static final Random rng = new Random();
  static final double G = .001;

  private double xPos;
  private double yPos;

  private double xVect ;
  private double yVect;

  private double xVectNext;
  private double yVectNext;

  public Body() {
  }

  public Body(double x, double y, double xVect, double yVect) {
    this.xPos = x;
    this.yPos = y;
    this.xVect = xVect;
    this.yVect = yVect;
  }

  public Body(double x, double y) {
    this.xPos = x;
    this.yPos = y;
  }

  void updatePosition(){
    yVect = yVectNext;
    xVect = xVectNext;
    xPos += xVectNext;
    yPos += yVectNext;
    System.out.println(xPos+":"+yPos);
  }


  public void step(Body other) {
    double xDiff = xPos - other.getXPosition();
    double yDiff = yPos - other.getYPosition();
    xVectNext = xVect -  G * xDiff;
    yVectNext = yVect -  G * yDiff;

  }


  @Override
  public double getXPosition() {
    return xPos;
  }

  @Override
  public double getYPosition() {
    return yPos;
  }


  public static List<Body> getNewBodies(int n){
    List<Body> bodies = new ArrayList<>();
    IntStream.range(0,n).forEach(i->bodies.add(new Body(rnd(400,600),rnd(400,600),rnd(.01,.5),rnd(.001,.005))));
    return bodies;
  }

  public static List<Body> newTwoBody(){
    List<Body> bodies = new ArrayList<>();
    bodies.add(new Body(rnd(0,500),100,rng.nextDouble()*.010-.005,rng.nextDouble()*.010-.005));
    bodies.add(new Body(450,200,rng.nextDouble()*.01-.005,rng.nextDouble()*.010-.005));
    return bodies;
  }

  static double rnd(double d, double u){
    return rng.nextDouble()* u - (u - d)/100;
  }

}
