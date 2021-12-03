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
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a single cars position
    private final Point volvoPoint = new Point();
    private final Point saabPoint = new Point();
    private final Point scaniaPoint = new Point();

    // TODO: Make this general for all cars
    void moveit (int x, int y, Car car){
        if (car instanceof Volvo240) {
            volvoPoint.y = y;
            volvoPoint.x = x;
        } else if (car instanceof Saab95) {
            saabPoint.y = y;
            saabPoint.x = x + 150;
        } else if (car instanceof Scania) {
            scaniaPoint.y = y;
            scaniaPoint.x = x + 300;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(lightGreen);
        this.cc = cc;
        // Print an error message in case file is not found with a try/catch block
        try {
            for (Car car: cc.getCars()) {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg")));
                listan.add(image);
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
