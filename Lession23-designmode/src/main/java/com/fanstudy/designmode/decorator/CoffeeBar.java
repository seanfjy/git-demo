package com.fanstudy.designmode.decorator;

public class CoffeeBar {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println("费用1="+order.cost());
        System.out.println("描述1="+order.getDes());

        //加入奶牛
        order = new Milk(order);
        System.out.println("费用2="+order.cost());
        System.out.println("描述2="+order.getDes());

        //加入巧克力
        order = new Chocolate(order);
        System.out.println("费用3="+order.cost());
        System.out.println("描述3="+order.getDes());
        //加入巧克力
        order = new Chocolate(order);
        System.out.println("费用4="+order.cost());
        System.out.println("描述4="+order.getDes());
    }
}
