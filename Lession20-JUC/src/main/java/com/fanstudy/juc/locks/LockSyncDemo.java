package com.fanstudy.juc.locks;


/**
 * @auther zzyy
 * @create 2022-01-18 15:56
 */
public class LockSyncDemo
{

    Object object = new Object();

    public void m1()
    {
        //代码块  使用的是monitorenter 和monitorexit
        synchronized (object)
        {
            System.out.println("----hello synchronized code block");
            throw new RuntimeException("-----exp");
        }
    }

    public synchronized void m2()
    {
        System.out.println("----hello synchronized m2");
    }

    public static synchronized void m3()
    {
        System.out.println("----hello static synchronized m3");
    }


    public static void main(String[] args)
    {

    }
}
