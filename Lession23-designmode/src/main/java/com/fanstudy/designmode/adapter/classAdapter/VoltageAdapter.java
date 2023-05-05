package com.fanstudy.designmode.adapter.classAdapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        // 获取到220V电压
        int src = output220V();
        return src / 44;
    }
}
