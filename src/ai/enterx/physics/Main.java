package ai.enterx.physics;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Gson printer = new Gson().newBuilder().setPrettyPrinting().create();

        Simulation sim = new Simulation(Body.newTwoBody());
        System.out.println(printer.toJson(sim));
        sim.run(1);
        System.out.println(printer.toJson(sim));


    }
}
