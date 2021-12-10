package paket.car;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    //private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    //protected Timer timer = new Timer(delay, new CarController.TimerListener());
    // The frame that represents this instance View of the MVC pattern
    //CarModel model = new CarModel();
    // A list of cars, modify if needed
    //protected ArrayList<Car> cars = new ArrayList<>();

    // public ArrayList<Car> getCars() {
    //    return cars;
    // }

    /* Each step the TimerListener moves all the cars in the list. Change this method to your needs.
     * */
//    private class TimerListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            for (Car car : cars) {
//                car.move();
//            }
//        }
//    }
    CarModel model;

    ControlPanel panel;
    int gasAmount = 0;

    public CarController(CarModel model, ControlPanel panel){
        this.model = model;
        this.panel = panel;
    }

    public void init(){
        panel.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        panel.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.turboOff();
        }
    });

        panel.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.turboOn();
        }
    });

        panel.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { model.brake(gasAmount); }
    });

        panel.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.gas(gasAmount);
        }
    });

        panel.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.startEngine();
        }
    });

        panel.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.stopEngine();
        }
    });

        panel.liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.liftBed(gasAmount);
        }
    });

        panel.lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.lowerBed(gasAmount);
        }
    });
}}
