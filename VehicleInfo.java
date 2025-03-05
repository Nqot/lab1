import java.util.ArrayList;

public class VehicleInfo {
    private ArrayList<Vehicle> vehicles;

    VehicleInfo(){
        this.vehicles = new ArrayList<>();

    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {vehicles.remove(vehicle);}
}
