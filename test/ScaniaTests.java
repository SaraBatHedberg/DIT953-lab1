import car.Car;
import car.Scania;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A class for JUnit tests using Scania classes.
 */
public class ScaniaTests {

    Scania Truck;

    private final ByteArrayOutputStream PrintedMessageCaptor = new ByteArrayOutputStream();

    /**
     * Creates a new Scania every test.
     */
    @BeforeEach
    public void init() {
        Truck = new Scania("ABC555");
    }

    /**
     * Testing methods to raise and lower platform.
     */
    @Test
    public void TestLowerAndRaisePlatform() {
        Truck.startEngine();
        Truck.raisePlatform(70);
        Truck.lowerPlatform(30);
        assertEquals(40, Truck.getAngle());
    }

    /**
     * Testing the gas function with valid amount (double)
     */
    @Test
    public void TestScaniaGasValid() {
        Truck.startEngine();
        Truck.gas(0.5);
        assertEquals(0.4, Truck.getCurrentSpeed());
    }

    /**
     * Testing the gas with invalid amount (double).
     */
    @Test
    public void TestScaniaGasInvalid() {
        Truck.startEngine();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Truck.gas(1.2));
        assertEquals("Please enter a gas amount between 0 and 1", exception.getMessage());
    }

    /**
     * Testing the gas while the platform's angle != 0.
     */
    @Test
    public void TestScaniaGasWhileRaisedPlatform() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(45);
        Truck.startEngine();
        Truck.gas(1);
        assertEquals("Please ensure the platform is lowered and the engine turned on, then gas to gain speed"
                , PrintedMessageCaptor.toString().trim());
    }

    /**
     * Testing to raise the platform while vehicle has speed greater than 0.
     */
    @Test
    public void TestScaniaRaisePlatformUnderSpeed() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.startEngine();
        Truck.gas(1);
        Truck.move();
        Truck.raisePlatform(45);
        assertEquals("*pip sound* Please ensure truck is stationary before moving the platform"
                , PrintedMessageCaptor.toString().trim());
    }

    /**
     * Testing to lower the platform while vehicle has speed greater than 0.
     */
    @Test
    public void TestScaniaLowerPlatformUnderSpeed() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(70);
        Truck.startEngine();
        Truck.lowerPlatform(30);
        assertEquals("*pip sound* Please ensure truck is stationary before moving the platform"
                , PrintedMessageCaptor.toString().trim());
    }

    /**
     * Testing move while the platform's angle != 0.
     */
    @Test
    public void TestScaniaMoveWithRaisedPlatform() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(45);
        Truck.startEngine();
        Truck.move();
        assertEquals("*pip sound* Please ensure truck is stationary before moving the platform"
                , PrintedMessageCaptor.toString().trim());
    }

    /**
     * Testing to move the vehicle.
     */
    @Test
    public void TestScaniaMove() {
        Truck.startEngine();
        Truck.gas(0.5);
        Truck.move();
        assertEquals(0.4, Truck.getY());
    }

    /**
     * Testing to brake the vehicle.
     */
    @Test
    public void TestScaniaBrake() {
        Truck.startEngine();
        Truck.brake(0.9);
        assertEquals(0, Truck.getCurrentSpeed());
    }
    /**
     * Testing gas with engine turned off.
     */
    @Test
    public void TestScaniaGasEngineOff() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.gas(1);
        assertEquals("Please ensure platform is lowered and the engine turned on before accelerating", PrintedMessageCaptor.toString().trim());
    }
}
