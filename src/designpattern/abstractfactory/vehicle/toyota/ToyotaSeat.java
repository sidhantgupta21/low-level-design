package designpattern.abstractfactory.vehicle.toyota;

import designpattern.abstractfactory.vehicle.ISeat;

class ToyotaSeat implements ISeat {

    @Override
    public void install() {
        System.out.println("Installing Toyota Seat!!");
    }
}
