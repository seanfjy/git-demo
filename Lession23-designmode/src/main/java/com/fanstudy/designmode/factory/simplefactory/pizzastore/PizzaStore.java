package com.fanstudy.designmode.factory.simplefactory.pizzastore;

import com.fanstudy.designmode.factory.simplefactory.pizzastore.order.OrderPizza;

public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();
        new OrderPizza(new SimpleFactory());
        System.out.println("退出程序");
    }
}
