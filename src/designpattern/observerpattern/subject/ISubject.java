package designpattern.observerpattern.subject;

import designpattern.observerpattern.observer.IObserver;

public interface ISubject {

    void subscribe(IObserver observer);
    void unSubscribe(IObserver observer);
    void notifyObservers(String stateChange);
}
