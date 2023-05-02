package com.fanstudy.designmode.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fanstudy.designmode.factory.simplefactory.pizzastore.SimpleFactory;
import com.fanstudy.designmode.factory.simplefactory.pizzastore.pizza.Pizza;

public class OrderPizza {

    public OrderPizza() {
        // Pizza pizza = null;
        // String orderType;// pizza类型
        // do {
        // orderType = getType();
        // if (orderType.equals("greek")) {
        // pizza = new GreekPizza();
        // pizza.setName(" 希腊披萨");
        // } else if (orderType.equals("cheese")) {
        // pizza = new ChessPizza();
        // pizza.setName(" 奶酪披萨");
        // } else {
        // break;
        // }
        //
        // // 输出pizza 制作过程
        // pizza.prepare();
        // pizza.bake();
        // pizza.cut();
        // pizza.box();
        //
        // } while (true);
    }

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    SimpleFactory simpleFactory;

    Pizza pizza = null;

    public void setFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        do {
            String orderType = getType();
            pizza = SimpleFactory.createPizza(orderType);
            if (pizza != null) {
                // 输出pizza 制作过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("没有该类型pizza");
                break;
            }

        } while (true);
    }

    private String getType() {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza type:");
        String str = "";
        try {
            str = strin.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

}
