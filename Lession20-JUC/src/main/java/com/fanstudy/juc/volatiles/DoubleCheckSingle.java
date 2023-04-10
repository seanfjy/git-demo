package com.fanstudy.juc.volatiles;

public class DoubleCheckSingle {
    private volatile static DoubleCheckSingle instance;

    private DoubleCheckSingle() {}

    public static DoubleCheckSingle getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingle.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingle();
                }
            }
        }
        return instance;
    }

}
