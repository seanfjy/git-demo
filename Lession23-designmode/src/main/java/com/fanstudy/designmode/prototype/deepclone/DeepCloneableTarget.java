package com.fanstudy.designmode.prototype.deepclone;

import java.io.Serial;
import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
