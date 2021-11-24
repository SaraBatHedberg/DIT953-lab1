package car;

import java.awt.*;
import java.util.Stack;

/**
 * Class Carrier is a Type of car that can load other cars onto it.
 */
public class Carrier extends Car {

    private final TruckHelper helper = new TruckHelper();
    private boolean rampUp;

    private Stack<Car> loadedCars = new Stack<Car>();

    public Carrier(String plate){
        nrDoors = 2;
        color = Color.darkGray;
        enginePower = 200;
        modelName = "truck.Carrier";
        rampUp = true;
        this.plate = plate;
        stopEngine();

    }
    public Stack<Car> getLoadedCars() {
            return loadedCars;
        }

    public String getRampStatus() {
        if (rampUp) {
            return ("Ramp is currently up");
        } else {
            return ("Ramp is currently down");
        }
    }
    /**
     * Method calls the helper class Truck's implementation and sends necessary arguments.
     * @return Double with the value enginePower times the constant 0.004.
     */
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
        if ((carProximity(carToLoad)) && (carToLoad.getClass() != Carrier.class) && !rampUp) {
            loadedCars.push(carToLoad);
            carToLoad.setLoaded(true);
            System.out.println("Successfully loaded car");
        } else if (carToLoad.getClass() == Carrier.class){
            System.out.println("Cannot load a carrier onto a carrier");
        }
        else {
            System.out.println("Please drive closer before loading a car onto the carrier");
        }

    }

    /**
     * Method calls the super class's implementation of move to move the carrier and move any loaded cars.
     */
    @Override
    public void move(){
        super.move();
        if (loadedCars.size() > 0)
            for (Car car: loadedCars){
                car.setX(getX());
                car.setY(getY());
            }
    }

    /**
     * Method which unloads the most recent loaded car from the carrier. (last in first out)
     */
    public void unloadCar() {
        if ((!rampUp) && (loadedCars.size() != 0)){
            Car unloadedCar = loadedCars.pop();
            setUnloadedCarNewLocation(unloadedCar);
            unloadedCar.setLoaded(false);
            System.out.println("Successfully unloaded car");
        } else {
            System.out.println("Please lower the ramp before attempting to unload a car");
        }

    }

    /**
     * Method sets a new location to the newly unloaded car, based on the carrier's direction when unloading.
     * @param unloadedCar The parameter is a reference to the object of the unloaded car.
     */
    private void setUnloadedCarNewLocation(Car unloadedCar) {
        switch(getDirection()) {
            case UP -> {
                unloadedCar.setX(getX());
                unloadedCar.setY(getY() - 1);
            }
            case LEFT -> {
                unloadedCar.setX(getX() + 1);
                unloadedCar.setY(getY());
            }
            case RIGHT -> {
                unloadedCar.setX(getX() - 1);
                unloadedCar.setY(getY());
            }
            case DOWN -> {
                unloadedCar.setX(getX());
                unloadedCar.setY(getY() + 1);
            }
        }
    }
}



