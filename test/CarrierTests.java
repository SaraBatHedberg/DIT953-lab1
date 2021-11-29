import paket.car.Carrier;
import paket.car.Saab95;
import paket.car.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
/**
 * A class for JUnit tests for the carrier class.
 */
public class CarrierTests {
    Carrier carrier;
    Volvo240 testcar;
    private final ByteArrayOutputStream PrintedMessageCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        carrier = new Carrier("ABC001");
        testcar = new Volvo240("ABC002");
    }

    @Test
    public void TestRaiseRamp() {
        carrier.raiseRamp();
        assertEquals("Ramp is currently up", carrier.getRampStatus());
    }

    @Test
    public void TestLowerRamp() {
        carrier.lowerRamp();
        assertEquals("Ramp is currently down", carrier.getRampStatus());
    }

    @Test
    public void TestLoadCar() {
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        assertTrue(testcar.isLoaded());
    }

    @Test
    public void TestMove() {
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        carrier.startEngine();
        carrier.gas(0.5);
        carrier.move();
        assertEquals(0.4, carrier.getLocation()[1]);
        assertEquals(0.0, carrier.getLocation()[0]);
        assertEquals(0.4, testcar.getLocation()[1]);
        assertEquals(0.0, testcar.getLocation()[0]);
    }

    @Test
    public void TestGetRampStatus() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.raiseRamp();
        System.out.println(carrier.getRampStatus());
        carrier.lowerRamp();
        System.out.println(carrier.getRampStatus());
        assertEquals("Ramp is currently up\n" + "Ramp is currently down", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestUnloadCar() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        carrier.unloadCar();
        assertEquals("Successfully loaded paket.car\n" + "Successfully unloaded paket.car", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestUnloadCarInvalid() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.unloadCar();
        assertEquals("Cannot unload a car when the carrier is empty", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestLoadCarInvalidRamp() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        carrier.raiseRamp();
        carrier.unloadCar();
        assertEquals("Successfully loaded car\n" + "Please lower the ramp before attempting to unload a car", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestUnloadCarInvalidRamp() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        carrier.raiseRamp();
        carrier.unloadCar();
        assertEquals("Successfully loaded car\n" + "Please lower the ramp before attempting to unload a car", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestLoadCarrierWithCarrier() {
        System.setOut(new PrintStream(PrintedMessageCaptor));
        Carrier loadCarrier = new Carrier("HEJ555");
        carrier.lowerRamp();
        carrier.loadCar(loadCarrier);
        assertEquals("Cannot load a carrier onto a carrier", PrintedMessageCaptor.toString().trim());
    }


    @Test
    public void TestIsLoaded() {
        Volvo240 volvo = new Volvo240("ABC521");
        carrier.lowerRamp();
        carrier.loadCar(volvo);
        assertTrue(volvo.isLoaded());
    }

    @Test
    public void TestGetLoadedCars() {
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        assertEquals(1, carrier.getLoadedCars().size());
    }

    @Test
    public void TestBrake (){
        carrier.startEngine();
        carrier.gas(0.9);
        carrier.brake(0.9);
        assertEquals(0, carrier.getCurrentSpeed());
    }

    @Test
    public void TestProximity (){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        testcar.startEngine();
        for (int i = 0; i < 10; i++) {
        testcar.gas(1);}
        testcar.turnLeft();
        for (int i = 0; i < 10; i++) {
        testcar.move();}
        testcar.turnLeft();
        for (int i = 0; i < 10; i++) {
        testcar.move();}
        carrier.lowerRamp();
        carrier.loadCar(testcar);
        assertEquals("Please drive closer before loading a paket.car onto the carrier", PrintedMessageCaptor.toString().trim());
    }


    @Test
    public void TestRaiseRampWhileMoving(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.startEngine();
        carrier.lowerRamp();
        carrier.gas(1);
        carrier.move();
        carrier.raiseRamp();
        assertEquals("*pip sound* Please ensure carrier is stationary before raising the ramp", PrintedMessageCaptor.toString().trim());
    }
    @Test
    public void TestLowerRampWhileMoving(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.startEngine();
        carrier.gas(1);
        carrier.move();
        carrier.lowerRamp();
        assertEquals("*pip sound* Please ensure carrier is stationary before lowering the ramp", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestLoadCarWithRaisedRamp(){
        System.setOut(new PrintStream(PrintedMessageCaptor));
        carrier.loadCar(testcar);
        assertEquals("Please lower the ramp before attempting to load a paket.car", PrintedMessageCaptor.toString().trim());
    }

    @Test
    public void TestCarrierUnloadDifferentDirections() {
        Saab95 saab1 = new Saab95("ABC111");
        Saab95 saab2 = new Saab95("ABC111");
        carrier.lowerRamp();
        carrier.loadCar(saab1);
        carrier.loadCar(saab2);
        carrier.loadCar(testcar);
        for (int i = 0; i < 3; i++) {
            carrier.turnLeft();
            carrier.unloadCar();
        }
        assertEquals(-1, saab1.getLocation()[0]);
        assertEquals(0, saab1.getLocation()[1]);
        assertEquals(0, saab2.getLocation()[0]);
        assertEquals(1, saab2.getLocation()[1]);
        assertEquals(1, testcar.getLocation()[0]);
        assertEquals(0, testcar.getLocation()[1]);
    }
}