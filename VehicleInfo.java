import java.util.ArrayList;

public class VehicleInfo {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<VehicleObserver> observers;
    private Repairshop<Volvo240> volvoWorkshop = new Repairshop<>(2);

    VehicleInfo(){
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void act(){
        for (Vehicle vehicle : vehicles) {
            move(vehicle);
        }
        multicastStatusChange(vehicles);
    }

    private void move(Vehicle vehicle) {
        vehicle.move();
    }

    void gas(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);
        }
    }

    void brake(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void bedUp() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).setTrailerAngle(0);
            }
        }
    }

    void bedDown() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).setTrailerAngle(70);
            }
        }
    }

    void loadVolvoToWorkshop(Vehicle vehicle) {
        if (vehicle instanceof Volvo240) {
            if (Math.abs(vehicle.getX() - volvoWorkshop.getX()) < 10 && Math.abs(vehicle.getY() - volvoWorkshop.getY()) < 10) {
                if (vehicle.getCurrentSpeed() > 0) {
                    volvoWorkshop.loadCar((Volvo240) vehicle);
                    vehicles.remove(vehicle);


                }
            }
        }
    }


    public void addObserver(VehicleObserver observer) {observers.add(observer);}

    public void removeObserver(VehicleObserver observer) {observers.remove(observer);}

    private void multicastStatusChange(ArrayList<Vehicle> vehicles) {
        for (VehicleObserver observer : observers) {
            observer.actOnChange(vehicles);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        multicastStatusChange(vehicles);
    }
}
