import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Testing {
    Car saab;
    Car volvo;

    @BeforeEach
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }
    @Test
    public void TestSaabNrDoors() {
        assertEquals(2, saab.getNrDoors());
    }
    @Test
    public void TestSaabEnginePower() {
        assertEquals(125, saab.getEnginePower());
    }
    @Test
    public void TestSaabCurrentSpeed() {
        assertEquals(0, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabColor() {
        assertEquals(Color.red, saab.getColor());
    }
    @Test
    public void TestSaabIncrementSpeed() {
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabDecrementSpeed() {
        saab.decrementSpeed(1);
        assertEquals(-1.25, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        assertEquals(1.625, saab.getCurrentSpeed());
    }
    @Test
    public void TestSaabTurboOn2() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.decrementSpeed(1);
        assertEquals(-1.625, saab.getCurrentSpeed());
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
        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    public void TestVolvoEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }
    @Test
    public void TestVolvoCurrentSpeed() {
        assertEquals(0, volvo.getCurrentSpeed());
    }
    @Test
    public void TestVolvoColor() {
        assertEquals(Color.black, volvo.getColor());
    }
    @Test
    public void TestVolvoIncrementSpeed() {
        volvo.incrementSpeed(1);
        assertEquals(1.25, volvo.getCurrentSpeed());
    }
    @Test
    public void TestVolvoDecSpeed() {
        volvo.decrementSpeed(1);
        assertEquals(0, volvo.getCurrentSpeed());
    }
    @Test
    public void TestMove() {
        saab.startEngine();
        saab.move();
        assertEquals(0.1, saab.y);
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
    @Test
    public void TestTurnLeft() {
        saab.startEngine();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(Directions.DOWN, saab.getDirection());
    }
    @Test
    public void TestSetColor() {
        saab.setColor(Color.PINK);
        assertEquals(Color.PINK, saab.getColor());
    }

    @Test
    public void TestGas() {
        saab.startEngine();
        saab.move();
        saab.gas(0.5);
        assertEquals(1.35, saab.getCurrentSpeed());
    }
    @Test
    public void TestBrake() {
        saab.startEngine();
        saab.move();
        saab.brake(0.5);
        assertEquals(-0.525, saab.getCurrentSpeed());
    }
}
