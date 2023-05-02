package com.fanstudy.designmode.principle.ocp;

public class Ocp {
    public static void main(String[] args) {

        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());

        graphicEditor.drawShape(new Triangle());

    }
}

// 一个用于绘图的类(使用方)
class GraphicEditor {
    //修改
    public void drawShape(Shape shape) {
        if (shape.m_type == 1) {
            drawRectangle(shape);
        } else if (shape.m_type == 2) {
            drawCircle(shape);
        } else if (shape.m_type == 3) {
            drawTriangle(shape);
        }
    }

    private void drawCircle(Shape shape) {
        System.out.println("绘制圆形");
    }

    private void drawRectangle(Shape shape) {
        System.out.println("绘制矩形");
    }

    //新增方法
    private void drawTriangle(Shape shape) {
        System.out.println("绘制三角形");
    }

}

// 基类
class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}
//新增一个三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}