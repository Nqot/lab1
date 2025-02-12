import java.util.ArrayList;


public class Repairshop<T extends Car>{
    private final int maxCars;
    private static final double loadDistance = 2.0;
    private ArrayList<T> loadedCars;
    private Class<?>[] carTypes;
    //private final double x;
    //private final double y;

    public Repairshop(int maxCars, Class<? extends T>... carModels) {
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<>();
        this.carTypes = carModels;
    }

    public ArrayList<T> getLoadedCars(){
        return loadedCars;
    }

    public Class<?>[] getCarTypes() {
        return carTypes;
    }

    private boolean isAccepted(T car) {
        boolean check = false;
        if (loadedCars.size() == this.maxCars) {
         return false;
        } else {
            for (Class<?> model : carTypes) {
                if (model.isInstance(car)) {
                    check = true;
                    break;
                }
            }
        }   return check;
    }

    public void loadCar(T car) {
        if (isAccepted(car)){
            loadedCars.add(car);
        } else throw new IllegalArgumentException("wrong car model");
    }

    public Car unloadCar(int carNumber) {
        Car unloaded = null;
        if(carNumber != 0 && carNumber < loadedCars.size()) {
            unloaded = loadedCars.get(carNumber);
            loadedCars.remove(carNumber);
        }
        return unloaded;
    }
}
