package com.fanstudy.project.javase;

public class Finalize_ {
    // 如果程序员不重写finalize,那么就会调用Object类的finalize, 即默认处理
    // 如果程序员重写了finalize, 就可以实现自己的逻辑
    public static void main(String[] args) throws InterruptedException {
        Car bmw = new Car("宝马");
        // 这时car对象就是一个垃圾
        // 垃圾回收器就会回收(销毁)对象,
        // 在销毁对象前，会调用该对象的finalize 方法
        bmw = null;
        System.gc();// 主动调用垃圾回收器
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("程序退出了....");
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    // 重写finalize
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁汽车" + name);
        System.out.println("释放了某些资源...");
    }
}
