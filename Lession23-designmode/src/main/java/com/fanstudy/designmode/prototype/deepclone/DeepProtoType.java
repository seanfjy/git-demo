package com.fanstudy.designmode.prototype.deepclone;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class DeepProtoType implements Serializable, Cloneable {
    private String name;

    private DeepCloneableTarget deepCloneableTarget;

    // 重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep;

        deep = super.clone();

        DeepProtoType deepProtoType = (DeepProtoType)deep;

        deepProtoType.setDeepCloneableTarget((DeepCloneableTarget)deepProtoType.getDeepCloneableTarget().clone());

        return deepProtoType;
    }

    // 深拷贝,通过对象序列化

    public DeepProtoType deepClone() {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(this);

            DeepProtoType deepCopy;
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bis)) {

                deepCopy = (DeepProtoType)ois.readObject();
            }

            return deepCopy;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
