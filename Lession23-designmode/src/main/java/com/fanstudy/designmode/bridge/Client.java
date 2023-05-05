package com.fanstudy.designmode.bridge;

public class Client {
    public static void main(String[] args) {
        //获取折叠式手机(样式+品牌)
        FoldedPhone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
        FoldedPhone phone2 = new FoldedPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();

        UpRightPhone upRightPhone = new UpRightPhone(new XiaoMi());
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
    }
}
