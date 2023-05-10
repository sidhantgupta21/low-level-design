package designpattern.abstractfactory.vehicle.toyota;

import designpattern.abstractfactory.vehicle.IHeadlight;

class ToyotaHeadlight implements IHeadlight {

    @Override
    public void install() {
        System.out.println("Installing Toyota Headlights!!");
    }
}
