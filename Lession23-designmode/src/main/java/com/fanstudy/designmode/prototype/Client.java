package com.fanstudy.designmode.prototype;

public class Client {
    public static void main(String[] args) {

        //原型模式
        Sheep sheep = new Sheep("tom",1,"白色");

        Sheep clone2 = sheep.clone();
        Sheep clone3 = sheep.clone();
        Sheep clone4 = sheep.clone();
        Sheep clone5 = sheep.clone();
        System.out.println(clone2);
        System.out.println(clone3);
        System.out.println(clone4);
        System.out.println(clone5);



    }
}
