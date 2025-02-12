public class Scania extends Car implements Trailer {

    private double trailerAngle;
    private boolean ifTrailerUp;

    public Scania() {
        super(2, 100, "White", "Scania");
        this.trailerAngle = 0;
        setIfTrailerUp();
    }

    public void lowerTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        if (trailerAngle < 70 && !getEngineOn()) {
            trailerAngle = (Math.min(70, trailerAngle + degree));
        }
        setIfTrailerUp();
    }

    public void elevateTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        if (trailerAngle > 0){
            trailerAngle = (Math.max(0, trailerAngle - degree));
        }
        setIfTrailerUp();
    }

    protected double getTrailerAngle(){return trailerAngle;}
    protected boolean getTrailerUp(){return trailerAngle == 0;}
    protected void setIfTrailerUp(){ifTrailerUp = trailerAngle == 0;}

    @Override
    public void startEngine(){
        if (ifTrailerUp) {super.startEngine();}
    }
}
