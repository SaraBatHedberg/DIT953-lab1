package paket;

import paket.car.Car;

import java.util.ArrayList;

/**
 * A class for workshops, that currently can only receive cars or have cars retrieved from it.
 * @param <T> A parameter for which types of cars can be retrieved in the shop, which has to be paket. Car or a subtype to paket.car.
 */
public class Workshop <T extends Car> extends WorldObjects{

    /**
     * a variable for the workshop's x-coordinate.
     */
    private final int x;
    /**
     * a variable for the workshops y-coordinate.
     */
    private final int y;
    private final int capacity;
    private final String name;
    private ArrayList <String> listOfCars;
    private final ProximityChecker proxCheck = new ProximityChecker();

    public Workshop(int x, int y, int capacity, String name){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.name = name;
        this.listOfCars = new ArrayList<>(capacity);
    }

    public void receiveCar(T carToLoad){
        if (listOfCars.size() < capacity && proxCheck.CheckProximity(this,carToLoad)) {
            listOfCars.add(carToLoad.getLicensePlate());
            System.out.println("Car received");
        } else if (listOfCars.size() == capacity){
                System.out.println("This workshop is currently full");
        } else {
            System.out.println("Please drive closer before attempting to enter the workshop");
        }
    }

    public void repair() {
        System.out.println("Car repaired");
    }

    public void retrieveCar(String plate){
        if (listOfCars.contains(plate)){
            listOfCars.remove(plate);
            System.out.println("Car (" + plate + ") retrieved");
        } else {
            System.out.println(plate + " is not in this workshop");
        }
    }



    ////////////////////// GETTERS ///////////////////////

}
