package com.thoughtworks;

import java.util.ArrayList;

public class MenuParser {
  private final String rawMenu;
  private ArrayList<Dish> menuList = new ArrayList<>();

  public MenuParser(String rawMenu) {
    this.rawMenu = rawMenu;
  }

  public ArrayList<Dish> getMenuList() {
    String[] items = rawMenu.split(",");
    for (String i: items) {
      String[] item = i.split(" x ");
      for (Dish j: DataProvider.getDishes()) {
        if (j.getId().equals(item[0])) {
          menuList.add(j);
          menuList.get(menuList.size() - 1).setCount(item[1]);
        }
      }
    }
    return menuList;
  }
}
