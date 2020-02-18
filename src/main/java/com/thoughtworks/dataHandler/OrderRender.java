package com.thoughtworks.dataHandler;

import com.thoughtworks.Dish;

import java.util.ArrayList;

public class OrderRender {
    private final ArrayList<Dish> menu;
    private final int[] subtotal;
    private final String strategy;
    private final int total;

    public OrderRender(ArrayList<Dish> menu, int[] subtotal, String strategy, int total) {
        this.menu = menu;
        this.subtotal = subtotal;
        this.strategy = strategy;
        this.total = total;
    }

    public String getMenuInfo() {
        StringBuilder menuInfo = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            Dish dish = menu.get(i);
            menuInfo.append(dish.getName()).append(" x ").append(dish.getCount())
                .append(" = ").append(subtotal[i]).append("元\n");
        }
        return menuInfo.toString();
    }

    public String getTotal() {
        return "-----------------------------------\n总计："
            + total + "元\n";
    }

    public String renderReceipt() {
        return "============= 订餐明细 =============\n"
            + getMenuInfo()
            + strategy
            + getTotal()
            + "===================================";
    }

}
