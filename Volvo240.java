
// Skapar en subclass, Volvo240, som ärver allt från Car förutom trimFactor
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    private final String imgPath;

    public Volvo240() {
        super(4, 100, "black", "Volvo240");
        this.x = 300;
        this.imgPath = "pics/Volvo240.jpg";
    }

    @Override
    protected double getSpeedFactor() {
        return super.getSpeedFactor() * trimFactor;
    }

    public String getImage() { return imgPath; }
}


