import car.Car;
import car.Directions;
import car.Saab95;
import car.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class VolvoAndSaabTests {
    Car saab;
    Car volvo;

    @BeforeEach
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }
    @Test
    public void TestSaabGetNrDoors() {

        assertEquals(2, saab.getNrDoors());
    }
    @Test
    public void TestSaabGetEnginePower() {

        assertEquals(125, saab.getEnginePower());
    }
    @Test
    public void TestSaabGetCurrentSpeed() {

        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabGetColor() {

        assertEquals(Color.red, saab.getColor());
    }
    @Test
    public void TestSaabSetTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }
    @Test
    public void TestVolvoGetNrDoors() {

        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    public void TestVolvoGetEnginePower() {

        assertEquals(100, volvo.getEnginePower());
    }
    @Test
    public void TestVolvoGetCurrentSpeed() {

        assertEquals(0, volvo.getCurrentSpeed());
    }
    @Test
    public void TestVolvoGetColor() {

        assertEquals(Color.black, volvo.getColor());
    }

    @Test
    public void TestYCoordinate() {
        saab.startEngine();
        saab.move();
        assertEquals(0.1, saab.getY());
    }
    @Test
    public void TestXCoordinate() {
        saab.startEngine();
        saab.turnRight();
        saab.move();
        assertEquals(0.1, saab.getX());
    }
    @Test
    public void TestTurnRight() {
        saab.startEngine();
        saab.turnRight();
        saab.move();
        saab.turnRight();
        saab.move();
        saab.turnRight();
        saab.move();
        saab.turnRight();
        saab.move();
        assertEquals(Directions.UP, saab.getDirection());
    }

    /**
     * Testing to turn 90 degrees to the left for a car.
     */
    @Test
    public void TestTurnLeft() {
        saab.startEngine();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(Directions.DOWN, saab.getDirection());
    }

    /**
     * Testing to set a new color for a car.
     */
    @Test
    public void TestSetColor() {
        saab.setColor(Color.PINK);
        assertEquals(Color.PINK, saab.getColor());
    }
    /**
     * Testing Saab gas with a valid amount (double).
     */
    @Test
    public void TestSaabGasWithValidAmount() {
        saab.startEngine();
        saab.gas(0.5);
        assertEquals(0.725, saab.getCurrentSpeed());
    }
    /**
     * Testing Saab gas with an in invalid amount (double).
     */
    @Test
    public void TestSaabGasWithInvalidAmount() {
        saab.startEngine();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> saab.gas(1.2));
        assertEquals("Please enter a gas amount between 0 and 1", exception.getMessage());
    }

    /**
     * Testing to brake a Saab with a valid amount (double).
     */
    @Test
    public void TestSaabBrakeWithValidAmount() {
        saab.startEngine();
        saab.brake(0.5);
        assertEquals(0, saab.getCurrentSpeed());
    }

    /**
     * Testing to brake a Saab with an invalid amount (double).
     */
    @Test
    public void TestSaabBrakeWithInvalidAmount() {
        saab.startEngine();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> saab.brake(-0.3));
        assertEquals("Please enter a brake amount between 0 and 1", exception.getMessage());
    }

    /**
     * Testing Volvo gas with a valid amount (double).
     */
    @Test
    public void TestVolvoGasWithValidAmount() {
        volvo.startEngine();
        volvo.gas(0.95);
        assertEquals(1.2875, volvo.getCurrentSpeed());
    }

    /**
     * Testing to brake a Volvo with a valid amount (double).
     */
    @Test
    public void TestVolvoBrakeWithValidAmount() {
        volvo.startEngine();
        volvo.brake(0.1);
        assertEquals(0, volvo.getCurrentSpeed());
    }
}