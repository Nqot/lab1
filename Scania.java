import java.awt.*;

public class Scania extends Truck {

    private Trailer trailer;

    public Scania() {
        super(2, 75, "White", "Scania");
        this.trailer = new Trailer();
        stopEngine();
    }

    public void setTrailerAngle(int angle){
        if (getCurrentSpeed() == 0) {this.trailer.setTrailerAngle(angle);}
    }

    public double getTrailerAngle(){return this.trailer.getTrailerAngle();}


    @Override
    public void startEngine(){
        if (this.trailer.getTrailerAngle() == 0) {super.startEngine();}
    }

    @Override
    public void move(){
        if (this.trailer.getTrailerAngle() == 0) {super.move();}
    }
}
