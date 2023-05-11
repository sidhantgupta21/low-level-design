package designpattern.observerpattern.observer;

public class PushNotifier implements IObserver {

    @Override
    public void update(String state) {
        System.out.println("Push Notification :: " + state);
    }
}
