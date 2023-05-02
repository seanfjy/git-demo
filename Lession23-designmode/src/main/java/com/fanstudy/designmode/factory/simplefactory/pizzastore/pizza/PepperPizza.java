package com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza;

public class PepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备PepperPizza中...");
    }
}
