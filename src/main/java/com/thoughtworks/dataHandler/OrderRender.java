package com.thoughtworks.dataHandler;

import com.thoughtworks.Dish;

import java.util.ArrayList;

public class OrderRender {
  private final ArrayList<Dish> menu;
  private final int[] subtotal;
  private final String strategy;

  public OrderRender(ArrayList<Dish> menu, int[] subtotal, String strategy) {
    this.menu = menu;
    this.subtotal = subtotal;
    this.strategy = strategy;
  }

  public String renderReceipt() {
    StringBuilder receipt = new StringBuilder("============= 订餐明细 =============\n");
    for (int i = 0; i < menu.size(); i++) {
      Dish dish = menu.get(i);
      receipt.append(dish.getName()).append(" x ").append(dish.getCount())
        .append(" = ").append(subtotal[i]).append("元\n");
    }
    receipt.append(strategy);
    receipt.append("===================================");
    return receipt.toString();
  }

}
