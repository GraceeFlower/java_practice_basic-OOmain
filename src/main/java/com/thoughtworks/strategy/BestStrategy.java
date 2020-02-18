package com.thoughtworks.strategy;

import com.thoughtworks.Dish;

import java.util.ArrayList;

public class BestStrategy {

    private final ArrayList<Dish> menu;
    private final int total;
    private int realTotal;

    public BestStrategy(int total, ArrayList<Dish> menu) {
        this.menu = menu;
        this.total = total;
    }

    public int getRealTotal() {
        return realTotal;
    }

    public String getBestStrategy() {
        realTotal = total;
        DiscountStrategy halfOff = new HalfOffStrategy(menu);
        DiscountStrategy fullOff = new FullOffStrategy(total);
        DiscountStrategy noneOff = new NoneOffStrategy();
        if (fullOff.getDiscountMoney() > noneOff.getDiscountMoney()) {
            StringBuilder strategy = new StringBuilder();
            strategy.append("-----------------------------------\n").append("使用优惠:\n");
            if (fullOff.getDiscountMoney() < halfOff.getDiscountMoney()) {
                realTotal = total - halfOff.getDiscountMoney();
                return strategy.append(halfOff.getDiscountInfo()).toString();
            } else {
                realTotal = total - fullOff.getDiscountMoney();
                return strategy.append(fullOff.getDiscountInfo()).toString();
            }
        }
        return noneOff.getDiscountInfo();
    }
}
