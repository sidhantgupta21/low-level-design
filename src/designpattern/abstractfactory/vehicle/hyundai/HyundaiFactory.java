package designpattern.abstractfactory.vehicle.hyundai;

import designpattern.abstractfactory.vehicle.IAutomobile;
import designpattern.abstractfactory.vehicle.IHeadlight;
import designpattern.abstractfactory.vehicle.ILogo;
import designpattern.abstractfactory.vehicle.ISeat;

public class HyundaiFactory implements IAutomobile {

    @Override
    public IHeadlight getHeadlight() {
        return new HyundaiHeadlight();
    }

    @Override
    public ILogo getLogo() {
        return new HyundaiLogo();
    }

    @Override
    public ISeat getSeat() {
        return new HyundaiSeat();
    }
}
