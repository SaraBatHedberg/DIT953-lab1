package car;

public class ProximityChecker {
    public boolean CheckProximity (ICoordinates one, Car two){
        return (((one.getX() - two.getX() <= 3)
                && (one.getX() - two.getX() >= -3))
                && (((one.getY() - two.getY() <= 3)
                && (one.getY() - two.getY() >= -3))));
    }

}
