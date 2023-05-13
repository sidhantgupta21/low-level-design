package designpattern.decorator;

public class FormalDressDecorator extends DressDecorator {

    public FormalDressDecorator(IDress dress) {
        super(dress);
    }

    @Override
    public String getDescription() {
        return "Formal dress created from " + dress.getDescription();
    }

    @Override
    public int cost() {
        return 50 + dress.cost();
    }
}
