package designpattern.observerpattern.subject;

import designpattern.observerpattern.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class LocationUpdate implements ISubject {
    private final List<IObserver> observers;

    public LocationUpdate() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stateChange) {
        observers.forEach(obs -> obs.update(stateChange));
    }
}
