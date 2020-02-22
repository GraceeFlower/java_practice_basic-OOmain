package com.thoughtworks.dataHandler;

import com.thoughtworks.OrderDish;

import java.util.ArrayList;

public class OrderRender {
    private final ArrayList<OrderDish> menu;
    private final int[] subtotal;
    private final String strategy;
    private final int total;

    public OrderRender(ArrayList<OrderDish> menu, int[] subtotal, String strategy, int total) {
        this.menu = menu;
        this.subtotal = subtotal;
        this.strategy = strategy;
        this.total = total;
    }

    public String getMenuInfo() {
        StringBuilder menuInfo = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            OrderDish dish = menu.get(i);
            menuInfo.append(dish.getDishInfo().getName()).append(" x ").append(dish.getDishCount())
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
