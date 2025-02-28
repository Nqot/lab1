import java.util.ArrayList;


public class Repairshop<T extends Car>{
    private final int maxCars;
    private static final double loadDistance = 2.0;
    private ArrayList<T> loadedCars;
    //private Class<?>[] carTypes;
    private final double x;
    private final double y;

    public Repairshop(int maxCars) {
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<>();
        this.x = 300;
        this.y = 300;
    }

    public ArrayList<T> getLoadedCars(){
        return loadedCars;
    }

    public int getCarCount(){
        return loadedCars.size();
    }


    public void loadCar(T car) {
        if (!(loadedCars.size() == this.maxCars)){
            loadedCars.add(car);
        } else throw new IllegalArgumentException("Garage is full");
    }

    public Car unloadCar(int carNumber) {
        Car unloaded = null;
        if(carNumber < loadedCars.size()) {
            unloaded = loadedCars.get(carNumber);
            loadedCars.remove(carNumber);
        }
        return unloaded;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
