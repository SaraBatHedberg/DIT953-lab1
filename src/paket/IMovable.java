package paket;

/**
 * This is an interface that is implemented to allow an object to move and turn.
 */
public interface IMovable {
    /**
     * Allows an object to move.
     */
    void move();
    /**
     * Allows an object to turn to the left.
     */
    void turnLeft();

    /**
     * Allows an object to turn to the right.
     */
    void turnRight();
}
