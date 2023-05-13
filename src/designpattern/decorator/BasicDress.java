package designpattern.decorator;

public class BasicDress implements IDress {

    @Override
    public String getDescription() {
        return "Basic dress!!";
    }

    @Override
    public int cost() {
        return 100;
    }
}
