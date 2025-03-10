public class Main {
    public static void main(String[] args) {
        VehicleInfo info = new VehicleInfo();
        CarController cc = new CarController();

        info.addObserver(cc);

        info.addVehicle(new Volvo240());
        info.addVehicle(new Saab95());
        info.addVehicle(new Scania());

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
