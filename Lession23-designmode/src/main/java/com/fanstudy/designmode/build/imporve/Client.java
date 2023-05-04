package com.fanstudy.designmode.build.imporve;



public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();
        System.out.println(house);

        HightBuilding hightBuilding = new HightBuilding();
        HouseDirector houseDirector2 = new HouseDirector(hightBuilding);
        House house2 = houseDirector2.constructHouse();
        System.out.println(house2);
    }
}
