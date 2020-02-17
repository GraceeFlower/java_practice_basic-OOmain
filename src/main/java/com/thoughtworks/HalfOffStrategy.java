package com.thoughtworks;

import java.util.ArrayList;

public class HalfOffStrategy implements DiscountStrategy {

  public int getDiscountMoney(ArrayList<Dish> menu) {
    int reducePrice = 0;
    for (Dish dish : menu) {
      if (DataProvider.getHalfDishIds().contains(dish.getId())) {
        reducePrice += (int) dish.getPrice() / 2;
      }
    }
    return reducePrice;
  }

  @Override
  public String getDiscountInfo(ArrayList<Dish> menu) {
    StringBuilder strategy = new StringBuilder("指定菜品半价(");
    for (Dish dish : menu) {
      if (DataProvider.getHalfDishIds().contains(dish.getId())) {
        strategy.append(dish.getName()).append("，");
      }
    }
    strategy.deleteCharAt(strategy.length() - 1).append(")，省")
      .append(this.getDiscountMoney(menu)).append("元\n");
    return strategy.toString();
  }
}