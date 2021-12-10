package paket.car;

import java.util.ArrayList;
import java.util.List;

public class CarModel implements ISubscriber{
    List<Observer> observers;

    public CarModel(){
        observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateObservers() {
        for (Observer observer: observers){
            observer.update();
        }
    }
}

