package com.fanstudy.designmode.principle.singleresponsibility;

public class SingleResponsibilityTwo {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();

        roadVehicle.run("汽车");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

/*
1.遵守单一职责原则
2. 但是这样做的改动很大，即将类分解，同时修改客户端
3. 改进：直接修改Vehicle 类，改动的代码会比较少
*/
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行...");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在天空上运行...");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在水上运行...");
    }
}