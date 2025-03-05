import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Repairshop<Volvo240> volvoWorkshop = new Repairshop<>(10);
    private VehicleInfo info = new VehicleInfo();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.info.addVehicle(new Volvo240());
        cc.info.addVehicle(new Saab95());
        cc.info.addVehicle(new Scania());

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : info.getVehicles()) {
                vehicle.move();
                checkBoundaries(vehicle);
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                frame.drawPanel.moveit(x, y, info.getVehicles().indexOf(vehicle));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            loadVolvoToWorkshop(info.getVehicles().get(0));

        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle vehicle : info.getVehicles()) {
            vehicle.gas(gas);
       }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : info.getVehicles()) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : info.getVehicles()) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : info.getVehicles()) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : info.getVehicles()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : info.getVehicles()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void bedUp() {
        for (Vehicle vehicle : info.getVehicles()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).setTrailerAngle(0);
            }
        }
    }

    void bedDown() {
        for (Vehicle vehicle : info.getVehicles()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).setTrailerAngle(70);
            }
        }
    }

    void loadVolvoToWorkshop(Vehicle vehicle) {
            if (vehicle instanceof Volvo240) {
                if (Math.abs(vehicle.getX() - volvoWorkshop.getX()) < 10 && Math.abs(vehicle.getY() - volvoWorkshop.getY()) < 10) {
                    volvoWorkshop.loadCar((Volvo240) vehicle);
                    info.getVehicles().remove(vehicle);
                    frame.drawPanel.removePoint(0);
                    frame.drawPanel.removeImage(0);

                }
            }
    }

    private void checkBoundaries(Vehicle vehicle) {
        if (vehicle.getX() < 0 || vehicle.getX() > frame.getWidth() - 100) {
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
        if (vehicle.getY() < 0 || vehicle.getY() > frame.getHeight() - 240) {
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
    }



}
