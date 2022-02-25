package ex1;

public interface IObservable {
    void addObserver(IObserver observer);
    void delObserver(IObserver observer);
    void notifyObservers(String message);
}
