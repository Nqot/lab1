import java.util.List;
import java.util.LinkedList;

public class Transport extends Car implements loadable {
    private static final int maxCars = 5;
    private List<Car> loadedCars;
    private boolean ifTrailerUp;
    private final Scania parent;


    public Transport() {
        super(2, 100, "White", "Transport");
        this.loadedCars = new LinkedList<>();
        this.ifTrailerUp = true;
        this.parent = new Scania();
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {ifTrailerUp = false;}
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {ifTrailerUp = true;}
    }

    public void loadCar(Car car) {
        if      (!ifTrailerUp
                && getCurrentSpeed() == 0
                && loadedCars.size() <= maxCars
                && !(car instanceof Transport)
                && Math.hypot(getX() - car.getX(), getY() - car.getY()) <= 2) {
            loadedCars.add(car);
            car.moveTo(getX(), getY());

        };
    }

    public void unloadCar() {
        if (!ifTrailerUp && getCurrentSpeed() == 0 && loadedCars.isEmpty()) {
        Car car = loadedCars.remove(loadedCars.size() - 1);
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
        parent.startEngine();
    }

    public boolean isFull() {return loadedCars.size() >= 5;}

    public int getAmountLoaded() {return loadedCars.size();}
}
