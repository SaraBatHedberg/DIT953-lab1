package paket.car;

import java.awt.*;


/**
 * This class is an extension (subclass) of the class Car.
 * Objects created in this class will have the type Scania.
 */
public class Scania extends Car {
    int angle;
    private final TruckHelper helper = new TruckHelper();
    /**
     * A constructor that contains the instance variables starting values for every Scania.
     */
    public Scania(String plate){
        nrDoors = 2;
        color = Color.green;
        enginePower = 200;
        modelName = "truck.Scania";
        angle = 0;
        this.plate = plate;
        stopEngine();
    }

    /**
     * A getter method for the angle of the platform.
     * @return Method returns an integer angle for the current position of the platform.
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Method raises the platform with a certain amount of degrees.
     * Method prints an error message if the truck isn't stationary when calling.
     * @param degree Integer for platform's movement in degrees. Interval (0-70).
     */
    public void raisePlatform (int degree){
            if (currentSpeed == 0) {
            angle = Math.min(angle + degree, 70);
            } else {
                System.out.println("*pip sound* Please ensure truck is stationary before moving the platform");
        }}



    /**
     * Method lowers the platform with a certain amount of degrees.
     * Method prints an error message if the truck isn't stationary when calling.
     * @param degree Integer for platform's movement in degrees. Interval (0-70).
     */
    public void lowerPlatform (int degree){
            if (currentSpeed == 0) {
            angle = Math.max(angle - degree, 0);
            } else {
                System.out.println("*pip sound* Please ensure truck is stationary before moving the platform");
    }}

    /**
     * Method calls superclass's original implementation in case the platform's position is valid.
     * Method prints an error message if the platform isn't on 0 degrees.
     * @param amount Double between interval [0,1].
     */
    @Override
    public void gas(double amount){
        if (angle == 0 && engineOn) {
            super.gas(amount);
        } else {
            System.out.println("Please ensure platform is lowered and the engine turned on before accelerating");
        }
    }

    /**
     * Method calls the super class's implementation in case the platform's position is valid.
     * Method prints an error message if the platform isn't on 0 degrees.
     */
    @Override
    public void move() {
        if (angle == 0 && engineOn) {
            super.move();
        } else {
            System.out.println("Please ensure the platform is lowered and the engine turned on, then gas to gain speed");
        }
    }
    /**
     * Method calls the helper class Truck's implementation and sends necessary arguments.
     * @return Double with the value enginePower times the constant 0.004.
     */
    @Override
    double speedFactor() { return helper.speedFactor(enginePower); }
    /**
     * Method calls the helper class Truck's implementation and sends necessary arguments.
     * @param amount Double in the interval [0, 1]
     */
    @Override
    void incrementSpeed(double amount) { currentSpeed = helper.incrementSpeed(amount, currentSpeed, enginePower); }

    /**
     * Method calls the helper class Truck's implementation and sends necessary arguments.
     * @param amount Double in the interval [0, 1]
     */
    @Override
    void decrementSpeed(double amount) { currentSpeed = helper.decrementSpeed(amount, currentSpeed, enginePower); }
//    /**
//     * Method calculates the result of enginePower multiplied by the constant 0.004.
//     * @return Double result of the EnginePower * 0.004.
//     */
//    @Override
//    double speedFactor() { return 0.004 * enginePower; }
//
//    /**
//     * Method updates the instance variable current speed with a calculation that increases it.
//     * Can't set current speed to a value higher than enginePower variable's value.
//     * @param amount Double between interval [0,1].
//     */
//    @Override
//    void incrementSpeed(double amount) {
//        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
//        }
//
//    /**
//     * Method updates the instance variable current speed with a calculation that decreases it.
//     * Can't set current speed to a value lower than Zero.
//     * @param amount Double between interval [0,1].
//     */
//    @Override
//    void decrementSpeed(double amount){
//        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
//    }
}
