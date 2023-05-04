package com.fanstudy.designmode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sheep implements Cloneable{
    String name;
    Integer age;
    String color;

    @Override
    public Sheep clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
