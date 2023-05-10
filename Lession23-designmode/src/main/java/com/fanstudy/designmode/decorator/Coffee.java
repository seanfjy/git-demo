package com.fanstudy.designmode.decorator;

public class Coffee extends Drink{
    @Override
    public double cost() {
        return super.getPrice();
    }
}
