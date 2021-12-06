package paket.car;

/**
 * Subclass of car and superclass of Carrier and Scania. Shares some similar methods
 */
public abstract class Truck extends Car{

    /**
     * Method calculates the result of enginePower multiplied by the constant 0.004.
     * @return Double result of the EnginePower * 0.004.
     */
    @Override
    double speedFactor() { return 0.004 * enginePower; }

}

