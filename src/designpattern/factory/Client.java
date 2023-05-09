package designpattern.factory;

public class Client {

    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("car");
        vehicle.run();
    }
}
