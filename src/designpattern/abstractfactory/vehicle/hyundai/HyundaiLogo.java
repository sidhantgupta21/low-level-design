package designpattern.abstractfactory.vehicle.hyundai;

import designpattern.abstractfactory.vehicle.ILogo;

class HyundaiLogo implements ILogo {

    @Override
    public void install() {
        System.out.println("Installing Hyundai LOGO!!");
    }
}
