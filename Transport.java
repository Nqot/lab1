import java.awt.*;
import java.util.Stack;

public class Transport extends Car implements loadable {
    private static int maxCars;
    private Stack<Car> loadedCars;
    private Trailer trailer;


    public Transport() {
        super(2, 75, "White", "Transport");
        this.loadedCars = new Stack<>();
        this.trailer = new Trailer();
        this.maxCars = 5;
        stopEngine();
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {this.trailer.setTrailerAngle(70);}
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {this.trailer.setTrailerAngle(0);}
    }

    public int getTrailerAngle(){return this.trailer.getTrailerAngle();}

    public void loadCar(Car car) {
        if      (getTrailerAngle() == 70
                && getCurrentSpeed() == 0
                && loadedCars.size() <= maxCars
                && !((car instanceof Transport) || (car instanceof Scania))
                && checkCarDistance(car)) {
            loadedCars.push(car);
            car.moveTo(getX(), getY());

        }
    }
    public boolean checkCarDistance(Car car){
        return Math.hypot(getX() - car.getX(), getY() - car.getY()) <= 2;
    }

    public void unloadCar() {
        if (this.trailer.getTrailerAngle() == 70 && getCurrentSpeed() == 0 && !loadedCars.isEmpty()) {
        Car car = loadedCars.pop();
        car.moveTo(getX() + 2, getY());}
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.moveTo(getX(), getY());
        }
    }

    @Override
    public void startEngine(){
        if(this.trailer.getTrailerAngle() == 0) {super.startEngine();}
    }

    public boolean isFull() {return loadedCars.size() >= 5;}

    public int getAmountLoaded() {return loadedCars.size();}
}
