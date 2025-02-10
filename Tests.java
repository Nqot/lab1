import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;

    @BeforeEach
    public void setUp() {
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
    }

    // Test for starting and stopping the engine
    @Test
    public void testStartAndStopEngine() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());

        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());

        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());

        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed());
    }

    // Test gas and brake functionality
    @Test
    public void testGasAndBrake() {
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() > 0.1);

        volvo.brake(0.3);
        assertTrue(volvo.getCurrentSpeed() < 0.1 + volvo.getSpeedFactor() * 50);

        saab.startEngine();
        saab.gas(0.7);
        assertTrue(saab.getCurrentSpeed() > 0.1);

        saab.brake(0.4);
        assertTrue(saab.getCurrentSpeed() < 0.1 + saab.getSpeedFactor() * 70);
    }

    // Test exception for invalid gas and brake values
    @Test
    public void testGasAndBrakeExceptions() {
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(1.1));

        assertThrows(IllegalArgumentException.class, () -> volvo.brake(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(1.1));
    }
    // Test set color
    @Test
    public void testColor() {
        volvo.setColor("blue");
        assertEquals("blue", volvo.getColor());
    }
    // Test move and turn functionality
    @Test
    public void testMoveAndTurn() {
        volvo.startEngine();
        volvo.gas(0.5); // Set initial speed
        volvo.move();
        assertEquals(0, volvo.getX(), 0.01);
        assertEquals(0.1 + volvo.getSpeedFactor() * 50, volvo.getY(), 0.01);

        volvo.turnLeft();
        volvo.move();
        assertEquals(-(0.1 + volvo.getSpeedFactor() * 50), volvo.getX(), 0.01);
        assertEquals(0.1 + volvo.getSpeedFactor() * 50, volvo.getY(), 0.01);

        volvo.turnRight();
        volvo.turnRight();
        volvo.move();
        assertEquals(0, volvo.getX(), 0.01);
        assertEquals(0.1 + volvo.getSpeedFactor() * 50, volvo.getY(), 0.01);

        volvo.turnRight();
        volvo.move();
        assertEquals(0, volvo.getX(), 0.01);
        assertEquals(0, volvo.getX(), 0.01);
    }


    // Test Volvo240-specific trim factor
    @Test
    public void testVolvoTrimFactor() {
        volvo.startEngine();
        volvo.gas(0.5);
        assertEquals(0.1 + (volvo.getSpeedFactor() * 50), volvo.getCurrentSpeed());
    }

    // Test Saab95-specific turbo functionality
    @Test
    public void testSaabTurbo() {
        saab.startEngine();
        saab.setTurboOn();
        double speedWithTurbo = saab.getSpeedFactor();

        saab.setTurboOff();
        double speedWithoutTurbo = saab.getSpeedFactor();

        assertTrue(speedWithTurbo > speedWithoutTurbo);
    }


    @Test
    public void testBrakeAcceptsOnlyValidRange() {
        // Test att brake() kastar exception för ogiltiga värden
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(-0.1));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(1.1));
    }

    @Test
    public void testGasCannotDecreaseSpeed() {
        volvo.startEngine();
        double initialSpeed = volvo.getCurrentSpeed();
        volvo.gas(0.5); // Ökar farten
        assertEquals(initialSpeed + volvo.getSpeedFactor() * 50, volvo.getCurrentSpeed(), 0.01);

        double speedAfterGas = volvo.getCurrentSpeed();
        volvo.gas(0); // Gas(0) får inte minska farten
        assertEquals(speedAfterGas, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrakeCannotIncreaseSpeed() {
        volvo.startEngine();
        volvo.gas(0.5);
        double speedAfterGas = volvo.getCurrentSpeed();

        volvo.brake(0.5); // Bromsa ner farten
        double speedAfterBrake = volvo.getCurrentSpeed();
        assertEquals(speedAfterGas - volvo.getSpeedFactor() * 50, speedAfterBrake, 0.01);

        volvo.brake(0); // Brake(0) får inte öka farten
        assertEquals(speedAfterBrake, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testCurrentSpeedWithinValidRange() {
        volvo.startEngine();
        volvo.gas(1.0);
        volvo.gas(1.0);// Maxar farten
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed(), 0.01); // currentSpeed <= enginePower

        volvo.brake(1.0); // Minskar farten till 0
        assertEquals(0.0, volvo.getCurrentSpeed(), 0.01); // currentSpeed >= 0
    }



    @Test
    public void testIncrementSpeedLimitedByEnginePower() {
        volvo.startEngine();
        volvo.gas(1.0);
        assertTrue(volvo.getEnginePower() >= volvo.getCurrentSpeed()); // currentSpeed får inte överstiga enginePower
    }

    @Test
    public void testDecrementSpeedLimitedByZero() {
        volvo.startEngine();
        volvo.brake(1.0);
        volvo.stopEngine();
        assertEquals(0.0, volvo.getCurrentSpeed()); // currentSpeed får inte gå under 0
    }

    @Test
    public void testStartEngineWithTrailerDown() {
        scania.lowerTrailer(70);
        scania.startEngine();
        assertEquals(0, scania.getCurrentSpeed());
    }

}

