package paket.car;

import java.awt.*;

/**
 * Creates a class for a paket.car of the type Saab95, that extends Car.
 */
public class Saab95 extends Car {

    /**
     * A boolean that can be turned on or off for wether the Saab95s engine is on.
     */
    public boolean turboOn;

    /**
     * A constructor that contains the instance variables starting values for every Saab95.
     */
    public Saab95(String plate) {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        this.plate = plate;
        stopEngine();
    }


    /**
     * Turns on the Boolean turboOn ( Sets it to true).
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turns off the Boolean turboOn ( Sets it to false).
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * A method used to calculate the speedFactor of a Saab95,
     * Used by incrementSpeed and decrementSpeed.
     * Calculations vary depending on the boolean turboOn.
     *
     * @return double SpeedFactor.
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}


