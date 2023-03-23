package com.fanstudy.pk3;

public sealed class Square extends Shape permits LongSquare{
    @Override
    public void draw() {
        System.out.println("正方形...");
    }
}
