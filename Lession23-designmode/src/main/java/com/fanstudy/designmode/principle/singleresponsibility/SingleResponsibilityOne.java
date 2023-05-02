package com.fanstudy.designmode.principle.singleresponsibility;


public class SingleResponsibilityOne {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }

}

/**
 * 交通工具类
 * 在方式1 的run 方法中，违反了单一职责原则
 * 解决的方案非常的简单，根据交通工具运行方法不同，分解成不同类即可
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行...");
    }
}
