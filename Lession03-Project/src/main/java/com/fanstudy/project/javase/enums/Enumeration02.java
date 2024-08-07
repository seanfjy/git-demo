package com.fanstudy.project.javase.enums;

import lombok.Getter;

/**
 * 自定义枚举类
 */
public class Enumeration02 {
    public static void main(String[] args) {

        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}
@Getter
class Season {
    private final String name;
    private final String desc;

    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}