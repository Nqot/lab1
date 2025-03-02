public class Trailer {
    private int trailerAngle;

    public Trailer(){
        trailerAngle = 0;
    }

    public int getTrailerAngle() {return trailerAngle;}

    public void setTrailerAngle(int angle) {
        if (angle >= 0 && angle <= 70){trailerAngle = angle;}
    }
}
