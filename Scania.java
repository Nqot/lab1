import java.awt.*;

public class Scania extends Truck implements HasTrailer{

    private Trailer trailer;
    private String imgPath;

    public Scania() {
        super(2, 75, "White", "Scania");
        this.trailer = new Trailer();
        this.imgPath = "pics/Scania.jpg";

    }

    @Override
    public void setTrailerAngle(int angle){
        if (getCurrentSpeed() == 0) {this.trailer.setTrailerAngle(angle);}
    }

    @Override
    public int getTrailerAngle(){return this.trailer.getTrailerAngle();}


    @Override
    public void startEngine(){
        if (this.trailer.getTrailerAngle() == 0) {super.startEngine();}
    }

    @Override
    public void move(){
        if (this.trailer.getTrailerAngle() == 0) {super.move();}
    }

    public String getImage() { return imgPath; }
}
