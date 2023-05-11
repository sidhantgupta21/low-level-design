package designpattern.observerpattern.observer;

public class SmsNotifier implements IObserver {

    @Override
    public void update(String state) {
        System.out.println("SMS Notification :: " + state);
    }
}
