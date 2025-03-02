import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // To keep track of a single car's position

    private ArrayList<BufferedImage> carImages = new ArrayList<>();
    private ArrayList<Point> carPoints = new ArrayList<>();


    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, int carIndex){

        carPoints.get(carIndex).x = x;
        carPoints.get(carIndex).y = y;

        /*
        if (vehicle instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        } else if (vehicle instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (vehicle instanceof Scania) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }*/
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {

            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            BufferedImage volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            carImages.add(volvoImage);
            carPoints.add(new Point());

            BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            carImages.add(saabImage);
            carPoints.add(new Point());

            BufferedImage scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            carImages.add(scaniaImage);
            carPoints.add(new Point());

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
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

        for (int i = 0; i < carPoints.size(); i++) {
            g.drawImage(carImages.get(i), carPoints.get(i).x, carPoints.get(i).y, null);
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
