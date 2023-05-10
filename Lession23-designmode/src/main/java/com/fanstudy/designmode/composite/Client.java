package com.fanstudy.designmode.composite;

public class Client {
    public static void main(String[] args) {
        //从大到小创建对象
        University university = new University("清华大学", "中国顶级大学");
        
        //创建学院
        College c1 = new College("计算机学院", "计算机学院");
        College c2 = new College("分子工程学院", "分子工程学院");

        c1.add(new Department("软件工程","软件工程不错"));
        c1.add(new Department("软件工程2","软件工程2不错"));
        c1.add(new Department("软件工程3","软件工程3不错"));

        c2.add(new Department("材料化学","材料化学nb"));
        c2.add(new Department("材料化学2","材料化学2nb"));
        c2.add(new Department("材料化学3","材料化学3nb"));


        university.add(c1);
        university.add(c2);

        university.print();

//        c1.print();
//
//        c2.print();


    }
}
