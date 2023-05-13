package designpattern.strategy;

import designpattern.strategy.impl.CashBackDiscountStrategy;
import designpattern.strategy.impl.FlatDiscountStrategy;

public class StrategyClient {

    public static void main(String[] args) {

        DiscountCalculator discountCalculator = new DiscountCalculator(new FlatDiscountStrategy());
        discountCalculator.calculateDiscount();

        discountCalculator.setDiscountStrategy(new CashBackDiscountStrategy());
        discountCalculator.calculateDiscount();
    }
}
