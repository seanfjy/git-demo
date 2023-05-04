package com.fanstudy.designmode.build.imporve;

public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        house.setBase("5m");
        System.out.println("普通房打地基5米");

    }

    @Override
    public void buildWalls() {
        house.setWalls("10cm");
        System.out.println("普通房砌墙10cm");
    }

    @Override
    public void roofed() {
        house.setRoof("不透明");
        System.out.println("普通房封顶");
    }
}
