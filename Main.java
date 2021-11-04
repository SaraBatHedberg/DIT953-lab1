import static java.lang.System.*;


public class Main {
    public static void main(String[] args){
        Saab95 newSaab = new Saab95();
        out.println(newSaab.speedFactor());
        Car myCar = new Car();
        out.println(myCar.getColor());
    }
}
