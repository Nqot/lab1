

// Skapar ytterligare en subclass, Saab95, som ärver från Car men lägger till turbo metod
public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super(2, 125, "red", "Saab95");
        this.turboOn = false;
        this.x = 100;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double getSpeedFactor() {
        double turbo = turboOn ? 1.3 : 1;
        return super.getSpeedFactor() * turbo;
    }
}
