package com.fanstudy.pk1;

import java.util.StringJoiner;

public record ProductRecord(Integer id, String name, Integer qry) implements PrintInterface {
    @Override
    public void print() {
        StringJoiner stringJoiner = new StringJoiner("-");
        StringJoiner s = stringJoiner.add(id.toString()).add(name).add(qry.toString());
        System.out.println("商品信息 = " + s);
    }
}
