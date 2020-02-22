package com.thoughtworks.strategy;

import com.thoughtworks.dataHandler.DataProvider;
import com.thoughtworks.Dish;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> halfOffDish = new ArrayList<>();
        for (Dish dish : menu) {
            if (DataProvider.getHalfDishIds().contains(dish.getId())) {
                halfOffDish.add(dish.getName());
            }
        }
        strategy.append(String.join("，", halfOffDish))
            .append(")，省").append(this.getDiscountMoney()).append("元\n");
        return strategy.toString();
    }
}
