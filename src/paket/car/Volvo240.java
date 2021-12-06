package paket.car;

import java.awt.*;


/**
 * Creates a class for a paket.car of the type Volvo240, that extends Car.
 */
public class Volvo240 extends Car{

    /**
     * A final double that represents how trimmed the paket.car is.
     */
    public final static double trimFactor = 1.25;


    /**
     * A constructor that contains the instance variables starting values for every Saab95.
     */
    public Volvo240(String plate){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        this.plate = plate;
        stopEngine();
    }

    /**
     * A method used to calculate the speedFactor of a Volvo240.
     * Used by incrementSpeed and decrementSpeed.
     * Calculations vary depending on the double trimFactor.
     * @return double SpeedFactor.
     */
    @Override
    double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}