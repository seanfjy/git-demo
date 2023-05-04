package com.fanstudy.designmode.build.imporve;

public class HightBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        house.setBase("50m");
        System.out.println("高楼打地基50米");

    }

    @Override
    public void buildWalls() {
        house.setWalls("20cm");
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        house.setRoof("透明");
        System.out.println("高楼透明封顶");
    }
}
