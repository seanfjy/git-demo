package com.fanstudy.designmode.factory.absfactory.pizzastore.order;

import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.BJCheessePizza;
import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.Pizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheessePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
