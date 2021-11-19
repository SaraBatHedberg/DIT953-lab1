package car;

/**
 * This is an interface that is implemented to allow an object to move and turn.
 */
public interface Movable {
    /**
     * Allows an object to move.
     */
    void move();
    /**
     * Allows an object to turn to the left.
     */
    void turnLeft();
    void turnRight();
}
