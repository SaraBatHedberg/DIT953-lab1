package paket.car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.*;
import javax.swing.*;
// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private final CarModel model;
    CarController cc;
    ArrayList<BufferedImage> listan = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc, CarModel model) {
        this.setDoubleBuffered(true);
        this.model = model;
        this.setPreferredSize(new Dimension(x, y));
        Color lightGreen = new Color(80, 115, 70);
        this.setBackground(lightGreen);
        readImages();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            for (int i = 0; i < listan.size(); i++){
                BufferedImage currentImage = listan.get(i);
                Car currentCar = cc.getCars().get(i);
                int distanceCars = 150;
                g.drawImage(currentImage, (int)Math.round(currentCar.getLocation()[0]) + i* distanceCars, (int)Math.round(currentCar.getLocation()[1]), null);
                model.borderControl();
                model.updateObservers();
            }
    }
}
