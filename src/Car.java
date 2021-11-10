import java.awt.*;
import java.util.ArrayList;

public abstract class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double x = 0;
    private double y = 0;
    private Directions CurrentDirection = Directions.UP;
    private final Directions[] ListOfDirections = {Directions.UP, Directions.RIGHT, Directions.DOWN, Directions.LEFT};
    int index;

    public double getX() { return x;}
    public double getY(){return y;}
    public Directions getDirection() { return CurrentDirection; }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if ((0 <= amount) && (amount <= 1)) {
            incrementSpeed(amount);
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        switch(CurrentDirection) {
            case UP -> y = (y + currentSpeed);
            case LEFT -> x = (x - currentSpeed);
            case RIGHT -> x = (x + currentSpeed);
            case DOWN -> y = (y - currentSpeed);
        }
    }

    @Override
    public void turnLeft() {
        FindIndexOfDirection();
        if (ListOfDirections[index] == Directions.UP) {
            CurrentDirection = Directions.LEFT;
        } else {
            CurrentDirection = ListOfDirections[index-1];
        }
    }

    @Override
    public void turnRight() {
        FindIndexOfDirection();
        if (ListOfDirections[index] == Directions.LEFT) {
            CurrentDirection = Directions.UP;
        } else {
            CurrentDirection = ListOfDirections[index+1];
        }
    }
    
    private void FindIndexOfDirection() {
        for (int i = 0; i < ListOfDirections.length; i++) {
            if (ListOfDirections[i] == CurrentDirection) {
                index = i;
                break;
            }
        }
    }

}
