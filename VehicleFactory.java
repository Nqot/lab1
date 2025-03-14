public abstract class VehicleFactory {
    abstract Vehicle createVehicle();

}

class Volvo240Factory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Volvo240();
    }
}