package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<String> menu = printMenu(selectedItems);
    StringBuilder test = new StringBuilder();
    for (String i: menu) {
      test.append(i);
    }
    return test.toString();
  }

  public ArrayList<String> printMenu(String selectedItems) {
    ArrayList<String> menu = new ArrayList<>();
    String[] items = selectedItems.split(",");
    for (String i: items) {
      String[] item = i.split(" x ");
      for (Dish j: DataProvider.getDishes()) {
        if (j.getId().equals(item[0])) {
          int subtotal = (int) (j.getPrice() * Integer.parseInt(item[1]));
          String dish = j.getName() + " x " + item[1] + " = " + subtotal;
          menu.add(dish);
        }
      }
    }
    return menu;
  }

}
