package com.fanstudy.designmode.principle.singleresponsibility;


public class SingleResponsibilityThree {
    public static void main(String[] args) {
        VehicleAll vehicle = new VehicleAll();

        vehicle.run("汽车");
        vehicle.runWater("轮船");
        vehicle.runAir("飞机");
    }

}

/**
 * 1. 这种修改方法没有对原来的类没有做大的修改，只是增加方法
 * 2. 这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
 */
class VehicleAll {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行...");
    }
    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空上运行...");
    }
    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水上运行...");
    }
}
