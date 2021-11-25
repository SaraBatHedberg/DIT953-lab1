package main;

import paket.car.*;
import paket.Workshop;

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

        Workshop<Volvo240> volvorepair = new Workshop<>(0, 0, 1, "Volvo");
        Volvo240 newvolvo = new Volvo240("ABC501");
        volvorepair.receiveCar(newvolvo);
        volvorepair.repair();
        volvorepair.retrieveCar("ABC501");

    }
}