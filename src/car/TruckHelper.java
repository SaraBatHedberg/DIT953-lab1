package car;

/**
 * Helper class for Carrier and Scania, containing the common code that is used to brake or gas the car
 */
public class TruckHelper {
    /**
     * Method calculates the result of enginePower multiplied by the constant 0.004.
     * @return Double result of the EnginePower * 0.004.
     */
    double speedFactor(double enginePower) { return 0.004 * enginePower; }

    /**
     * Method updates the instance variable current speed with a calculation that increases it.
     * Can't set current speed to a value higher than enginePower variable's value.
     * @param amount Double between interval [0,1].
     */

    double incrementSpeed(double amount, double currentSpeed, double enginePower) {
        return currentSpeed = Math.min(currentSpeed + speedFactor(enginePower) * amount, enginePower);
    }

    /**
     * Method updates the instance variable current speed with a calculation that decreases it.
     * Can't set current speed to a value lower than Zero.
     * @param amount Double between interval [0,1].
     * @return currentSpeed Double representing the cars speed
     */

    double decrementSpeed(double amount, double currentSpeed, double enginePower){
        return currentSpeed = Math.max(currentSpeed - speedFactor(enginePower) * amount, 0);
    }
}
