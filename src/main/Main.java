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
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        Volvo240 volvo5 = new Volvo240();
        Carrier errorbil = new Carrier();
        Carrier flakbil = new Carrier();
        Volvo240 testCar = new Volvo240();

        flakbil.loadCar(testCar);
        flakbil.startEngine();
        flakbil.gas(1);
        flakbil.gas(1);
        flakbil.gas(1);
        flakbil.move();
        System.out.println(flakbil.getX() + " " + flakbil.getY() + "    " + testCar.getX() + " " + testCar.getY());

        volvo2.startEngine();
        volvo2.move();
        volvo3.startEngine();
        volvo3.turnRight();
        volvo3.move();
        volvo4.startEngine();
        volvo4.turnRight();
        volvo4.turnRight();
        volvo4.move();
        volvo5.startEngine();
        volvo5.turnLeft();
        volvo5.move();

        flakbil.loadCar(volvo1);
        flakbil.loadCar(volvo2);
        flakbil.loadCar(volvo3);
        flakbil.loadCar(volvo4);
        flakbil.loadCar(volvo5);
        flakbil.loadCar(errorbil);




        // System.out.println("Volvo's location: " + volvo1.getX() + " " + volvo1.getY());
        // System.out.println("Flakbil's location: " + flakbil.getX() + " " + flakbil.getY());



    }
}