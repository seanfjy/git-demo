package com.fanstudy.designmode.factory.simplefactory.pizzastore;

import com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza.ChessPizza;
import com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza.Pizza;

public class SimpleFactory {
    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new ChessPizza();
            pizza.setName(" 奶酪披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName(" 胡椒披萨");
        }

        return pizza;

    }
}
