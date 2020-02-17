package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<Dish> menu = getMenu(selectedItems);
    int[] subtotal = getSubtotal(menu);
    String strategy = getStrategy(menu, subtotal);
    return printReceipt(menu, subtotal, strategy);
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

  public String getStrategy(ArrayList<Dish> menu, int[] subtotal) {
    ArrayList<Integer> halfOffInfo = calculateHalfOff(menu);
    int total = calculateTotal(subtotal);
    int discount = calculateFullOff(total);
    StringBuilder strategy = new StringBuilder();
      if (discount > 0) {
        strategy.append("-----------------------------------\n").append("使用优惠:\n");
        if (discount < halfOffInfo.get(halfOffInfo.size() - 1)) {
          strategy.append("指定菜品半价(");
          int infoLen = halfOffInfo.size();
          for (int i = 0; i < infoLen - 1; i++) {
            strategy.append(menu.get(i).getName());
            if (i != infoLen - 2) {
              strategy.append("，");
            }
          }
          strategy.append(")，省").append(halfOffInfo.get(infoLen - 1)).append("元\n");
        } else {
          strategy.append("满30减6元，省6元\n");
        }
      }
    return strategy.toString();
  }

  public int calculateTotal(int[] subtotal) {
    int total = 0;
    for (int i: subtotal) {
      total += i;
    }
    return total;
  }

  public ArrayList<Integer> calculateHalfOff(ArrayList<Dish> menu) {
    ArrayList<Integer> halfOffInfo = new ArrayList<>();
    int reducePrice = 0;
    for (int i = 0; i < menu.size(); i++) {
      Dish dish = menu.get(i);
      if(DataProvider.getHalfDishIds().contains(dish.getId())) {
        reducePrice += (int)dish.getPrice() / 2;
        halfOffInfo.add(i);
      }
    }
    halfOffInfo.add(reducePrice);
    return halfOffInfo;
  }

  public int calculateFullOff(int total) {
    int reducePrice = 0;
    if (30 <= total) {
      reducePrice = 6;
    }
    return reducePrice;
  }

  public String printReceipt(ArrayList<Dish> menu, int[] subtotal, String strategy) {
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
