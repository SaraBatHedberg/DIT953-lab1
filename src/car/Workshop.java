package car;

import java.awt.*;
import java.util.ArrayList;

/**
 * A class for workshops, that currently can only recieve cars or have cars retrieved from it.
 * @param <T> A parameter for which types of cars can be retrieved in the shop, which has to be car or a subtype to car.
 */
public class Workshop <T extends Car> implements ICoordinates{

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
        } else if (listOfCars.size() == capacity){                              //////// CONTINUE
            {
                System.out.println("This workshop is currently full");
            }
        }
    }

    public void repair() {
        System.out.println("Car repaired");
    }

    public void retrieveCar(String plate){
        if (listOfCars.contains(plate)){
            listOfCars.remove(plate);
        } else {
            System.out.println(plate + " is not in this workshop");
        }
    }



    ////////////////////// GETTERS ///////////////////////
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

}
