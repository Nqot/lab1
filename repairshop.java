import java.util.LinkedList;
import java.util.List;

public class Repairshop<T extends Car>{
    private final int maxCars;
    private static final double loadDistance = 2.0;
    private List<T> loadedCars;
    private final double x;
    private final double y;

    public Repairshop(int maxCars, double x, double y) {
        this.maxCars = maxCars;
        this.loadedCars = new LinkedList<>();
        this.x = x;
        this.y = y;

    }



    public void loadCar(T car) {
        if (loadedCars.size() < maxCars){
            loadedCars.add(car);
        }
    }

    public void unloadCar() {

    }
}
