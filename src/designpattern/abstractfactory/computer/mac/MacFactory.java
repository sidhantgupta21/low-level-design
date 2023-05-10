package designpattern.abstractfactory.computer.mac;

import designpattern.abstractfactory.computer.IMouse;
import designpattern.abstractfactory.computer.IComputer;
import designpattern.abstractfactory.computer.IKeyBoard;

public class MacFactory implements IComputer {

    @Override
    public IMouse getButton() {
        return new MacMouse();
    }

    @Override
    public IKeyBoard getTextBox() {
        return new MacKeyBoard();
    }
}
