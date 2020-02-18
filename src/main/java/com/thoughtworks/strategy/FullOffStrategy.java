package com.thoughtworks.strategy;

public class FullOffStrategy implements DiscountStrategy {

    private final int total;
    private final int standardPrice = 30;

    public FullOffStrategy(int total) {
        this.total = total;
    }

    @Override
    public int getDiscountMoney() {
        if (standardPrice <= total) {
            return 6;
        } else {
            return 0;
        }
    }

    @Override
    public String getDiscountInfo() {
        return "满" + standardPrice + "减6元，省6元\n";
    }
}
