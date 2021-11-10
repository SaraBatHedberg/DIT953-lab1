import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Testing {
    @Test
    public void TestSaabNrDoors() {
        Car saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }
    @Test
    public void TestSaabEnginePower() {
        Car saab = new Saab95();
        assertEquals(125, saab.getEnginePower());
    }
    @Test
    public void TestSaabCurrentSpeed() {
        Car saab = new Saab95();
        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabColor() {
        Car saab = new Saab95();
        assertEquals(Color.red, saab.getColor());
    }
    @Test
    public void TestSaabIncrementSpeed() {
        Car saab = new Saab95();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.currentSpeed);
    }
    @Test
    public void TestSaabDecrementSpeed() {
        Car saab = new Saab95();
        saab.decrementSpeed(1);
        assertEquals(-1.25, saab.currentSpeed);
    }
    @Test
    public void TestSaabTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        assertEquals(1.625, saab.currentSpeed);
    }
    @Test
    public void TestSaabTurboOn2() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.decrementSpeed(1);
        assertEquals(-1.625, saab.currentSpeed);
    }
    @Test
    public void TestSaabTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    } 
    @Test
    public void TestVolvoObject() {
        Car saab = new Volvo240();
        assertEquals(4, saab.getNrDoors());
    }
    @Test
    public void TestVolvoEnginePower() {
        Car saab = new Volvo240();
        assertEquals(100, saab.getEnginePower());
    }
    @Test
    public void TestVolvoCurrentSpeed() {
        Car saab = new Volvo240();
        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestVolvoColor() {
        Car saab = new Volvo240();
        assertEquals(Color.black, saab.getColor());
    }
    @Test
    public void TestVolvoIncrementSpeed() {
        Car saab = new Volvo240();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.currentSpeed);
    }
    @Test
    public void TestVolvoDecSpeed() {
        Car saab = new Volvo240();
        saab.decrementSpeed(1);
        assertEquals(0, saab.currentSpeed);
    }
    @Test
    public void TestMove() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.move();
        assertEquals(0.1, saab.y);
    }
    @Test
    public void TestTurnRight() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(Directions.UP, saab.getDirection());
    }
    @Test
    public void TestTurnLeft() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(Directions.DOWN, saab.getDirection());
    }
    @Test
    public void TestSetColor() {
        Car saab = new Saab95();
        saab.setColor(Color.PINK);
        assertEquals(Color.PINK, saab.getColor());
    }

    @Test
    public void TestGas() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.move();
        saab.gas(0.5);
        assertEquals(1.35, saab.getCurrentSpeed());
    }
    @Test
    public void TestBrake() {
        Car saab = new Saab95();
        saab.startEngine();
        saab.move();
        saab.brake(0.5);
        assertEquals(-0.525, saab.getCurrentSpeed());
    }


}
