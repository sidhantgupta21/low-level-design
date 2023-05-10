package designpattern.abstractfactory.computer.mac;

import designpattern.abstractfactory.computer.IKeyBoard;

public class MacKeyBoard implements IKeyBoard {

    @Override
    public void installKeyBoard() {
        System.out.println("Mac keyborad installed!!");
    }
}
