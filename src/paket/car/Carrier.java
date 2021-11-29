package paket.car;

import paket.ProximityChecker;

import java.awt.*;
import java.util.Stack;

/**
 * Class Carrier is a Type of car that can load other cars onto it.
 */
public class Carrier extends Truck {
    /**
     * Helper instance to measure distance
     */
    private final ProximityChecker proxCheck = new ProximityChecker();
    /**
     * Ramp status
     */
    private boolean rampUp;
    /**
     * Maximum number of cars
     */
    private final int capacity;

    private Stack<Car> loadedCars = new Stack<Car>();

    public Carrier(String plate){
        nrDoors = 2;
        color = Color.darkGray;
        enginePower = 200;
        modelName = "truck.Carrier";
        rampUp = true;
        capacity = 4;
        this.plate = plate;
        stopEngine();

    }

    /**
     * Getter for loaded cars
     * @return Stack
     */
    public Stack<Car> getLoadedCars() {
            return loadedCars;
        }

    /**
     * Getter for ramp's current status
     * @return String
     */
    public String getRampStatus() {
        if (rampUp) {
            return ("Ramp is currently up");
        } else {
            return ("Ramp is currently down");
        }
    }

    /**
     * Method lowers the ramp by making the rampUp boolean False.
     * Method prints an error message if the carrier isn't stationary when calling.
     */
    public void raiseRamp (){
        if (currentSpeed == 0) {
            rampUp = true;
        }else {
            System.out.println("*pip sound* Please ensure carrier is stationary before raising the ramp");
        }
    }

    /**
     * Method lowers the ramp by making the rampUp boolean False.
     * Method prints an error message if the carrier isn't stationary when calling.
     */
    public void lowerRamp (){
        if (currentSpeed == 0) {
            rampUp = false;
        }else {
            System.out.println("*pip sound* Please ensure carrier is stationary before lowering the ramp");
        }
    }

    /**
     * Method to check if car is close enough to be loaded onto carrier
     * @param carToCheck Car (which distance to the carrier will be calculated)
     * @return boolean (false if not close enough)
     */
    private boolean carProximity (Car carToCheck) {
        return (proxCheck.CheckProximity(carToCheck,this));
    }

    /**
     * Method loads a car to the carrier if carProximity is true and the loaded vehicle has the type Car.
     * @param carToLoad The parameter has the type Car.
     */
    public void loadCar(Car carToLoad) {
        if (rampUp) {System.out.println("Please lower the ramp before attempting to load a paket.car");}
        else if (carToLoad.getClass() == Carrier.class){System.out.println("Cannot load a carrier onto a carrier");}
        else if (!carProximity(carToLoad)) {System.out.println("Please drive closer before loading a paket.car onto the carrier");}
        else if (loadedCars.size() == capacity) {System.out.println("The carrier is currently full and cannot load another car");}
        else {
            loadedCars.push(carToLoad);
            carToLoad.setLoaded(true);
            System.out.println("Successfully loaded paket.car");}
    }

    /**
     * Method calls the super class's implementation of move to move the carrier and move any loaded cars.
     */
    @Override
    public void move(){
        super.move();
        if (loadedCars.size() > 0)
            for (Car car: loadedCars){
                car.setLocation(getLocation()[0], getLocation()[1]);
            }
    }

    /**
     * Method which unloads the most recent loaded car from the carrier. (last in first out)
     */
    public void unloadCar() {
        if (loadedCars.size() == 0) {
            System.out.println("Cannot unload a car when the carrier is empty");
        } else if (rampUp){
            System.out.println("Please lower the ramp before attempting to unload a car");
        } else {
            Car unloadedCar = loadedCars.pop();
            setUnloadedCarNewLocation(unloadedCar);
            unloadedCar.setLoaded(false);
            System.out.println("Successfully unloaded car");        
        }
    }

    /**
     * Method sets a new location to the newly unloaded car, based on the carrier's direction when unloading.
     * @param unloadedCar The parameter is a reference to the object of the unloaded car.
     */
    private void setUnloadedCarNewLocation(Car unloadedCar) {
        switch(getDirection()) {
            case UP -> unloadedCar.setLocation(getLocation()[0], getLocation()[1] - 1);
            case LEFT -> unloadedCar.setLocation(getLocation()[0] + 1, getLocation()[1]);
            case RIGHT -> unloadedCar.setLocation(getLocation()[0] - 1, getLocation()[1]);
            case DOWN -> unloadedCar.setLocation(getLocation()[0], getLocation()[1] + 1);
        }
    }
}



