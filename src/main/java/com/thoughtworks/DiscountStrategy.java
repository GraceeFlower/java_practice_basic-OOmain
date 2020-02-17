package com.thoughtworks;

import java.util.ArrayList;

public interface DiscountStrategy {

  String getDiscountInfo(ArrayList<Dish> menu);
}
