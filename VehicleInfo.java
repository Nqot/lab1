import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleInfo {
    private HashMap<Vehicle, BufferedImage> Vehicles;

    VehicleInfo(){
        Vehicles = new HashMap<>();

    }

    public HashMap<Vehicle, BufferedImage> getVehicles() {
        return Vehicles;
    }

    public void addVehicle(Vehicle vehicle, BufferedImage image) {
        Vehicles.put(vehicle, image);
    }
}
