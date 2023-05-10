package designpattern.abstractfactory.computer;

import designpattern.abstractfactory.computer.mac.MacFactory;
import designpattern.abstractfactory.computer.win.WinFactory;

public class ComputerAbstractFactory {

    private ComputerAbstractFactory() { }

    public static IComputer getComputerFactory(String osType) {
        if (osType.equals("mac")) {
            return new MacFactory();
        }
        return new WinFactory();
    }
}
