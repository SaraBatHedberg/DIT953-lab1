package main;

import car.Car;
import car.Saab95;
import car.Scania;
import car.Volvo240;

import static java.lang.System.*;

public class Main {
    public static void main(String [] args) {
        Car MyCar = new Volvo240();
        //out.println(MyCar.getColor());

        MyCar.startEngine();
        //out.println(MyCar.getCurrentSpeed());
        for (int i = 0; i < 100; i++) {
            MyCar.gas(1);
        }
        MyCar.move();
        //out.println(MyCar.getX()+" "+MyCar.getY());



        Scania Truck = new Scania();
        Truck.startEngine();
        Truck.brake(1);
        out.println(Truck.getCurrentSpeed());
        Truck.raisePlatform(45);
        out.println(Truck.getAngle());
        Truck.gas(1);
        Truck.move();
        out.println(Truck.getAngle() + " + " + Truck.getY());
        Truck.lowerPlatform(45);
        Truck.move();
        out.println(Truck.getAngle() + " + " + Truck.getY());
        Truck.raisePlatform(1);
    }
}