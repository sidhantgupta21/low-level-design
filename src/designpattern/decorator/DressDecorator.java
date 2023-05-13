package designpattern.decorator;

public abstract class DressDecorator implements IDress {

    protected IDress dress;

    protected DressDecorator(IDress dress) {
        this.dress = dress;
    }
}
