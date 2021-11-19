package car;

import java.awt.*;


public class Scania extends Car {
    int angle;

    public Scania (){
        nrDoors = 2;
        color = Color.green;
        enginePower = 200;
        modelName = "truck.Scania";
        angle = 0;
        stopEngine();
    }

    public int getAngle() {
        return angle;
    }

    public void raisePlatform (int degree){
        if (currentSpeed == 0) {
            angle = Math.min(angle + degree, 70);
        }else {
            System.out.println("*pip sound* Please ensure truck is stationary before moving the platform");
        }
    }

    public void lowerPlatform (int degree){
        if (currentSpeed == 0) {
        angle = Math.max(angle - degree, 0);
        }else {
            System.out.println("*pip sound* Please ensure truck is stationary before moving the platform");
        }
    }

    @Override
    public void gas(double amount){
        if (angle == 0) {
            super.gas(amount);
        } else {
            System.out.println("Please ensure platform is lowered to 0 degrees before accelerating");
        }
    }

    /**
     * Method calls the super class's implementation in case the platform's position is valid.
     * Method prints an error message if the platform isn't on 0 degrees.
     */
    @Override
    public void move() {
        if (angle == 0) {
            super.move();
        } else {
            System.out.println("Please lower the platform before moving, then gas to gain speed");
        }
    }


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
