package com.fanstudy.designmode.factory.absfactory.pizzastore.order;

import com.fanstudy.designmode.factory.absfactory.pizzastore.pizza.Pizza;

public interface AbsFactory {
    Pizza createPizza(String orderType);
}
