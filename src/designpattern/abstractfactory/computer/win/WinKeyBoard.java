package designpattern.abstractfactory.computer.win;

import designpattern.abstractfactory.computer.IKeyBoard;

public class WinKeyBoard implements IKeyBoard {

    @Override
    public void installKeyBoard() {
        System.out.println("Win Keyboard Installed!!");
    }
}
