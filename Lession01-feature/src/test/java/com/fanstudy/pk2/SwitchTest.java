package com.fanstudy.pk2;

import org.junit.Test;

public class SwitchTest {
    @Test
    public void test01() {
        int week = 4;
        String memo = "";// 表示计算结果
        switch (week) {
            case 1 -> memo = "星期日,休息";
            case 2, 3, 4, 5, 6 -> memo = "工作日";
            case 7 -> memo = "星期六,休息";
            default -> throw new RuntimeException("无效的日期");
        }

        System.out.println("memo =" + memo);
    }

    @Test
    public void test02() {
        int week = 2;
        String memo = switch (week) {
            case 1:
                yield "星期日";
            case 2, 3, 4, 5, 6:
                yield "工作日";
            case 7:
                yield "星期六";
            default:
                yield "无效的日期";
        };
        System.out.println("memo =" + memo);

    }

    @Test
    public void test03() {
        int week = 1;
        String memo = switch (week) {
            case 1 -> {
                System.out.println("星期日执行了");
                yield "星期日";
            }
            case 2, 3, 4, 5, 6 -> {
                System.out.println("工作日执行了");
                yield "2-6工作日";
            }
            case 7 -> {
                System.out.println("星期六执行了");
                yield "星期六";
            }
            default -> {
                System.out.println("其他执行了");
                yield "无效的日期";
            }
        };
        System.out.println("memo =" + memo);

    }

    @Test
    public void test04() {
        //创建对象
        Line line = new Line(10, 20);
        Rectangle rectangle = new Rectangle(20, 50);
        Shape shape = new Shape(50, 80);

        //jdk 19 才支持
        Object obj = line;
//        int result = switch (obj){
//            case Line(int x,int y)->{
//                System.out.println("图形是Line,x="+x+" y="+y);
//                    yield x+y;
//            }
//        };
    }
}
