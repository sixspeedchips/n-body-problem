package ai.enterx.view;

import ai.enterx.physics.Body;
import ai.enterx.physics.Simulation;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Simulator extends Application {

  @Override
  public void start(Stage stage)  {


    stage.setTitle("n-body");

    Simulation simulation = new Simulation(Body.getNewBodies(10));
    ViewBodies vb = new ViewBodies(simulation);
    Runner runner = new Runner(simulation,vb);
    runner.start();

    stage.setScene(createScene(vb));


    stage.show();

  }

  private Scene createScene(Node...nodes){
    StackPane root = new StackPane();
    root.getChildren().addAll(nodes);
    return new Scene(root,500,500);
  }

}
