package paket.car;

public interface ISubscriber {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void updateObservers();
}
