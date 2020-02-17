package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<Dish> menu = getMenu(selectedItems);
    int[] subtotal = getSubtotal(menu);
    return printReceipt(menu, subtotal);
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

  public int[] getSubtotal(ArrayList<Dish> menu) {
    int[] subtotal = new int[menu.size()];
    for (int i = 0; i < subtotal.length; i++) {
      subtotal[i] = menu.get(i).getCount() * (int) menu.get(i).getPrice();
    }
    return subtotal;
  }

  public String printReceipt(ArrayList<Dish> menu, int[] subtotal) {
    StringBuilder Receipt = new StringBuilder("============= 订餐明细 =============\n");
    for (int i = 0; i < menu.size(); i++) {
      Dish dish = menu.get(i);
      Receipt.append(dish.getName()).append(" x ").append(dish.getCount())
        .append(" = ").append(subtotal[i]).append("元\n");
    }
    return Receipt.toString();
  }

}
