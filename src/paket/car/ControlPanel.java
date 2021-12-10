package paket.car;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    JSpinner gasSpinner = new JSpinner();
    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    private final Color myRed = new Color(130, 51, 51);
    private final Color background = new Color(80, 115, 70);

    public ControlPanel(int X) {
        this.setLayout(new GridLayout(2, 4));
        this.add(gasButton, 0);
        this.add(turboOnButton, 1);
        this.add(liftBedButton, 2);
        this.add(brakeButton, 3);
        this.add(turboOffButton, 4);
        this.add(lowerBedButton, 5);
        this.setPreferredSize(new Dimension((X/2)+4, 200));
        this.setBackground(background);
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
    }

    public void createStart(int X) {
        startButton.setBackground(Color.lightGray);
        startButton.setForeground(background);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);
    }

    public void createStop(int X) {
        stopButton.setBackground(myRed);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }


}



