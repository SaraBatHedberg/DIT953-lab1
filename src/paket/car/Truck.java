package paket.car;

public abstract class Truck extends Car{    /**

     * Method calculates the result of enginePower multiplied by the constant 0.004.
     * @return Double result of the EnginePower * 0.004.
     */
    @Override
    double speedFactor() { return 0.004 * enginePower; }

    /**
     * Method updates the instance variable current speed with a calculation that increases it.
     * Can't set current speed to a value higher than enginePower variable's value.
     * @param amount Double between interval [0,1].
     */
    @Override
    void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, enginePower);
    }

    /**
     * Method updates the instance variable current speed with a calculation that decreases it.
     * Can't set current speed to a value lower than Zero.
     * @param amount Double between interval [0,1].
     * @return currentSpeed Double representing the cars speed
     */
    @Override
    void decrementSpeed(double amount){
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount, 0);
    }
}

