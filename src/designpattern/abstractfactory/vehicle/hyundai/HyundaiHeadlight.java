package designpattern.abstractfactory.vehicle.hyundai;

import designpattern.abstractfactory.vehicle.IHeadlight;

class HyundaiHeadlight implements IHeadlight {

    @Override
    public void install() {
        System.out.println("Installing Hyundai Headlights!!");
    }
}
