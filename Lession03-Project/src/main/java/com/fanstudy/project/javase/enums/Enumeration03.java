package com.fanstudy.project.javase.enums;

import lombok.Getter;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);
    }
}

@Getter
enum Season2 {

    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热")/*, What()*/;

    private String name;
    private String desc;// 描述

    @SuppressWarnings("unused")
    Season2() {// 无参构造器

    }

    Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" + "name='" + name + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
