package com.fanstudy.pk4;

public sealed class SomeServiceImpl implements SomeService permits OrderService {
    @Override
    public void doThing() {

    }
}
