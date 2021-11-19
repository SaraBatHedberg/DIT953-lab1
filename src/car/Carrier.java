package car;

import java.awt.*;

/**
 * Class Carrier is a
 */
public class Carrier extends Car {

    private final TruckHelper helper = new TruckHelper();
    private boolean rampUp;
    private Stack<Car> loadedCars = new Stack<Car>();

    public Carrier(){
        nrDoors = 2;
        color = Color.darkGray;
        enginePower = 200;
        modelName = "truck.Carrier";
        rampUp = true;
        stopEngine();
    }
    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    void incrementSpeed(double amount) {}

    @Override
    void decrementSpeed(double amount) {}
}



/*

methods:
Load off
Load on



 */