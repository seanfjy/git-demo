package com.fanstudy.pk3;

public sealed class Shape permits Circle,Square, Rectangle {
    private Integer w;
    private Integer h;

    public void draw(){
        System.out.println("画一个图形");
    }
}
