package designpattern.abstractfactory.vehicle;

public class VehicleClient {

    public static void main(String[] args) {

        IAutomobile automobile = VehicleAbstractFactory.getVehicleFactory("hyundai");

        IHeadlight headlight = automobile.getHeadlight();
        headlight.install();

        ILogo logo = automobile.getLogo();
        logo.install();

        ISeat seat = automobile.getSeat();
        seat.install();

    }
}
