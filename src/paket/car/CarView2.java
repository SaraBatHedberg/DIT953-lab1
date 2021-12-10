package paket.car;

public class CarView2 {
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn (){
        for (Car car : cars){
            if (checkIfCarSaab(car)){
                ((Saab95) car).setTurboOn();
                System.out.println("Turbo on");
            }
        }
    }

    void turboOff (){
        for (Car car : cars){
            if (checkIfCarSaab(car)){
                ((Saab95) car).setTurboOff();
                System.out.println("Turbo Off");
            }
        }
    }

    void liftBed(int amount) {
        for (Car car : cars) {
            if (checkIfCarScania(car)) {
                ((Scania) car).raisePlatform(amount);
                System.out.println("Lifted bed " + amount + " degrees");
            }
        }
    }

    void lowerBed (int amount) {
        for (Car car : cars) {
            if (checkIfCarScania(car)) {
                ((Scania) car).lowerPlatform(amount);
                System.out.println("Lowered bed " + amount + " degrees");
            }
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    private boolean checkIfCarSaab(Car car){
        return car.getClass() == Saab95.class;
    }

    private boolean checkIfCarScania(Car car){
        return car.getClass() == Scania.class;
    }
}

}
