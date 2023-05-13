package designpattern.strategy.impl;

import designpattern.strategy.IDiscountStrategy;

public class CashBackDiscountStrategy implements IDiscountStrategy {

    @Override
    public void getDiscount() {
        System.out.println("Cash back discount strategy !!!");
    }
}
