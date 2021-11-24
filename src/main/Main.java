package main;

import car.*;

import static java.lang.System.*;

/**
 * A main class for running the code
 */
public class Main {
    /**
     * method to run the code
     * @param args neccesary to run the code
     */
    public static void main(String [] args) {
        Volvo240 volvo1 = new Volvo240("AAA111");
        Volvo240 volvo2 = new Volvo240("BBB222");
        Volvo240 volvo3 = new Volvo240("CCC333");
        Volvo240 volvo4 = new Volvo240("DDD444");
        Volvo240 volvo5 = new Volvo240("EEE555");
        Carrier errorbil = new Carrier("FFF666");
        Carrier flakbil = new Carrier("GGG777");

        flakbil.lowerRamp();
        flakbil.loadCar(volvo1);
        flakbil.loadCar(volvo2);
        flakbil.loadCar(volvo3);
        flakbil.loadCar(volvo4);
        flakbil.loadCar(volvo5);
        flakbil.loadCar(errorbil);
        flakbil.raiseRamp();
        flakbil.startEngine();
        for (int i = 0; i < 10; i++) {
            flakbil.gas(1);
            flakbil.move();
        }
        while (flakbil.getCurrentSpeed() != 0) {
            flakbil.brake(1);
            flakbil.move();
        }
        flakbil.lowerRamp();
        flakbil.unloadCar();
        flakbil.raiseRamp();
        for (int i = 0; i < 10; i++) {
            flakbil.gas(1);
            flakbil.move();
        }
        System.out.println(flakbil.getLoadedCars());
        System.out.println(flakbil.getX() + " " + flakbil.getY());
        System.out.println(volvo5.getX() + " " + volvo5.getY());
        System.out.println(volvo5.isLoaded());

        Workshop<Volvo240> Volvoverkstad = new Workshop<>(10, 10, 5, "Lilla volvoverkstaden");
        Workshop<Car> Storverkstad = new Workshop<>(-30, -30, 20, "Allmänna verkstaden");



        // System.out.println("Volvo's location: " + volvo1.getX() + " " + volvo1.getY());
        // System.out.println("Flakbil's location: " + flakbil.getX() + " " + flakbil.getY());



    }
}