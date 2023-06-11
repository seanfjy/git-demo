package com.fanstudy.designmode.proxy.staticproxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师正在教学...");
    }
}
