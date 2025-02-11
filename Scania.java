public class Scania extends Car {

    private double trailerAngle;
    private boolean trailerUp;

    public Scania() {
        super(2, 100, "White", "Scania");
        this.trailerAngle = 0;
        this.trailerUp = true;
    }

    public void lowerTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        trailerUp = false;
        if (trailerAngle < 70 && !getEngineOn()) {
            trailerAngle = (Math.min(70, trailerAngle + degree));
        }
        this.setTrailerUp();
    }

    public void elevateTrailer(double degree){
        if (degree < 0 || degree > 70) throw new IllegalArgumentException("trailer angle must be between 0 and 70");
        if (trailerAngle > 0){
            trailerAngle = (Math.max(0, trailerAngle - degree));
        }
        this.setTrailerUp();
    }

    protected double getTrailerAngle(){return trailerAngle;}
    protected boolean getTrailerUp(){return trailerAngle == 0;}
    protected void setTrailerUp(){trailerUp = trailerAngle == 0;}

    @Override
    public void startEngine(){
        if (trailerUp) {super.startEngine();}
    }
}
