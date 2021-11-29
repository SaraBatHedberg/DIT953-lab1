package paket;

import paket.car.Car;

import java.util.ArrayList;

/**
 * A class for workshops, that currently can only receive cars or have cars retrieved from it.
 * @param <T> A parameter for which types of cars can be retrieved in the shop, which has to be paket. Car or a subtype to paket.car.
 */
public class Workshop <T extends Car> extends WorldObjects{

    /**
     * Maximum number of storable cars
     */
    private final int capacity;
    /**
     * Name of the workshop
     */
    private final String name;
    /**
     * List of currently stored cars
     */
    private ArrayList <T> listOfCars;
    /**
     * Helper instance to measure distance
     */
    private final ProximityChecker proxCheck = new ProximityChecker();

    public Workshop(int x, int y, int capacity, String name){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.name = name;
        this.listOfCars = new ArrayList<>(capacity);
    }

    /**
     * Method which deliver car to workshop
     * @param carToLoad
     */
    public void receiveCar(T carToLoad){
        if (listOfCars.size() == capacity){
            System.out.println("This workshop is currently full");
        } else if (!proxCheck.CheckProximity(this, carToLoad)){
            System.out.println("Please drive closer before attempting to enter the workshop");
        } else {
            listOfCars.add(carToLoad);
            carToLoad.setLoaded(true);
            System.out.println("Car received");
        }
    }

    /**
     * Repair method (only prints a message)
     */
    public void repair(T carToRepair) {
        System.out.println("Car " + carToRepair.getLicensePlate() + " repaired");
    }

    /**
     * Method which retrieve car from workshop
     * @param carToReceive
     */
    public void retrieveCar(T carToReceive){
        if (listOfCars.contains(carToReceive)){
            listOfCars.remove(carToReceive);
            carToReceive.setLoaded(false);
            System.out.println("Car (" + carToReceive.getLicensePlate() + ") retrieved");
        } else {
            System.out.println(carToReceive.getLicensePlate() + " is not in this workshop");
        }
    }
}
