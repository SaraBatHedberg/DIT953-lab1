import paket.Workshop;
import paket.car.Car;
import paket.car.Carrier;
import paket.car.Saab95;
import paket.car.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestWorkshop {

    Workshop<Car> generalWorkshop;
    Workshop<Volvo240> volvo240Workshop;
    Volvo240 testcar;
    private final ByteArrayOutputStream PrintedMessageCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        testcar = new Volvo240("ABC002");
        generalWorkshop = new Workshop(3, 3, 10, "GeneralWorkshop");
        volvo240Workshop = new Workshop(20, 20, 3, "VolvoWorkshop");

    }
    @Test
    public void TestRecieveCarNotProximity() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        testcar.startEngine();
        for (int i = 0; i < 100; i++) {
            testcar.gas(1);
            testcar.move();
        }
        generalWorkshop.receiveCar(testcar);
        assertEquals("Please drive closer before attempting to enter the workshop", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestReceiveCar(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        generalWorkshop.receiveCar(testcar);
        assertEquals("Car received", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestRetrieveCar(){
        generalWorkshop.receiveCar(testcar);
        generalWorkshop.retrieveCar(testcar);
        assertFalse(testcar.isLoaded());
    }

    @Test
    public void TestRetrieveCarThatIsNotInWorkshop(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        generalWorkshop.retrieveCar(testcar);
        assertEquals(testcar.getLicensePlate() + " is not in this workshop", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestRepair(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        generalWorkshop.repair(testcar);
        assertEquals("Car " + testcar.getLicensePlate() + " repaired", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestReceiveCarWhenFull(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Workshop<Car> miniworkshop = new Workshop<Car>(0, 0, 1, "MiniWorkshop");
        Car volvo = new Volvo240("xxx999");
        miniworkshop.receiveCar(volvo);
        miniworkshop.receiveCar(testcar);
        assertEquals("Car received\n" + "This workshop is currently full", PrintedMessageCaptor.toString().trim());
    }





    }

