import static java.lang.System.*;

public class Main {
    public static void main(String [] args) {
        Car MyCar = new Volvo240();
        out.println(MyCar.getColor());

        MyCar.startEngine();
        out.println(MyCar.getCurrentSpeed());
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        out.println(MyCar.x+" "+MyCar.y);
        MyCar.turnRight();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        MyCar.move();
        out.println(MyCar.getX()+" "+MyCar.getY());

    }
}