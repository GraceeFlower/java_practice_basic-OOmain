package com.thoughtworks;

import java.util.ArrayList;

public class FullOffStrategy implements DiscountStrategy {

  public int getDiscountMoney() {
    return 6;
  }

  @Override
  public String getDiscountInfo(ArrayList<Dish> menu) {
    return "满30减6元，省6元\n";
  }
}
