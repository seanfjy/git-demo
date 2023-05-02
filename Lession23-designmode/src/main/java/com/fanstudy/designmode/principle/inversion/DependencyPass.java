package com.fanstudy.designmode.principle.inversion;

/**
 * 依赖传递的三种方式
 */
public class DependencyPass {
    public static void main(String[] args) {

        Mi mi = new Mi();
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.open(mi);

//        OpenAndClose openAndClose = new OpenAndClose(mi);
//        openAndClose.open();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.set(mi);
        openAndClose.open();
    }
}
/*// 方式1： 通过接口传递实现依赖
// 开关的接口
interface IOpenAndClose{
    void open(ITV tv);
}
//ITV 接口
interface ITV{
    void play();
}
class Mi implements ITV{
    @Override
    public void play() {
        System.out.println("小米电视机,打开");
    }
}
//实现接口
class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV tv) {
        tv.play();
    }
}*/
/*
//方式2:通过构造方法依赖传递
interface IOpenAndClose{
    void open();
}
//ITV 接口
interface ITV{
    void play();
}
class Mi implements ITV{
    @Override
    public void play() {
        System.out.println("小米电视机,打开");
    }
}
//实现接口
class OpenAndClose implements IOpenAndClose{

    private ITV tv;

    //构造方法
    public OpenAndClose(ITV tv){
        this.tv = tv;
    }
    @Override
    public void open() {
        tv.play();
    }
}*/
//方式3:通过setter方法传递
interface IOpenAndClose{
    void open();
    void set(ITV tv);
}
//ITV 接口
interface ITV{
    void play();
}
class Mi implements ITV{
    @Override
    public void play() {
        System.out.println("小米电视机,打开");
    }
}
//实现接口
class OpenAndClose implements IOpenAndClose{

    private ITV tv;

    @Override
    public void open() {
        tv.play();
    }

    @Override
    public void set(ITV tv) {
        this.tv = tv;
    }
}
