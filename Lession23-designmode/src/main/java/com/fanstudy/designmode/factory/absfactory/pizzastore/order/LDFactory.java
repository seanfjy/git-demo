package com.fanstudy.designmode.factory.absfactory.pizzastore.order;

import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.LDCheessePizza;
import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheessePizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
