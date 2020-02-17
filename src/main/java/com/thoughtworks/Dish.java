package com.thoughtworks;

public class Dish {

  private String id;
  private String name;
  private double price;
  private String count;

  public Dish(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getCount() {
    return Integer.parseInt(count);
  }

  public void setCount(String count) {
    this.count = count;
  }
}
