package com.thoughtworks.dataHandler;

import com.thoughtworks.Dish;
import com.thoughtworks.OrderDish;

import java.util.ArrayList;

public class MenuParser {
    private final String rawMenu;
    private ArrayList<OrderDish> menuList = new ArrayList<>();

    public MenuParser(String rawMenu) {
        this.rawMenu = rawMenu;
    }

    public ArrayList<OrderDish> getMenuList() {
        String[] items = rawMenu.split(",");
        for (String i: items) {
            String[] item = i.split(" x ");
            for (Dish j: DataProvider.getDishes()) {
                if (j.getId().equals(item[0])) {
                    menuList.add(new OrderDish(j, Integer.parseInt(item[1])));
                }
            }
        }
        return menuList;
    }
}
