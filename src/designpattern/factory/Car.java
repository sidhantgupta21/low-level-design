package designpattern.factory;

public class Car implements Vehicle {

    public Car() {
        System.out.println("creating car");
    }

    @Override
    public void run() {
        System.out.println("Car is running");
    }
}
