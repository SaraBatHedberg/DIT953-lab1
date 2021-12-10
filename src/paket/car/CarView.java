package paket.car;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements Observer{
    private static final int X = 800;
    private static final int Y = 800;
    private final Color background = new Color(80, 115, 70);
    private final Color myRed = new Color(130, 51, 51);
    // The controller member
    CarModel model;
    ControlPanel CPanel = new ControlPanel(X);
    DrawPanel drawPanel;

    // Constructor
    public CarView(String framename, CarModel model){
        this.drawPanel = new DrawPanel (X, Y-240, model);
        this.model = model;
        initComponents(framename);
        model.subscribe(this);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        CPanel.createStart(X);
        CPanel.createStop(X);

        this.add(CPanel.gasPanel);
        this.add(CPanel);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        drawPanel.repaint();
    }
}