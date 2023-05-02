package com.fanstudy.designmode.principle.ocp.improve;

public class Ocp {
    public static void main(String[] args) {

        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());

        graphicEditor.drawShape(new Triangle());

        graphicEditor.drawShape(new OtherShape());

    }
}

// 一个用于绘图的类(使用方)
class GraphicEditor {
    //修改
    public void drawShape(Shape shape) {

        shape.draw();
    }


}

// 基类
abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("绘制圆形");
    }
}
//新增一个三角形
class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("绘制三角形");
    }
}

class OtherShape extends Shape {

    @Override
    void draw() {
        System.out.println("绘制其它图形");
    }
}