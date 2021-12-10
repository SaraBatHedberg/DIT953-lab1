package paket.car;


public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();


        // Could create a factory instead
        model.cars.add(new Volvo240("ABC123"));
        model.cars.add(new Saab95("SAB123"));
        model.cars.add(new Scania("XXX999"));
        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", model);

        CarController controller = new CarController(model, view.CPanel);
        controller.init();

        model.timer.start();
    }
}
