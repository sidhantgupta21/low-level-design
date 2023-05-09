package designpattern.factory;

public class VehicleFactory {

    private VehicleFactory() { }

    public static Vehicle getVehicle(String vehicleType) {
        Vehicle vehicle = null;
        if (vehicleType == null || vehicleType.length() == 0) {
            return vehicle;
        }
        if (vehicleType.equals("car")) {
            vehicle = new Car();
        }
        if (vehicleType.equals("bike")) {
            vehicle = new Bike();
        }
        return vehicle;
    }
}
