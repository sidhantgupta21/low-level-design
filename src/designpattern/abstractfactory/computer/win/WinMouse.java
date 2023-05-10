package designpattern.abstractfactory.computer.win;

import designpattern.abstractfactory.computer.IMouse;

public class WinMouse implements IMouse {

    @Override
    public void installMouse() {
        System.out.println("Win Mouse Installed!!!");
    }
}
