package com.fanstudy.project.javase;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmclock(() -> System.out.println("懒猪起床了"));
        cellphone.alarmclock(() -> System.out.println("小伙伴上课了"));
    }
}

interface Bell{
    void ring();
}

class Cellphone {
    public void alarmclock(Bell bell){
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}
