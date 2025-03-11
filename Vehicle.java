public abstract class Vehicle implements Movable{

    private final int nrDoors;
    private final double enginePower;
    private boolean engineOn;
    private double currentSpeed;
    private String color;
    private final String modelName;
    protected double x; // X-position
    protected double y; // Y-position
    private int direction; // 0 = North, 1 = East, 2 = South, 3 = West
    private String imgPath;

    protected Vehicle (int nrDoors, double enginePower, String color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.direction = 0; // Startar riktad mot norr
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String clr) {
        this.color = clr;
    }

    public void startEngine() {
        engineOn = true;
    }

    public void stopEngine() {
        engineOn = false;
        currentSpeed = 0;
    }

    protected double getSpeedFactor() {
        return enginePower * 0.01; // Default speed factor, can be overridden
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + getSpeedFactor() * amount, enginePower); // Begränsa till enginePower
    }

    protected void decrementSpeed(double amount) {
        if (currentSpeed > 0){
            currentSpeed = Math.max(currentSpeed - getSpeedFactor() * amount, 0);// Begränsa till 0
        } else if (currentSpeed < 0) {
            currentSpeed = Math.min(currentSpeed - getSpeedFactor() * amount, 0);
        }
    }

    public void gas(double amount) {
        if (amount < 0 || amount > 1) throw new IllegalArgumentException("Gas amount must be between 0 and 1");
        if (currentSpeed < enginePower && engineOn) { // Endast öka farten om den inte redan är maxad
            incrementSpeed(amount*100);
        }
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) throw new IllegalArgumentException("Brake amount must be between 0 and 1");
        if (Math.abs(currentSpeed) > 0) { // Endast minska farten om den inte redan är noll
            decrementSpeed(amount * 100);
        }
    }

    // Movable methods implementation
    @Override
    public void move() {
        switch (direction) {
            case 0 -> y += currentSpeed; // Nord
            case 1 -> x += currentSpeed; // Öst
            case 2 -> y -= currentSpeed; // Syd
            case 3 -> x -= currentSpeed; // Väst
        }
    }

    public void moveTo(double newX, double newY) {
        x = newX;
        y = newY;
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4; // Cirkulär rotation åt vänster
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4; // Cirkulär rotation åt höger
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getImage() { return imgPath; }
}