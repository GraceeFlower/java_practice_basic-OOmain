package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<Dish> menu = new MenuParser(selectedItems).getMenuList();
    int[] subtotal = getSubtotal(menu);
    String strategy = getStrategy(menu, subtotal);
    return new OrderRender(menu, subtotal, strategy).renderReceipt();
  }

  public int[] getSubtotal(ArrayList<Dish> menu) {
    int[] subtotal = new int[menu.size()];
    for (int i = 0; i < subtotal.length; i++) {
      subtotal[i] = menu.get(i).getCount() * (int) menu.get(i).getPrice();
    }
    return subtotal;
  }

  public String getStrategy(ArrayList<Dish> menu, int[] subtotal) {
    int total = calculateTotal(subtotal);
    StringBuilder strategy = new StringBuilder();
    FullOffStrategy fullOff = new FullOffStrategy();
    HalfOffStrategy halfOff = new HalfOffStrategy(menu);
    if (30 <= total) {
      strategy.append("-----------------------------------\n").append("使用优惠:\n");
      int fullReduce = fullOff.getDiscountMoney();
      int halfReduce = halfOff.getDiscountMoney();
      if (fullReduce < halfReduce) {
        total -= halfReduce;
        strategy.append(halfOff.getDiscountInfo());
      } else {
        total -= fullReduce;
        strategy.append(fullOff.getDiscountInfo());
      }
    }
    strategy.append("-----------------------------------\n总计：").append(total).append("元\n");
    return strategy.toString();
  }

  public int calculateTotal(int[] subtotal) {
    int total = 0;
    for (int i: subtotal) {
      total += i;
    }
    return total;
  }
}
