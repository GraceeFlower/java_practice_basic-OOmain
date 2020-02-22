package com.thoughtworks.strategy;

import com.thoughtworks.OrderDish;
import com.thoughtworks.dataHandler.DataProvider;

import java.util.ArrayList;

public class HalfOffStrategy implements DiscountStrategy {

    private ArrayList<OrderDish> menu;

    public HalfOffStrategy(ArrayList<OrderDish> menu) {
        this.menu = menu;
    }

    @Override
    public int getDiscountMoney() {

        int reducePrice = 0;
        for (OrderDish dish : menu) {
            if (DataProvider.getHalfDishIds().contains(dish.getDishInfo().getId())) {
                reducePrice += (int) dish.getDishInfo().getPrice() / 2;
            }
        }
        return reducePrice;
    }

    @Override
    public String getDiscountInfo() {
        StringBuilder strategy = new StringBuilder("指定菜品半价(");
        ArrayList<String> halfOffDish = new ArrayList<>();
        for (OrderDish dish : menu) {
            if (DataProvider.getHalfDishIds().contains(dish.getDishInfo().getId())) {
                halfOffDish.add(dish.getDishInfo().getName());
            }
        }
        strategy.append(String.join("，", halfOffDish))
            .append(")，省").append(this.getDiscountMoney()).append("元\n");
        return strategy.toString();
    }
}
