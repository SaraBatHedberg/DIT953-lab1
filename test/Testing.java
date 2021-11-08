import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Testing {
    @Test
    public void TestSaab1() {
        Car saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }
    @Test
    public void TestSaab2() {
        Car saab = new Saab95();
        assertEquals(125, saab.getEnginePower());
    }
    @Test
    public void TestSaab3() {
        Car saab = new Saab95();
        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaab4() {
        Car saab = new Saab95();
        assertEquals(Color.red, saab.getColor());
    }
    @Test
    public void TestSaab5() {
        Car saab = new Saab95();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.currentSpeed);
    }
    @Test
    public void TestSaab6() {
        Car saab = new Saab95();
        saab.decrementSpeed(1);
        assertEquals(-1.25, saab.currentSpeed);
    }
    @Test
    public void TestSaab7() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        assertEquals(1.625, saab.currentSpeed);
    }
    @Test
    public void TestSaab8() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.decrementSpeed(1);
        assertEquals(-1.625, saab.currentSpeed);
    }
    @Test
    public void TestSaab9() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    } 
    @Test
    public void TestVolvo1() {
        Car saab = new Volvo240();
        assertEquals(4, saab.getNrDoors());
    }
    @Test
    public void TestVolvo2() {
        Car saab = new Volvo240();
        assertEquals(100, saab.getEnginePower());
    }
    @Test
    public void TestVolvo3() {
        Car saab = new Volvo240();
        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestVolvo4() {
        Car saab = new Volvo240();
        assertEquals(Color.black, saab.getColor());
    }
    @Test
    public void TestVolvo5() {
        Car saab = new Volvo240();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.currentSpeed);
    }
    @Test
    public void TestVolvo6() {
        Car saab = new Volvo240();
        saab.decrementSpeed(1);
        assertEquals(-1.25, saab.currentSpeed);
    }

}
