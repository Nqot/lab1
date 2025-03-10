import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements VehicleObserver {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    protected Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    VehicleInfo model;
    // A list of cars, modify if needed
    protected ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Repairshop<Volvo240> volvoWorkshop = new Repairshop<>(10);



    //methods:

    @Override
    public void actOnChange(ArrayList<Vehicle> vehicles) {

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.act();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        model.gas(gas);
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        model.brake(brake);
    }

    void startEngine() {
        model.startEngine();
    }

    void stopEngine() {
        model.stopEngine();
    }

    void turboOn() {
        model.turboOn();
    }

    void turboOff() {
        model.turboOff();
    }

    void bedUp() {
        model.bedUp();
    }

    void bedDown() {
        model.bedDown();
    }

}
