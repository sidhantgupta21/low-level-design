package designpattern.factory;

public class Bike implements Vehicle {

    public Bike() {
        System.out.println("creating bike");
    }

    @Override
    public void run() {
        System.out.println("Bike is running");
    }
}
