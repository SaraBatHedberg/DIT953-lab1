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
    CarController cc;
    private final Color lightGreen = new Color(80, 115, 70);
    ArrayList<BufferedImage> listan = new ArrayList<>();
    private final int distanceCars = 150;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) {
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
            for (int i = 0; i < listan.size(); i++){
                BufferedImage currentImage = listan.get(i);
                Car currentCar = cc.getCars().get(i);
                g.drawImage(currentImage, (int)Math.round(currentCar.getLocation()[0]) + i*distanceCars, (int)Math.round(currentCar.getLocation()[1]), null);
            }

    }
}
