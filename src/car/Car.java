package car;

import java.awt.*;

/**
 * this class creates a new object of the type Car.
 */
public abstract class Car implements Movable {
    /**
     * Number of doors for a specific car.
     */
    protected int nrDoors; // Number of doors on the car
    /**
     * Engine Power for a specific car.
     */
    protected double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */
    protected double currentSpeed; // The current speed of the car
    /**
     * Color of the created car
     */
    protected Color color; // Color of the car
    /**
     * The car model name.
     */
    protected String modelName; // The car model name
    /**
     * X-coordinate of the moving car.
     */
    private double x = 0; // x-coordinate of the moving car
    /**
     * Y-coordinate of the moving car.
     */
    private double y = 0; // y-coordinate of the moving car
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
    private int index; // Index of car's current direction


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

    /**
     * Sets a new color for the vehicle.
     * @param clr Color
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed of the vehicle to 0.1 (can the vehicle "gas" without starting the engine?).
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed of the vehicle to 0.0 (should we add a instance attribute "Engine" (boolean)?).
     */
    public void stopEngine(){
        currentSpeed = 0;
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
        if ((0 > amount) || (amount > 1)) {
            throw new IllegalArgumentException("Please enter a gas amount between 0 and 1");
        }
        incrementSpeed(amount);
    }

    /**
     * Decreases the speed of the vehicle.
     * @param amount Double between interval [0,1].
     * @throws IllegalArgumentException amount is higher or lower than the interval.
     */
    public void brake(double amount) throws IllegalArgumentException{
        if ((0 > amount) || (amount > 1)) {
            throw new IllegalArgumentException("Please enter a brake amount between 0 and 1");
        }
        decrementSpeed(amount);
    }

    /**
     * Moves the vehicle in the direction it's currently facing. The vehicle's current speed affects how far the vehicle moves.
     */
    @Override
    public void move() {
        switch(CurrentDirection) {
            case UP -> y = (y + currentSpeed);
            case LEFT -> x = (x - currentSpeed);
            case RIGHT -> x = (x + currentSpeed);
            case DOWN -> y = (y - currentSpeed);
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
