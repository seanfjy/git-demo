package com.fanstudy.designmode.factory.absfactory.pizzastore.pizza;


public class BJCheessePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的奶酪pizza");
        System.out.println("北京的奶酪pizza,准备材料");
    }
}
