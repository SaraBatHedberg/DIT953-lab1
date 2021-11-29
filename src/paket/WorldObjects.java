package paket;

/**
 * Class that gives it's instances a location.
 */
public abstract class WorldObjects {
    /**
     * The instance's X coordinate
     */
    protected double x;
    /**
     * The instance's Y coordinate
     */
    protected double y;

    /**
     * Gets X and Y coordinates
     * @return List
     */
    public double[] getLocation() {
        return new double[]{x, y};
    }
}
