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

    @Override
    double speedFactor() { return 0.004 * enginePower; }

    @Override
    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }


    @Override
    void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    @Override
    public void move() {
        if (angle == 0) {
            super.move();
        } else {
            System.out.println("Please lower the platform before moving, then gas to gain speed");
        }
    }
}
