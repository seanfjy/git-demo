package com.fanstudy.designmode.factory.factorymethod.pizzastore.order;

public class PizzaStore {
    public static void main(String[] args) {
        String loc = "ld";
        if (loc.equals("bj")){

            //创建北京口味的各种pizza
//        new BJOrderPizza();
        }else if (loc.equals("ld")){
            new LDOrderPizza();
        }
    }
}
