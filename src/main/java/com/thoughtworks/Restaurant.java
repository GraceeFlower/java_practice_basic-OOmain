package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<Dish> menu = getMenu(selectedItems);
    return printReceipt(menu);
  }

  public ArrayList<Dish> getMenu(String selectedItems) {
    ArrayList<Dish> menu = new ArrayList<>();
    String[] items = selectedItems.split(",");
    for (String i: items) {
      String[] item = i.split(" x ");
      for (Dish j: DataProvider.getDishes()) {
        if (j.getId().equals(item[0])) {
          menu.add(j);
          menu.get(menu.size() - 1).setCount(item[1]);
        }
      }
    }
    return menu;
  }



  public String printReceipt(ArrayList<Dish> menu) {
    StringBuilder Receipt = new StringBuilder("============= 订餐明细 =============\n");
    for (Dish dish: menu) {
      Receipt.append(dish.getName()).append(" x ").append(dish.getCount())
        .append(" = ").append((int) dish.getPrice() * dish.getCount()).append("元\n");
    }
    return Receipt.toString();
  }

}
