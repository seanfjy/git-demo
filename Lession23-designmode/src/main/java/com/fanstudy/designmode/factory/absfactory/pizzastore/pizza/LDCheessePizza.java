package com.fanstudy.designmode.factory.absfactory.pizzastore.pizza;


public class LDCheessePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪pizza");
        System.out.println("伦敦的奶酪pizza,准备材料");
    }
}
