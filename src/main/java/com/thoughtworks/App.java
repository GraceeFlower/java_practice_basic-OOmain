package com.thoughtworks;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner getOrder = new Scanner(System.in);
    System.out.println("请点菜：");
    String selectedItems = getOrder.nextLine();
    Restaurant restaurant = new Restaurant();
    System.out.println("这是您的订单详情：");
    System.out.println(restaurant.bestCharge(selectedItems));
  }
}
