public class Main {
    public static void main(String[] args) {
        CarController cc = new CarController();
        CarView view = new CarView("CarSim 1.0", cc);

        cc.model.addObserver(view);
        cc.model.addVehicle(new Volvo240());
        cc.model.addVehicle(new Saab95());
        cc.model.addVehicle(new Scania());


        // Start the timer
        cc.model.timer.start();
    }
}
