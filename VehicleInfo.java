import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleInfo {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<VehicleObserver> observers;
    private Repairshop<Volvo240> volvoWorkshop = new Repairshop<>(2);
    private ArrayList<Vehicle> toBeRemoved;
    private Volvo240Factory volvoFactory = new Volvo240Factory();
    private final int delay = 50;
    protected Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            act();

            multicastStatusChange(vehicles);
        }
    }


    VehicleInfo(){
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void act(){
        for (Vehicle vehicle : vehicles) {
            move(vehicle);
            checkBoundaries(vehicle);
        }
        toBeRemoved = new ArrayList<>();
        loadVolvoToWorkshop();
        if (!toBeRemoved.isEmpty()){for (Vehicle vehicle : toBeRemoved){vehicles.remove(vehicle);}}
    }

    private void checkBoundaries(Vehicle vehicle) {
        if (vehicle.getX() < 0 || vehicle.getX() > 700) {
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
        if (vehicle.getY() < 0 || vehicle.getY() > 560) {
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
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
            if (vehicle instanceof TurboCar) {
                ((TurboCar) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof TurboCar) {
                ((TurboCar) vehicle).setTurboOff();
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

    void loadVolvoToWorkshop() {
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Volvo240) {
                if (Math.abs(vehicle.getX() - volvoWorkshop.getX()) < 10 && Math.abs(vehicle.getY() - volvoWorkshop.getY()) < 10) {
                    volvoWorkshop.loadCar((Volvo240) vehicle);
                    toBeRemoved.add(vehicle);
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
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addVolvo() {
        vehicles.add(volvoFactory.createVehicle());
        multicastStatusChange(vehicles);
    }
}
