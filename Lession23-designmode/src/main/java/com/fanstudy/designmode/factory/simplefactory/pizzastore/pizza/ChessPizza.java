package com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza;

public class ChessPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备ChessPizza中...");
    }
}
