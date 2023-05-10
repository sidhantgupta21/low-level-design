package designpattern.abstractfactory.computer.win;

import designpattern.abstractfactory.computer.IMouse;
import designpattern.abstractfactory.computer.IComputer;
import designpattern.abstractfactory.computer.IKeyBoard;

public class WinFactory implements IComputer {

    @Override
    public IMouse getButton() {
        return new WinMouse();
    }

    @Override
    public IKeyBoard getTextBox() {
        return new WinKeyBoard();
    }
}
