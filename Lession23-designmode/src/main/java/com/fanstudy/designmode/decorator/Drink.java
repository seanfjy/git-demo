package com.fanstudy.designmode.decorator;

public abstract class Drink {
    public String des;//描述

    private double price = 0.0;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //计算费用的抽象方法
    public abstract double cost();
}
