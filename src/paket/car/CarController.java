package paket.car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    protected Timer timer = new Timer(delay, new CarController.TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //CarModel model = new CarModel();

    // A list of cars, modify if needed
    protected ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars(){
        return cars;
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getLocation()[0]);
                int y = (int) Math.round(car.getLocation()[1]);
                switch (car.getDirection()) {
                    case UP -> {
                        if (y >= 800-240-60) {
                            invertDirection(car);
                        }
                    }
                    case DOWN -> {
                        if (y <= 0) {
                            invertDirection(car);
                        }
                    }
                    case LEFT -> {
                        if (x <= 0) {
                            invertDirection(car);
                        }
                    }
                    case RIGHT -> {
                        if (x >= 400) {
                            invertDirection(car);
                        }
                    }
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
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

    void invertDirection(Car car) {
        car.turnLeft();
        car.turnLeft();
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
