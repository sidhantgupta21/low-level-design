package designpattern.decorator;

public class CasualDressDecorator extends DressDecorator {

    public CasualDressDecorator(IDress dress) {
        super(dress);
    }

    @Override
    public String getDescription() {
        return "Casual Dress created from " + dress.getDescription();
    }

    @Override
    public int cost() {
        return 30 + dress.cost();
    }
}
