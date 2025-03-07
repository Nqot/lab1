import java.util.ArrayList;

public class VehicleInfo {
    private ArrayList<Vehicle> Vehicles;

    VehicleInfo(){
        Vehicles = new ArrayList<>();

    }

    private final ArrayList<VehicleObserver> observers = new ArrayList<>();

    public void addObserver(VehicleObserver observer) {observers.add(observer);}

    public void removeObserver(VehicleObserver observer) {observers.remove(observer);}

    private void multicastStatusChange(ArrayList<Vehicle> vehicles) {
        for (VehicleObserver observer : observers) {
            observer.actOnChange(vehicles);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return Vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        Vehicles.add(vehicle);
        multicastStatusChange(Vehicles);
    }
}
