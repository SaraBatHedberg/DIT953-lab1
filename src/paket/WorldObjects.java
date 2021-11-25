package paket;


public abstract class WorldObjects {
    private double x;
    private double y;

    public double[] getLocation() {
        return new double[]{x, y};
    }
}
