package com.fanstudy.designmode.adapter.objectAdapter;

public class VoltageAdapter implements Voltage5V {

    private final Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (voltage220V != null){
            // 获取到220V电压
            int src = voltage220V.output220V();
            dst = src / 44;
        }

        return dst;
    }
}
