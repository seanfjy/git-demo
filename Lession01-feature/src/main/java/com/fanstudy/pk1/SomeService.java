package com.fanstudy.pk1;

public class SomeService {
    //定义业务方法,判断年龄是否18
    public boolean isEligible(Object obj){
//        if (obj instanceof Person ){
//            return ((Person) obj).age() >= 18;
//        }
        if (obj instanceof Person p){
            return p.age() >= 18;
        }
        return false;
    }
}
