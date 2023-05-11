package designpattern.observerpattern.subject;

import designpattern.observerpattern.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class StatusUpdate implements ISubject {

    private final List<IObserver> observers;

    public StatusUpdate() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unSubscribe(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stateChange) {
        observers.forEach(obs -> obs.update(stateChange));
    }
}
