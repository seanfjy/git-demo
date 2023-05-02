package com.fanstudy.designmode.factory.absfactory.pizzastore.pizza;


public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println("伦敦的胡椒pizza,准备材料");
    }
}
