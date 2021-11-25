import paket.car.Car;
import paket.Directions;
import paket.car.Saab95;
import paket.car.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for JUnit tests using Volvo240 and Saab95 classes. Also tests the class Car using those
 */
public class VolvoAndSaabTests {
    Car saab;
    Car volvo;

    private final ByteArrayOutputStream PrintedMessageCaptor = new ByteArrayOutputStream();

    /**
     * creates a new Saab95 and a new Volvo240 for each test.
     */
    @BeforeEach
    public void init() {
        saab = new Saab95("ABC123");
        volvo = new Volvo240("AAA111");
    }

    /**
     * Tests the code getNrDoors from Car using a Saab95.
     */
    @Test
    public void TestSaabGetNrDoors() {

        assertEquals(2, saab.getNrDoors());
    }

    /**
     * Tests the code GetEnginePower from Car using a Saab95.
     */
    @Test
    public void TestSaabGetEnginePower() {

        assertEquals(125, saab.getEnginePower());
    }
    /**
     * Tests the code GetCurrentSpeed from Car using a Saab95.
     */
    @Test
    public void TestSaabGetCurrentSpeed() {

        assertEquals(0, saab.getCurrentSpeed());
    }
    /**
     * Tests the code GetColor from Car using a Saab95.
     */
    @Test
    public void TestSaabGetColor() {

        assertEquals(Color.red, saab.getColor());
    }
    /**
     * Tests the code SetTurboOff from Saab95 using a Saab95.
     */
    @Test
    public void TestSaabSetTurboOff() {
        Saab95 saab = new Saab95("ABC122");
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }
    /**
     * Tests the code GetNrDoors from Car using a Volvo240.
     */
    @Test
    public void TestVolvoGetNrDoors() {

        assertEquals(4, volvo.getNrDoors());
    }
    /**
     * Tests the code getEnginePower from Car using a Volvo240.
     */
    @Test
    public void TestVolvoGetEnginePower() {

        assertEquals(100, volvo.getEnginePower());
    }
    /**
     * Tests the code GetCurrentSpeed from Car using a Volvo240.
     */
    @Test
    public void TestVolvoGetCurrentSpeed() {

        assertEquals(0, volvo.getCurrentSpeed());
    }
    /**
     * Tests the code GetColor from Car using a Volvo240.
     */
    @Test
    public void TestVolvoGetColor() {

        assertEquals(Color.black, volvo.getColor());
    }
    /**
     * Tests the code GetY, StartEngine and move from Car using a Saab95.
     */
    @Test
    public void TestYCoordinate() {
        saab.startEngine();
        saab.gas(0.5);
        saab.move();
        assertEquals(0.625, saab.getLocation()[1]);
    }
    /**
     * Tests the code GetX, StartEngine, TurnRight and move from Car using a Saab95.
     */
    @Test
    public void TestXCoordinate() {
        saab.startEngine();
        saab.gas(0.5);
        saab.turnRight();
        saab.move();
        assertEquals(0.625, saab.getLocation()[0]);
    }

    /**
     * Testing to turn 90 degrees to the right for a paket.car and to check if the list of directions is looped through.
     */
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
     * Testing to turn 90 degrees to the left for a paket.car.
     */
    @Test
    public void TestTurnLeft() {
        saab.startEngine();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(Directions.DOWN, saab.getDirection());
    }

    /**
     * Testing to set a new color for a paket.car.
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
        assertEquals(0.625, saab.getCurrentSpeed());
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
        assertEquals(1.1875, volvo.getCurrentSpeed());
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

    @Test
    public void TestStopEngineWithSpeed() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        volvo.startEngine();
        volvo.gas(1);
        volvo.stopEngine();
        assertEquals("Brake before stopping the engine", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestGasEngineOff() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        volvo.gas(1);
        assertEquals("*Car's engine is turned off*", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestBrakeEngineOff() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        volvo.brake(1);
        assertEquals("*Car's engine is turned off*", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestMoveEngineOff() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        volvo.move();
        assertEquals("Cannot move with engine turned off", PrintedMessageCaptor.toString().trim());
    }
}