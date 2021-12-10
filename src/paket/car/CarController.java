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

    public ArrayList<Car> getCars() {
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
                        if (y >= 800 - 240 - 60) {
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
                //frame.drawPanel.repaint();
                //car.updateObservers();

                //model.updateObservers();
            }
            void invertDirection(Car car) {
                car.turnLeft();
                car.turnLeft();
            }

        }
    }

        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turboOff();
        }
    });

        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turboOn();
        }
    });

        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { carC.brake(gasAmount); }
    });

        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.gas(gasAmount);
        }
    });

        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.startEngine();
        }
    });

        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.stopEngine();
        }
    });

        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.liftBed(gasAmount);
        }
    });

        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.lowerBed(gasAmount);
        }
    });
}
