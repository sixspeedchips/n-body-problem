package ai.enterx.cmath;

public class Distance {

  public static double euclidean(Simulateable one, Simulateable two) {
    return Math.sqrt(Math.pow(one.getXPosition() - two.getYPosition(), 2) +
        Math.pow(one.getYPosition() - two.getYPosition(), 2));
  }
}
