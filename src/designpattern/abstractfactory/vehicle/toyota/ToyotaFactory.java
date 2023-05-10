package designpattern.abstractfactory.vehicle.toyota;

import designpattern.abstractfactory.vehicle.IAutomobile;
import designpattern.abstractfactory.vehicle.IHeadlight;
import designpattern.abstractfactory.vehicle.ILogo;
import designpattern.abstractfactory.vehicle.ISeat;

public class ToyotaFactory implements IAutomobile {

    @Override
    public IHeadlight getHeadlight() {
        return new ToyotaHeadlight();
    }

    @Override
    public ILogo getLogo() {
        return new ToyotaLogo();
    }

    @Override
    public ISeat getSeat() {
        return new ToyotaSeat();
    }
}
