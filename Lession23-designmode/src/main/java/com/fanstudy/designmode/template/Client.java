package com.fanstudy.designmode.template;

public class Client {
    public static void main(String[] args) {
        System.out.println("========制作黑豆浆=====");
        SoyaMilk blackBeanSoyaMilk = new BlackBeanSoyaMilk();
        blackBeanSoyaMilk.make();


        System.out.println("========制作花生豆浆=====");
        SoyaMilk pennutSoyaMilk = new PennutSoyaMilk();
        pennutSoyaMilk.make();

    }
}
