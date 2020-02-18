package com.thoughtworks.strategy;

import com.thoughtworks.dataHandler.DataProvider;
import com.thoughtworks.Dish;

import java.util.ArrayList;

public class HalfOffStrategy implements DiscountStrategy {

    private ArrayList<Dish> menu;

    public HalfOffStrategy(ArrayList<Dish> menu) {
        this.menu = menu;
    }

    @Override
    public int getDiscountMoney() {

        int reducePrice = 0;
        for (Dish dish : menu) {
            if (DataProvider.getHalfDishIds().contains(dish.getId())) {
                reducePrice += (int) dish.getPrice() / 2;
            }
        }
        return reducePrice;
    }

    @Override
    public String getDiscountInfo() {
        StringBuilder strategy = new StringBuilder("指定菜品半价(");
        for (Dish dish : menu) {
            if (DataProvider.getHalfDishIds().contains(dish.getId())) {
                strategy.append(dish.getName()).append("，");
            }
        }
        strategy.deleteCharAt(strategy.length() - 1).append(")，省")
            .append(this.getDiscountMoney()).append("元\n");
        return strategy.toString();
    }
}
