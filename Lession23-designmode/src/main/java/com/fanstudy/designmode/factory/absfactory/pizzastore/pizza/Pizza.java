package com.fanstudy.designmode.factory.absfactory.pizzastore.pizza;

import lombok.Data;

// 抽象类
@Data
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + "烘烤中...");
    }

    public void cut() {
        System.out.println(name + "切割中...");
    }

    public void box() {
        System.out.println(name + "打包中...");
    }
}
