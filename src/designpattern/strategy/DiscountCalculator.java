package designpattern.strategy;

public class DiscountCalculator {

    private IDiscountStrategy discountStrategy;

    public DiscountCalculator(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void calculateDiscount() {
        discountStrategy.getDiscount();
    }

    public void setDiscountStrategy(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}
