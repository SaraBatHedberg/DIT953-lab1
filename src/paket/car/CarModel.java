package paket.car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel implements ISubscriber{
    List<Observer> observers;                                        // should be made into an abstract superclass CarViews
    List<Car> cars = new ArrayList<>();
    private final int delay = 50;
    protected Timer timer = new Timer(delay, new CarModel.TimerListener());

    public CarModel(){
        observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateObservers() {
        for (Observer observer: observers){
            observer.update();
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public void borderControl() {
        for (Car car : cars) {
            // int x = (int) Math.round(car.getLocation()[0]);
            // int y = (int) Math.round(car.getLocation()[1]);
            switch (car.getDirection()) {
                case UP -> {
                    if (car.getLocation()[1] >= 800 - 240 - 60) {
                        invertDirection(car);
                    }
                }
                case DOWN -> {
                    if (car.getLocation()[1] <= 0) {
                        invertDirection(car);
                    }
                }
                case LEFT -> {
                    if (car.getLocation()[0] <= 0) {
                        invertDirection(car);
                    }
                }
                case RIGHT -> {
                    if (car.getLocation()[0] >= 400) {
                        invertDirection(car);
                    }
                }
            }
        }
    }
    void invertDirection(Car car) {
        car.turnLeft();
        car.turnLeft();
    }

    public List<Car> getCars() {
        return cars;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn (){
        for (Car car : cars){
            if (checkIfCarSaab(car)){
                ((Saab95) car).setTurboOn();
                System.out.println("Turbo on");
            }
        }
    }

    void turboOff (){
        for (Car car : cars){
            if (checkIfCarSaab(car)){
                ((Saab95) car).setTurboOff();
                System.out.println("Turbo Off");
            }
        }
    }

    void liftBed(int amount) {
        for (Car car : cars) {
            if (checkIfCarScania(car)) {
                ((Scania) car).raisePlatform(amount);
                System.out.println("Lifted bed " + amount + " degrees");
            }
        }
    }

    void lowerBed (int amount) {
        for (Car car : cars) {
            if (checkIfCarScania(car)) {
                ((Scania) car).lowerPlatform(amount);
                System.out.println("Lowered bed " + amount + " degrees");
            }
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    private boolean checkIfCarSaab(Car car){
        return car.getClass() == Saab95.class;
    }

    private boolean checkIfCarScania(Car car){
        return car.getClass() == Scania.class;
    }
}

