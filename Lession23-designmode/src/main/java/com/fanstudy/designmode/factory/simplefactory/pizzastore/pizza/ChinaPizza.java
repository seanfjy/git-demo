package com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza;

public class ChinaPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备ChinaPizza中...");
    }
}
