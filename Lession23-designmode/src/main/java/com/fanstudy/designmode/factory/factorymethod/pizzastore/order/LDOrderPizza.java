package com.fanstudy.designmode.factory.factorymethod.pizzastore.order;

import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.LDCheessePizza;
import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.Pizza;


public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheessePizza();
        } else if (orderType.equals("pepper")) {

            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
