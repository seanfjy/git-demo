package com.fanstudy.designmode.facade;

public class TheaterLight {

    private TheaterLight() {}

    private static TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on");
    }

    public void off() {
        System.out.println("TheaterLight off");
    }

    public void bright() {
        System.out.println("TheaterLight is bright");
    }
}
