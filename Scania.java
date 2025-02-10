public class Scania extends Car {

    private double trailerAngle;

    public Scania() {
        super(2, 100, "White", "Scania");
        this.trailerAngle = 0;
    }

    public void lowerTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        if (trailerAngle < 70 && !getEngineOn()) {
            trailerAngle = (Math.min(70, trailerAngle + degree));
        }
    }

    public void elevateTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        if (trailerAngle > 0){
            trailerAngle = (Math.max(0, trailerAngle - degree));
        }
    }

    protected double getTrailerAngle(){return trailerAngle;}

    @Override
    public void startEngine(){
        if (trailerAngle == 0) {super.startEngine();}
    }
}
