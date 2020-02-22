package com.thoughtworks;

import com.thoughtworks.dataHandler.MenuParser;
import com.thoughtworks.dataHandler.OrderRender;
import com.thoughtworks.strategy.BestStrategy;

import java.util.ArrayList;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        ArrayList<OrderDish> menu = new MenuParser(selectedItems).getMenuList();
        int[] subtotal = getSubtotal(menu);
        int total = calculateTotal(subtotal);
        BestStrategy strategy = new BestStrategy(total, menu);
        return new OrderRender(menu, subtotal, strategy.getBestStrategy(),
            strategy.getRealTotal()).renderReceipt();
    }

    public int[] getSubtotal(ArrayList<OrderDish> menu) {
        int[] subtotal = new int[menu.size()];
        for (int i = 0; i < subtotal.length; i++) {
            subtotal[i] = menu.get(i).getDishCount()
                * (int) menu.get(i).getDishInfo().getPrice();
        }
        return subtotal;
    }

    public int calculateTotal(int[] subtotal) {
        int total = 0;
        for (int i: subtotal) {
            total += i;
        }
        return total;
    }
}
