package com.fanstudy.designmode.flyweight;

public class ConcreteWebSite extends Website{
    //内部状态
    private String type = "";//网站发布的类型

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布类型:"+ type+" 在使用中...,使用者:"+user.getName());
    }
}
