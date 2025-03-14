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

public class CarController {
    // member fields:

    VehicleInfo model = new VehicleInfo();
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

    public void addCar() { model.addVolvo();}
}
