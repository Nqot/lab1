public class Trailer implements HasTrailer{
    private int trailerAngle;

    public Trailer(){
        trailerAngle = 0;
    }

    @Override
    public int getTrailerAngle() {return trailerAngle;}
    
    @Override
    public void setTrailerAngle(int angle) {
        if (angle >= 0 && angle <= 70){trailerAngle = angle;}
    }
}
