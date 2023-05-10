package designpattern.abstractfactory.vehicle.hyundai;

import designpattern.abstractfactory.vehicle.ISeat;

class HyundaiSeat implements ISeat {

    @Override
    public void install() {
        System.out.println("Installing Hyundai Seat!!");
    }
}
