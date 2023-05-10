package designpattern.abstractfactory.computer.mac;

import designpattern.abstractfactory.computer.IMouse;

public class MacMouse implements IMouse {

    @Override
    public void installMouse() {
        System.out.println("Mac Mouse Installed!!!");
    }
}
