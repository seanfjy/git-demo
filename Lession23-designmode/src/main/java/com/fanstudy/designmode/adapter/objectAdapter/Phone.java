package com.fanstudy.designmode.adapter.objectAdapter;

public class Phone {

    //充电的方法
    public void charging(Voltage5V voltage5V){
        if (voltage5V.output5V() == 5){
            System.out.println("电压为5v,可以充电了...");
        }else{
            System.out.println("电压不为5v,无法充电...");
        }
    }

}
