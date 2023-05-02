package com.fanstudy.designmode.factory.factorymethod.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fanstudy.designmode.factory.factorymethod.pizzastore.pizza.Pizza;


public abstract class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;// pizza类型
        do {
            orderType = getType();

            pizza = createPizza(orderType);

            if (pizza != null) {
                // 输出pizza 制作过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("没有该类型的披萨");
                break;
            }
        } while (true);
    }

    abstract Pizza createPizza(String orderType);

    // public OrderPizza(SimpleFactory simpleFactory) {
    // setFactory(simpleFactory);
    // }
    //
    // SimpleFactory simpleFactory;
    //
    // Pizza pizza = null;
    //
    // public void setFactory(SimpleFactory simpleFactory) {
    // this.simpleFactory = simpleFactory;
    // do {
    // String orderType = getType();
    // pizza = SimpleFactory.createPizza(orderType);
    // if (pizza != null) {
    // // 输出pizza 制作过程
    // pizza.prepare();
    // pizza.bake();
    // pizza.cut();
    // pizza.box();
    // } else {
    // System.out.println("没有该类型pizza");
    // break;
    // }
    //
    // } while (true);
    // }

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
