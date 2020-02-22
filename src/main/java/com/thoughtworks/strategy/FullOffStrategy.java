package com.thoughtworks.strategy;

import com.thoughtworks.dataHandler.DataProvider;

public class FullOffStrategy implements DiscountStrategy {

    private final int total;
    private final int standardPrice = DataProvider.getFullReductionLimit();
    private final int fullReduction = DataProvider.getFullReduction();

    public FullOffStrategy(int total) {
        this.total = total;
    }

    @Override
    public int getDiscountMoney() {
        return standardPrice > total ? 0 : fullReduction;
    }

    @Override
    public String getDiscountInfo() {
        return String.format("满%s减%s元，省%s元\n", standardPrice, fullReduction, fullReduction);
    }
}
