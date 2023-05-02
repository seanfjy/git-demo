package com.fanstudy.designmode.factory.factorymethod.pizzastore.order;

import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.BJCheessePizza;
import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheessePizza();
        } else if (orderType.equals("pepper")) {

            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
