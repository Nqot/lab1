public abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class Saab95Factory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Saab95();
    }
}

class Volvo240Factory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Volvo240();
    }
}