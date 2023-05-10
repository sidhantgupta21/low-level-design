package designpattern.abstractfactory.vehicle.toyota;

import designpattern.abstractfactory.vehicle.ILogo;

class ToyotaLogo implements ILogo {

    @Override
    public void install() {
        System.out.println("Installing Toyota LOGO!!");
    }
}
