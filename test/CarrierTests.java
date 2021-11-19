import car.Car;
import car.Carrier;
import car.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrierTests {
    Carrier carrier;
    Volvo240 testcar;

    @BeforeEach
    public void init() {
        carrier = new Carrier();
        testcar = new Volvo240();
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
        carrier.loadCar(testcar);
        assertTrue(testcar.isLoaded());
    }
    /*
    raiseRamp;
    lowerRamp;
    loadCar;
    move;
    unloadCar;
    */
}
