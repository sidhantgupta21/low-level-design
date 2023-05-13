package designpattern.abstractfactory.computer;

public class ComputerClient {

    public static void main(String[] args) {

        IComputer computer = ComputerAbstractFactory.getComputerFactory("mac");

        IMouse mouse = computer.getMouse();
        mouse.installMouse();

        IKeyBoard keyBoard = computer.getKeyboard();
        keyBoard.installKeyBoard();

    }
}
