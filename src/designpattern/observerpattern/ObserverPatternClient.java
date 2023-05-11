package designpattern.observerpattern;

import designpattern.observerpattern.observer.EmailNotifier;
import designpattern.observerpattern.observer.IObserver;
import designpattern.observerpattern.observer.PushNotifier;
import designpattern.observerpattern.observer.SmsNotifier;
import designpattern.observerpattern.subject.LocationUpdate;
import designpattern.observerpattern.subject.StatusUpdate;
import designpattern.observerpattern.subject.ISubject;

public class ObserverPatternClient {

    public static void main(String[] args) {
        IObserver emailNotifier = new EmailNotifier();
        IObserver smsNotifier = new SmsNotifier();
        IObserver pushNotifier = new PushNotifier();

        ISubject locationUpdate = new LocationUpdate();
        locationUpdate.subscribe(emailNotifier);
        locationUpdate.subscribe(pushNotifier);

        ISubject statusUpdate = new StatusUpdate();
        statusUpdate.subscribe(smsNotifier);
        statusUpdate.subscribe(pushNotifier);


        locationUpdate.notifyObservers("Location Update : Driver left warehouse!!");
        statusUpdate.notifyObservers("Status Update : SHIPPED");

        locationUpdate.unSubscribe(pushNotifier);

        locationUpdate.notifyObservers("Location Update : Driver at customer location!!");
        statusUpdate.notifyObservers("Status Update : DELIVERED");


    }
}
