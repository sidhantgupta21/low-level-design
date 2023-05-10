package designpattern.abstractfactory.vehicle;

import designpattern.abstractfactory.vehicle.hyundai.HyundaiFactory;
import designpattern.abstractfactory.vehicle.toyota.ToyotaFactory;

public class VehicleAbstractFactory {

    private VehicleAbstractFactory() { }

    public static IAutomobile getVehicleFactory(String company) {
        if (company.equals("hyundai")) {
            return new HyundaiFactory();
        }
        return new ToyotaFactory();
    }

}
