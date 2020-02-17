package com.thoughtworks;

import java.util.ArrayList;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    ArrayList<String> menu = getMenu(selectedItems);
    return printReceipt(menu);
  }

  public ArrayList<String> getMenu(String selectedItems) {
    ArrayList<String> menu = new ArrayList<>();
    String[] items = selectedItems.split(",");
    for (String i: items) {
      String[] item = i.split(" x ");
      for (Dish j: DataProvider.getDishes()) {
        if (j.getId().equals(item[0])) {
          int subtotal = (int) (j.getPrice() * Integer.parseInt(item[1]));
          String dish = j.getName() + " x " + item[1] + " = " + subtotal + "元\n";
          menu.add(dish);
        }
      }
    }
    return menu;
  }

  public String printReceipt(ArrayList<String> menu) {
    StringBuilder test = new StringBuilder();
    for (String i: menu) {
      test.append(i);
    }
    return test.toString();
  }

}
