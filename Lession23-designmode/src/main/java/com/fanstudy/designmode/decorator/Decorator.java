package com.fanstudy.designmode.decorator;

public class Decorator extends Drink{

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public double cost() {
        return getPrice() + obj.cost() ;
    }

    @Override
    public String getDes() {
        //obj.getDes() 被装饰者的信息
        return des+" "+ getPrice()+ " && "+obj.getDes();
    }
}
