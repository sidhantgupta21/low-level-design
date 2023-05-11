package designpattern.observerpattern.observer;

public class EmailNotifier implements IObserver {

    @Override
    public void update(String state) {
        System.out.println("Email Notification :: " + state);
    }
}
