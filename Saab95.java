

// Skapar ytterligare en subclass, Saab95, som ärver från Car men lägger till turbo metod
public class Saab95 extends Car {

    private boolean turboOn;
    private final String imgPath;

    public Saab95() {
        super(2, 125, "red", "Saab95");
        this.turboOn = false;
        this.x = 100;
        this.imgPath = "pics/Saab95.jpg";
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
    public String getImage() { return imgPath; }
}
