package designpattern.strategy.impl;

import designpattern.strategy.IDiscountStrategy;

public class CouponDiscountStrategy implements IDiscountStrategy {

    @Override
    public void getDiscount() {
        System.out.println("Coupon discount strategy!!!");
    }
}
