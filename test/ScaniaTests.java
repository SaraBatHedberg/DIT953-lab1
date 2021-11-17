import car.Car;
import car.Scania;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScaniaTests {

    Scania Truck;
    //private final PrintStream PrintedMessage = System.out;
    private final ByteArrayOutputStream PrintedMessageCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        Truck = new Scania();
    }

    @Test
    public void TestRaisePlatform() {
        Truck.raisePlatform(45);
        assertEquals(45, Truck.getAngle());
    }

    @Test
    public void TestLowerPlatform() {
        Truck.raisePlatform(70);
        Truck.lowerPlatform(30);
        assertEquals(40, Truck.getAngle());
    }
    @Test
    public void TestScaniaGasValid() {
        Truck.startEngine();
        Truck.gas(0.5);
        assertEquals(0.5, Truck.getCurrentSpeed());
    }

    @Test
    public void TestScaniaGasInvalid() {
        Truck.startEngine();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Truck.gas(1.2));
        assertEquals("Please enter a gas amount between 0 and 1", exception.getMessage());
    }

    @Test
    public void TestScaniaGasWhileRaisedPlatform() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(45);
        Truck.startEngine();
        Truck.gas(1);
        assertEquals("Please ensure platform is lowered to 0 degrees before accelerating", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestScaniaRaisePlatformUnderSpeed() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.startEngine();
        Truck.raisePlatform(45);
        assertEquals("*pip sound* Please ensure truck is stationary before moving the platform", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestScaniaLowerPlatformUnderSpeed() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(70);
        Truck.startEngine();
        Truck.raisePlatform(30);
        assertEquals("*pip sound* Please ensure truck is stationary before moving the platform", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestScaniaMoveWithRaisedPlatform() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Truck.raisePlatform(45);
        Truck.startEngine();
        Truck.move();
        assertEquals("Please lower the platform before moving, then gas to gain speed", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestScaniaBrake() {
        Truck.startEngine();
        Truck.brake(0.9);
        assertEquals(0, Truck.getCurrentSpeed());
    }

}
