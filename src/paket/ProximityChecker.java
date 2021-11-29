package paket;

/**
 * Helper class for objects that need to measure a distance between itself and another object
 */
public class ProximityChecker {
    public boolean CheckProximity (WorldObjects one, WorldObjects two){
        double xFirst = one.getLocation()[0];
        double yFirst = one.getLocation()[1];
        double xSecond = two.getLocation()[0];
        double ySecond = two.getLocation()[1];
        return (((xFirst - xSecond <= 3)
                && (xFirst - xSecond >= -3))
                && (((yFirst - ySecond <= 3)
                && (yFirst - ySecond >= -3))));
    }

}
