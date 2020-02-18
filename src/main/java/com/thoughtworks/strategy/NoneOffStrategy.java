package com.thoughtworks.strategy;

public class NoneOffStrategy implements DiscountStrategy {

    @Override
    public String getDiscountInfo() {
        return "";
    }

    @Override
    public int getDiscountMoney() {
        return 0;
    }
}
