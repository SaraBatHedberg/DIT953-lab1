package paket.car;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarController cc = new CarController();

        // Could create a factory instead
        cc.cars.add(new Volvo240("ABC123"));
        cc.cars.add(new Saab95("SAAAAAB"));
        cc.cars.add(new Scania("XXX999"));
        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", cc, model);

        cc.timer.start();
    }
}
