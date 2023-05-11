package designpattern.builder;

public class BuilderClient {

    public static void main(String[] args) {

        Vehicle car = new Vehicle.VehicleBuilder("crdi", 4)
                                        .withAirbags(6)
                                        .withAutomatic(true)
                                        .build();

        System.out.println(car.toString());

        Vehicle bike = new Vehicle.VehicleBuilder("150c DTSI", 2)
                                    .build();
        System.out.println(bike.toString());

    }
}
