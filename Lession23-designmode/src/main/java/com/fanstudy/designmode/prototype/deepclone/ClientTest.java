package com.fanstudy.designmode.prototype.deepclone;

public class ClientTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();

        p.setName("lisi");
        p.setDeepCloneableTarget(new DeepCloneableTarget("aa","bb"));

//        DeepProtoType clone = (DeepProtoType) p.clone();

        DeepProtoType clone = p.deepClone();
        System.out.println("p.name "+p.getName()+" p.deepCloneableTarget "+p.getDeepCloneableTarget());
        System.out.println("clone.name "+clone.getName()+" clone.deepCloneableTarget "+clone.getDeepCloneableTarget());
    }
}
