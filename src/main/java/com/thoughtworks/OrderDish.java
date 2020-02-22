package com.thoughtworks;

public class OrderDish {
    private final Dish dishInfo;
    private int dishCount;

    public OrderDish(Dish dishInfo, int dishCount) {
        this.dishInfo = dishInfo;
        this.dishCount = dishCount;
    }

    public Dish getDishInfo() {
        return dishInfo;
    }

    public int getDishCount() {
        return dishCount;
    }

}
