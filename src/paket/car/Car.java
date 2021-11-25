package paket.car;

import paket.Directions;
import paket.IMovable;
import paket.WorldObjects;

import java.awt.*;

/**
 * this class creates a new object of the type Car.
 */
public abstract class Car extends WorldObjects implements IMovable {
    /**
     * Number of doors for a specific paket.car.
     */
    protected int nrDoors; // Number of doors on the paket.car
    /**
     * Engine Power for a specific paket.car.
     */
    protected double enginePower; // Engine power of the paket.car
    /**
     * The current speed of the paket.car.
     */
    protected double currentSpeed; // The current speed of the paket.car
    /**
     * Color of the created paket.car
     */
    protected Color color; // Color of the paket.car
    /**
     * The paket.car model name.
     */
    protected String modelName; // The paket.car model name
    /**
     * X-coordinate of the moving paket.car.
     */
    private double x = 0; // x-coordinate of the moving paket.car
    /**
     * Y-coordinate of the moving paket.car.
     */
    private double y = 0; // y-coordinate of the moving paket.car
    /**
     * A default start value for the direction of all the created cars.
     */
    private Directions CurrentDirection = Directions.UP;
    /**
     * Immutable array of all possible direction.
     */
    private final Directions[] ListOfDirections = {Directions.UP, Directions.RIGHT, Directions.DOWN, Directions.LEFT}; //List of possible directions
    /**
     * Index for vehicle's current direction from list of directions.
     */
    private int index; // Index of paket.car's current direction
    /**
     * Tells if the engine is on or off
     */
    protected boolean engineOn;
    /**
     * Tells if the paket.car is loaded onto a carrier or not
     */
    protected boolean loaded = false;
    /**
     * License plate for the paket.car
     */
    protected String plate;



    ///////////////////////////// GETTERS ///////////////////////////////

    /**
     * Get license plate for the paket.car
     * @return String
     */
    public String getLicensePlate() {
        return plate;
    }

    /**
     * Returns loaded status for the paket.car
     * @return boolean
     */
    public boolean isLoaded() { return loaded; }

    /**
     * Returns X coordinate for the car.
     * @return int X
     */
    public double getX() { return x;}

    /**
     * Returns Y coordinate for the car.
     * @return int Y
     */
    public double getY(){ return y;}

    /**
     * Returns vehicles current facing direction.
     * @return Direction
     */
    public Directions getDirection() { return CurrentDirection; }

    /**
     * Returns number of doors on vehicle.
     * @return int
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the vehicle's engine's power.
     * @return int
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the vehicle.
     * @return int
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the color of the vehicle.
     * @return Color
     */
    public Color getColor(){
        return color;
    }



    ///////////////////////////// SETTERS ///////////////////////////////

    /**
     * Sets a new color for the vehicle.
     * @param clr Color
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Makes a cars loaded attribute true
     * @param loaded boolean
     */
    protected void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * Sets new X coordinate for the car
     * @param x int
     */
    protected void setX(double x) {
        this.x = x;
    }

    /**
     * Sets new Y coordinate for the car
     * @param y int
     */
    protected void setY(double y) {
        this.y = y;
    }



    ///////////////////////////// METHODS ///////////////////////////////

    /**
     * Sets the current speed of the vehicle to 0.1 (can the vehicle "gas" without starting the engine?).
     */
    public void startEngine(){
        if (!loaded)
            {engineOn = true;}
    }

    /**
     * Sets the current speed of the vehicle to 0.0 (should we add a instance attribute "Engine" (boolean)?).
     */
    public void stopEngine(){
        if (currentSpeed == 0) {
            engineOn = false;
        } else {
            System.out.println("Brake before stopping the engine");
        }
    }

    /**
     * Method should be implemented in subclasses.
     */
    abstract double speedFactor();

    /**
     * Method should be implemented in subclasses.
     */
    abstract void incrementSpeed(double amount);

    /**
     * Method should be implemented in subclasses.
     */
    abstract void decrementSpeed(double amount);

    /**
     * Accelerates the speed of the vehicle.
     * @param amount Double between interval [0,1].
     * @throws IllegalArgumentException amount is higher or lower than the interval.
     */
    public void gas(double amount) throws IllegalArgumentException{
        if (engineOn){
            if ((0 > amount) || (amount > 1)) {
                throw new IllegalArgumentException("Please enter a gas amount between 0 and 1");
            }
            incrementSpeed(amount);
        } else {
            System.out.println("*Car's engine is turned off*");
        }
    }

    /**
     * Decreases the speed of the vehicle.
     * @param amount Double between interval [0,1].
     * @throws IllegalArgumentException amount is higher or lower than the interval.
     */
    public void brake(double amount) throws IllegalArgumentException{
        if (engineOn){
            if ((0 > amount) || (amount > 1)) {
                throw new IllegalArgumentException("Please enter a brake amount between 0 and 1");
            }
            decrementSpeed(amount);
        } else {
            System.out.println("*Car's engine is turned off*");
        }
    }

    /**
     * Moves the vehicle in the direction it's currently facing. The vehicle's current speed affects how far the vehicle moves.
     */
    @Override
    public void move() {
        if (engineOn) {
            switch (CurrentDirection) {
                case UP -> y = (y + currentSpeed);
                case LEFT -> x = (x - currentSpeed);
                case RIGHT -> x = (x + currentSpeed);
                case DOWN -> y = (y - currentSpeed);
            }
        } else {
            System.out.println("Cannot move with engine turned off");
        }
    }

    /**
     * Makes the vehicle turn 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        FindIndexOfDirection();
        if (ListOfDirections[index] == Directions.UP) {
            CurrentDirection = Directions.LEFT;
        } else {
            CurrentDirection = ListOfDirections[index-1];
        }
    }

    /**
     * Makes the vehicle turn 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        FindIndexOfDirection();
        if (ListOfDirections[index] == Directions.LEFT) {
            CurrentDirection = Directions.UP;
        } else {
            CurrentDirection = ListOfDirections[index+1];
        }
    }

    /**
     * Finds the index of the current direction in a list containing all directions.
     */
    private void FindIndexOfDirection() {
        for (int i = 0; i < ListOfDirections.length; i++) {
            if (ListOfDirections[i] == CurrentDirection) {
                index = i;
                break;
            }
        }
    }
}
