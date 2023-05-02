package com.fanstudy.designmode.principle.inversion.improve;

public class DependencyInversion {
    public static void main(String[] args) {
        // 客户端无需改变
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Wechat());
    }
}

// 定义接口
interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件消息: hello world!";
    }
}
//增加微信
class Wechat implements IReceiver {
    @Override
    public String getInfo() {
        return "微信消息: we chat!";
    }
}

class Person {

    //使用对接口的依赖
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
