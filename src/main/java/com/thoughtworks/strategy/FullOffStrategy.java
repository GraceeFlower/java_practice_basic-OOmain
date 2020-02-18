package com.thoughtworks.strategy;

public class FullOffStrategy implements DiscountStrategy {

  @Override
  public int getDiscountMoney() {
    return 6;
  }

  @Override
  public String getDiscountInfo() {
    return "满30减6元，省6元\n";
  }
}
