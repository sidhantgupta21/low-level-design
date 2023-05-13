package designpattern.strategy.impl;

import designpattern.strategy.IDiscountStrategy;

public class FlatDiscountStrategy implements IDiscountStrategy {

    @Override
    public void getDiscount() {
        System.out.println("Flat Discount Strategy!!");
    }
}
